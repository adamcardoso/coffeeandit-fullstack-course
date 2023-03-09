package br.coffeeandit.transactionbff.service;

import br.coffeeandit.transactionbff.dto.LimiteDiarioDTO;
import br.coffeeandit.transactionbff.feign.LimiteClient;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.decorators.Decorators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.Supplier;

@Service
public class LimiteService {

    LimiteClient limiteClient;

    @Autowired
    private CircuitBreaker timeCircuitBreaker;


    public LimiteService(LimiteClient limiteClient) {
        this.limiteClient = limiteClient;
    }

    public LimiteDiarioDTO buscarLimiteDiario(final Long agencia, final Long conta) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        var limiteDiarioSup = fallback(agencia, conta);

        return limiteDiarioSup.get();
    }

    private Supplier<LimiteDiarioDTO> fallback(final Long agencia, final Long conta) {
        var limiteDiarioSup = timeCircuitBreaker.decorateSupplier(() -> limiteClient.buscarLimiteDiario(agencia, conta));

        return Decorators
                .ofSupplier(limiteDiarioSup)
                .withCircuitBreaker(timeCircuitBreaker)
                .withFallback(Arrays.asList(CallNotPermittedException.class),
                        e -> this.getStaticLimit())
                .decorate();

    }

    private LimiteDiarioDTO getStaticLimit() {
        LimiteDiarioDTO limiteDiario = new LimiteDiarioDTO();
        limiteDiario.setValor(BigDecimal.ZERO);
        return limiteDiario;
    }


}

