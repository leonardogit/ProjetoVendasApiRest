package io.github.leonardogit;

import io.github.leonardogit.domain.entity.Cliente;
import io.github.leonardogit.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {
    @Bean
    public CommandLineRunner commandLineRunner (@Autowired Clientes clientes){

        return args -> {
            Cliente c =  new Cliente(null,"Leonardo");
            clientes.save(c);
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
