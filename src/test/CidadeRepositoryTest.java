package com.example.cidadesesg;

import com.example.cidadesesg.model.Cidade;
import com.example.cidadesesg.repository.CidadeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class CidadeRepositoryTest {

    @Autowired
    CidadeRepository repo;

    @Test
    void saveAndFind() {
        Cidade c = new Cidade("TesteCity", "TS", 1000, 6.4);
        Cidade saved = repo.save(c);
        assertThat(repo.findById(saved.getId())).isPresent();
    }
}
