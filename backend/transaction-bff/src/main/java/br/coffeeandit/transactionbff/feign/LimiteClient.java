package br.coffeeandit.transactionbff.feign;

import br.coffeeandit.transactionbff.dto.LimiteDiarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient(value = "limites", url = "${limites.url}")
public interface LimiteClient {

    @RequestMapping(path = "/limite-diario/{agencia}/{conta}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    LimiteDiarioDTO buscarLimiteDiario(@PathVariable("agencia") Long agencia, @PathVariable("conta") Long conta);
}
