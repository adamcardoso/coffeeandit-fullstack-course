package br.coffeeandit.transactionbff.api;

import br.coffeeandit.transactionbff.dto.LimiteDiarioDTO;
import br.coffeeandit.transactionbff.feign.LimiteClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limites")
public class LimiteController {

    public LimiteClient limiteClient;

    public LimiteController(LimiteClient limiteClient) {
        this.limiteClient = limiteClient;
    }

    @GetMapping(value = "/{agencia}/{conta}")
    public LimiteDiarioDTO buscarLimiteDiario(@PathVariable("agencia") final Long agencia, @PathVariable("conta") final Long conta) {

        return limiteClient.buscarLimiteDiario(agencia, conta);

    }

}
