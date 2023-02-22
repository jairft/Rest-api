package br.com.jairfreitas.Restapi.config;

import br.com.jairfreitas.Restapi.domain.User;
import br.com.jairfreitas.Restapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;
    @Bean
    public void startDB(){
        User u1 = new User(null, "Jair Freitas", "jair@gmail.com", "123");
        User u2 = new User(null, "Maria da Silva", "maria@gmail.com", "345");

        repository.saveAll(List.of(u1, u2));
    }
}
