package br.coffeeandit.transactionbff.config;

import br.coffeeandit.transactionbff.dto.RequestTransactionDTO;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import reactor.kafka.sender.SenderOptions;

import java.util.Map;

@Configuration
public class ReactiveKafkaProducerConfig {

    @Bean
    public ReactiveKafkaProducerTemplate<String, RequestTransactionDTO> reactiveKafkaProducerTemplate(final KafkaProperties kafkaProperties) {
        Map<String, Object> props = kafkaProperties.buildProducerProperties();

        return new ReactiveKafkaProducerTemplate<String, RequestTransactionDTO>(SenderOptions.create(props));
    }
}
