package br.com.coffeeandit.transactionsvc.dto;

import br.com.coffeeandit.transactionsvc.entities.enums.SituacaoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class RequestTransactionDTO extends TransactionDTO{
    @JsonIgnore
    private SituacaoEnum situacao;
    @JsonIgnore
    private LocalDateTime data;

}
