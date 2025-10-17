package com.example.cidadesesg.service;

import com.example.cidadesesg.model.Cidade;
import com.example.cidadesesg.repository.CidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    private final CidadeRepository repository;

    public CidadeService(CidadeRepository repository) {
        this.repository = repository;
    }

    public List<Cidade> listarTodas() {
        return repository.findAll();
    }

    public Optional<Cidade> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Cidade salvar(Cidade cidade) {
        return repository.save(cidade);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
