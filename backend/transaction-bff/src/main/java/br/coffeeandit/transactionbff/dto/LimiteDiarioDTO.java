package br.coffeeandit.transactionbff.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class LimiteDiarioDTO {
    private Long id;
    private Long agencia;
    private Long conta;
    private BigDecimal valor;
}
