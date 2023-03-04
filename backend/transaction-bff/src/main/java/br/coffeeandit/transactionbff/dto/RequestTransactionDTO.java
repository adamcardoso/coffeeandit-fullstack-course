package br.coffeeandit.transactionbff.dto;

import br.coffeeandit.transactionbff.dto.enums.SituacaoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Schema(description = "Objeto de transporte para o envio de uma promessa de transação")
public class RequestTransactionDTO extends TransactionDTO {
    @JsonIgnore
    private SituacaoEnum situacao;
    @JsonIgnore
    private LocalDateTime data;
}
