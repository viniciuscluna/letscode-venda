package luna.carmo.vinicius.letscodevenda.utils;

import lombok.RequiredArgsConstructor;
import luna.carmo.vinicius.letscodevenda.domain.Sale;
import luna.carmo.vinicius.letscodevenda.dto.SaleDto;
import luna.carmo.vinicius.letscodevenda.dto.SaleProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleMapper {

    private final SaleUserMapper vendaUsuarioMapper;


    public Flux<SaleDto> map(Flux<Sale> venda){
        return venda.map(m -> new SaleDto(m.getCode(), m.getTotalPrice(), m.getDate(), vendaUsuarioMapper.map(m.getUser()) , m.getProducts().stream()
                        .map(p ->  new SaleProductDto(p.getId(), p.getName(),p.getPrice()))
                        .collect(Collectors.toList()))
                );
    }

    public Mono<SaleDto> map(Mono<Sale> venda){
        return venda.map(m -> new SaleDto(m.getCode(), m.getTotalPrice() ,m.getDate(), vendaUsuarioMapper.map(m.getUser()) , m.getProducts().stream()
                .map(p -> new SaleProductDto(p.getId(),p.getName(),p.getPrice()))
                .collect(Collectors.toList()))
        );
    }

    public SaleDto map(Sale venda){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(venda, SaleDto.class);
    }


    public Sale map(SaleDto venda) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(venda, Sale.class);
    }
}
