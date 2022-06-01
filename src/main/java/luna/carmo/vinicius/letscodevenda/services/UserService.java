package luna.carmo.vinicius.letscodevenda.services;

import luna.carmo.vinicius.letscodevenda.contracts.UserContractDto;
import luna.carmo.vinicius.letscodevenda.exception.GeneralEndpointException;
import luna.carmo.vinicius.letscodevenda.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService {


    private final WebClient webClient;

    public UserService(@Value("${external.clients.user}") String host){
        webClient = WebClient.builder().baseUrl(host).build();
    }

    public Mono<UserContractDto> getUserByEmail(String email){

        return webClient
                .get()
                .uri("/api/user/" + email)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> {
                    if(clientResponse.statusCode() == HttpStatus.NOT_FOUND)
                        return Mono.error(new NotFoundException("Usuário não encontrado"));
                    return Mono.error(new GeneralEndpointException(clientResponse.toString()));
                })
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new Exception("fdsf")))
                .bodyToMono(UserContractDto.class);

    }
}
