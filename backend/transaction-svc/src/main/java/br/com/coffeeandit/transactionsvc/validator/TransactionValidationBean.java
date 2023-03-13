package br.com.coffeeandit.transactionsvc.validator;

import br.com.coffeeandit.transactionsvc.dto.RequestTransactionDTO;
import br.com.coffeeandit.transactionsvc.exeptions.DomainBusinessException;
import br.com.coffeeandit.transactionsvc.validator.impl.BancoTransactionValidator;
import br.com.coffeeandit.transactionsvc.validator.impl.HorarioTransactionValidator;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@ConditionalOnBean(value = {BancoTransactionValidator.class, HorarioTransactionValidator.class})
@ConditionalOnExpression("${transaction.validation.enabled:true}")
public class TransactionValidationBean implements TransactionValidation {

    private List<TransactionValidator> transactionValidatorList = new ArrayList<>();

    @PostConstruct
    public void addBeans() {
        transactionValidatorList.add(new BancoTransactionValidator());
        transactionValidatorList.add(new HorarioTransactionValidator());

    }


    @Override
    public void validate(final RequestTransactionDTO requestTransactionDto) throws DomainBusinessException {
        transactionValidatorList.stream().forEach(transactionValidator -> transactionValidator.validate(requestTransactionDto));
    }
}

