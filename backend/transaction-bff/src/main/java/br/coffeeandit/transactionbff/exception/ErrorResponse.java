package br.coffeeandit.transactionbff.exception;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ErrorResponse {
    private String message;
    private int code;
}
