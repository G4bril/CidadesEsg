package com.example.cidadesesg.config;

import com.example.cidadesesg.model.Cidade;
import com.example.cidadesesg.repository.CidadeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(CidadeRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Cidade("São Paulo", "SP"));
                repository.save(new Cidade("Belo Horizonte", "MG"));
                repository.save(new Cidade("Curitiba", "PR"));
            }
        };
    }
}
