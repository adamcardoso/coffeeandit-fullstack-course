package br.coffeeandit.transactionbff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRedisRepositories(basePackages = {"br.coffeeandit.transactionbff.repositories"})
@EnableFeignClients
@EnableRetry
public class TransactionBffApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionBffApplication.class, args);
    }
}
