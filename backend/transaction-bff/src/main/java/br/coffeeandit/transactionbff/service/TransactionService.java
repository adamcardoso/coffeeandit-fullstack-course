package br.coffeeandit.transactionbff.service;

import br.coffeeandit.transactionbff.dto.RequestTransactionDTO;
import br.coffeeandit.transactionbff.dto.TransactionDTO;
import br.coffeeandit.transactionbff.repositories.TransactionRedisRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionService {

    private TransactionRedisRepository transactionRedisRepository;

    public TransactionService(TransactionRedisRepository transactionRedisRepository) {
        this.transactionRedisRepository = transactionRedisRepository;

    }

    @Transactional
    public Optional<TransactionDTO> save(final RequestTransactionDTO requestTransactionDto) {
        requestTransactionDto.setData(LocalDateTime.now());
        return Optional.of(transactionRedisRepository.save(requestTransactionDto));
    }

    public Optional<TransactionDTO> findById(final String id) {
        return transactionRedisRepository.findById(id);
    }

}

