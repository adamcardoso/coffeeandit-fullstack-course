package br.com.coffeeandit.transactionsvc.exeptions;

public class DomainBusinessException extends RuntimeException {
    public DomainBusinessException(String message) {
        super(message);
    }
}

