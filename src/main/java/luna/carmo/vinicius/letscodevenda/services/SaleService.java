package luna.carmo.vinicius.letscodevenda.services;

import lombok.RequiredArgsConstructor;
import luna.carmo.vinicius.letscodevenda.domain.Sale;
import luna.carmo.vinicius.letscodevenda.domain.SaleProduct;
import luna.carmo.vinicius.letscodevenda.domain.SaleUser;
import luna.carmo.vinicius.letscodevenda.dto.SaleDto;
import luna.carmo.vinicius.letscodevenda.dto.SaleRequestDto;
import luna.carmo.vinicius.letscodevenda.repositories.SaleRepository;
import luna.carmo.vinicius.letscodevenda.utils.SaleMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleService {


    private final SaleRepository repository;
    private final SaleMapper mapper;
    private final UserService userService;
    private final ProductService productService;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.template.default-topic}")
    private String topic;

    public Mono<SaleDto> getSaleById(String id){
        return mapper.map(repository.findById(id));
    }

    public Mono<SaleDto> persistSale(SaleRequestDto saleRequestDto) {
        //Validation
        var user = userService.getUserByEmail(saleRequestDto.getEmail()).map(m -> new SaleUser(m.getId(),m.getName()));
        var products = saleRequestDto.getProducts().stream().map(p ->
            productService.getProductById(p).map(m -> new SaleProduct(m.getId(),m.getName(),m.getPrice()))
        ).collect(Collectors.toList());

        var saleInsertion = new Sale();
        saleInsertion.setDate(new Date());
        saleInsertion.setCode(java.util.UUID.randomUUID().toString());
        saleInsertion.setUser(user.block());
        saleInsertion.setProducts(products.stream().map(m -> m.block()).collect(Collectors.toList()));
        saleInsertion.setTotalPrice((float)saleInsertion.getProducts().stream().mapToDouble(p->p.getPrice()).sum());
        var result = repository.save(saleInsertion);

        //Send to kafka topic for deletion
        saleRequestDto.getProducts().forEach(product ->{
            kafkaTemplate.send(topic,product);
        });


        return mapper.map(result);
    }

}
