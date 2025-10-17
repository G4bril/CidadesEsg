package com.example.cidadesesg;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class CidadesEsgApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CidadesEsgApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Espera o servidor iniciar
        Thread.sleep(3000);
        // Abre o navegador automaticamente
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI("http://localhost:8080/cidades"));
        }
    }
}
