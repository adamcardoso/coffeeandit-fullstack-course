package br.coffeeandit.transactionbff.repositories;

import br.coffeeandit.transactionbff.dto.TransactionDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRedisRepository extends CrudRepository<TransactionDTO, String> {
}

