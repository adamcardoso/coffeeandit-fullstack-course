package br.com.coffeeandit.transactionsvc.validator.impl;

import br.com.coffeeandit.transactionsvc.dto.RequestTransactionDTO;
import br.com.coffeeandit.transactionsvc.exeptions.DomainBusinessException;
import br.com.coffeeandit.transactionsvc.validator.TransactionValidator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@ConditionalOnProperty(
        value = "transaction.validation.horario",
        havingValue = "true",
        matchIfMissing = false)
public class HorarioTransactionValidator implements TransactionValidator {


    public static final int HOUR_END = 18;

    @Override
    public void validate(final RequestTransactionDTO requestTransactionDto) throws DomainBusinessException {

        if (LocalDateTime.now().getHour() > HOUR_END || requestTransactionDto.getData().getHour() > HOUR_END) {
            throw new DomainBusinessException("Horário após as 18.");
        }

    }
}

