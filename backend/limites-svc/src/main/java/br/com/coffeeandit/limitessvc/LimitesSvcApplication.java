package br.com.coffeeandit.limitessvc;

import br.com.coffeeandit.limitessvc.entities.LimiteDiario;
import br.com.coffeeandit.limitessvc.repositories.LimiteDiarioRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = LimiteDiarioRepository.class)
@EntityScan(basePackageClasses = LimiteDiario.class)
public class LimitesSvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(LimitesSvcApplication.class, args);
    }

}

