package br.coffeeandit.transactionbff.api;


import br.coffeeandit.transactionbff.dto.RequestTransactionDTO;
import br.coffeeandit.transactionbff.dto.TransactionDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TransactionDTO> enviarTransacao(@RequestBody final RequestTransactionDTO requestTransactionDTO){
        return Mono.empty();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TransactionDTO> buscarTransacao(@PathVariable("id") final String uuid){
        return Mono.empty();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TransactionDTO> removerTransacao(@PathVariable("id") final String uuid){
        return Mono.empty();
    }

    @PatchMapping(value = "/{id}/confirmar")
    public Mono<TransactionDTO> confirmarTransacao(@PathVariable("id") final String uuid){
        return Mono.empty();
    }
}
