package br.com.coffeeandit.transactionsvc.validator;

import br.com.coffeeandit.transactionsvc.dto.RequestTransactionDTO;
import br.com.coffeeandit.transactionsvc.exeptions.DomainBusinessException;

public class EmptyTransactionValidationBean implements TransactionValidation {
    @Override
    public void validate(final RequestTransactionDTO requestTransactionDto) throws DomainBusinessException {

    }
}


