package com.example.cidadesesg.controller;

import com.example.cidadesesg.model.Cidade;
import com.example.cidadesesg.service.CidadeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private final CidadeService service;

    public CidadeController(CidadeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cidade> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Cidade buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
    }

    @PostMapping
    public Cidade criar(@RequestBody Cidade cidade) {
        if (cidade.getNome() == null || cidade.getNome().isEmpty()
                || cidade.getEstado() == null || cidade.getEstado().isEmpty()) {
            throw new IllegalArgumentException("Nome e Estado são obrigatórios!");
        }
        return service.salvar(cidade);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.deletar(id);
    }
}
