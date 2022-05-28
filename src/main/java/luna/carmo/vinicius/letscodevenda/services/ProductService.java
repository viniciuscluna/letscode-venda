package luna.carmo.vinicius.letscodevenda.services;


import luna.carmo.vinicius.letscodevenda.contracts.ProductContractDto;
import luna.carmo.vinicius.letscodevenda.exception.GeneralEndpointException;
import luna.carmo.vinicius.letscodevenda.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class ProductService {

    @Value("${external.clients.product}")
    private String host;

    private final WebClient webClient;

    public ProductService(){
        webClient = WebClient.builder().baseUrl(host).build();
    }

    public Mono<ProductContractDto> getProductById(String id){
//            return webClient
//                    .get()
//                    .uri("api/product/" + id)
//                    .retrieve()
//                    .onStatus(HttpStatus::is4xxClientError, clientResponse -> {
//                        if(clientResponse.statusCode() == HttpStatus.NOT_FOUND)
//                            return Mono.error(new NotFoundException("Produto não encontrado"));
//                        return Mono.error(new GeneralEndpointException(clientResponse.toString()));
//                    })
//                    .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new GeneralEndpointException(clientResponse.toString())))
//                    .bodyToMono(ProductContractDto.class);

        return Mono.just(new ProductContractDto(java.util.UUID.randomUUID().toString(), "Example",  20));
    }
}
