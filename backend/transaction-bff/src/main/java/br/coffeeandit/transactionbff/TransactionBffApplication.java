package br.coffeeandit.transactionbff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories(basePackages = {"br.coffeeandit.transactionbff.repositories"})
public class TransactionBffApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionBffApplication.class, args);
    }
}
