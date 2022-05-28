package luna.carmo.vinicius.letscodevenda.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@RequiredArgsConstructor
public class KafkaTopicConfig {

//    @Value("${spring.kafka.template.default-topic}")
//    private String topic;
//
//    @Bean
//    public NewTopic sellProduct(){
//        return TopicBuilder.name(topic).build();
//    }
}
