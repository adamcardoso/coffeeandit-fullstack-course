package br.com.coffeeandit.transactionsvc.domain;

import br.com.coffeeandit.transactionsvc.dto.RequestTransactionDTO;
import br.com.coffeeandit.transactionsvc.repositories.TransactionRepository;
import br.com.coffeeandit.transactionsvc.validator.TransactionValidation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class TransactionBusiness {

    public TransactionBusiness(TransactionValidation transactionValidation, TransactionRepository transactionRepository) {
        this.transactionValidation = transactionValidation;
        this.transactionRepository = transactionRepository;
    }

    private TransactionValidation transactionValidation;
    private TransactionRepository transactionRepository;

    public void save(final RequestTransactionDTO requestTransactionDto) {
        if (Objects.isNull(requestTransactionDto.getData()))
            requestTransactionDto.setData(LocalDateTime.now());
        transactionValidation.validate(requestTransactionDto);
        transactionRepository.save(requestTransactionDto);
    }
}

