package br.coffeeandit.transactionbff.service;

import br.coffeeandit.transactionbff.dto.RequestTransactionDTO;
import br.coffeeandit.transactionbff.dto.TransactionDTO;
import br.coffeeandit.transactionbff.repositories.TransactionRedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class TransactionService {

    private final TransactionRedisRepository transactionRedisRepository;
    private RetryTemplate retryTemplate;
    private ReactiveKafkaProducerTemplate<String, RequestTransactionDTO> reactiveKafkaProducerTemplate;

    public TransactionService(TransactionRedisRepository transactionRedisRepository, RetryTemplate retryTemplate, ReactiveKafkaProducerTemplate<String, RequestTransactionDTO> reactiveKafkaProducerTemplate) {
        this.transactionRedisRepository = transactionRedisRepository;
        this.retryTemplate = retryTemplate;
        this.reactiveKafkaProducerTemplate = reactiveKafkaProducerTemplate;
    }

    @Value("${app.topic}")
    private String topic;

    @Transactional
    @Retryable(value = QueryTimeoutException.class, maxAttempts = 5, backoff = @Backoff(delay = 100))
    public Optional<TransactionDTO> save(final RequestTransactionDTO requestTransactionDto) {
        requestTransactionDto.setData(LocalDateTime.now());
        reactiveKafkaProducerTemplate.send(topic, requestTransactionDto)
                .doOnSuccess(voidSenderResult -> log.info(voidSenderResult.toString()))
                .subscribe();
        return Optional.of(transactionRedisRepository.save(requestTransactionDto));
    }

    public Optional<TransactionDTO> findById(final String id) {
        return retryTemplate.execute(ret -> {
            log.info("Consultando no redis");
            return transactionRedisRepository.findById(id);
        });
    }
}


