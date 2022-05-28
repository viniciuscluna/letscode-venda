package luna.carmo.vinicius.letscodevenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LetscodeVendaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LetscodeVendaApplication.class, args);
    }

}
