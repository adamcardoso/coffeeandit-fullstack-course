package br.com.coffeeandit.transactionsvc.validator;

import br.com.coffeeandit.transactionsvc.dto.RequestTransactionDTO;
import br.com.coffeeandit.transactionsvc.exeptions.DomainBusinessException;

@FunctionalInterface
public interface TransactionValidator {
    void validate(final RequestTransactionDTO requestTransactionDTO) throws DomainBusinessException;
}
