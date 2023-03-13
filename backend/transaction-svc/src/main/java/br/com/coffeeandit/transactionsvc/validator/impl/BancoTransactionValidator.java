package br.com.coffeeandit.transactionsvc.validator.impl;

import br.com.coffeeandit.transactionsvc.dto.RequestTransactionDTO;
import br.com.coffeeandit.transactionsvc.exeptions.DomainBusinessException;
import br.com.coffeeandit.transactionsvc.validator.TransactionValidator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@ConditionalOnProperty(
        value = "transaction.validation.banco",
        havingValue = "true",
        matchIfMissing = false)

public class BancoTransactionValidator implements TransactionValidator {

    public static final int CODIGO_BANCO = 785;

    @Override
    public void validate(final RequestTransactionDTO requestTransactionDto) throws DomainBusinessException {

        if (Objects.isNull(requestTransactionDto.getBeneficiario())) {
            throw new DomainBusinessException("Inválido banco do beneficiário");
        } else if (Objects.isNull(requestTransactionDto.getBeneficiario().getCodigoBanco()) ||
                requestTransactionDto.getBeneficiario().getCodigoBanco().compareTo((long) CODIGO_BANCO) != 0
        ) {
            throw new DomainBusinessException("Inválido banco do beneficiário");
        }

    }

}
