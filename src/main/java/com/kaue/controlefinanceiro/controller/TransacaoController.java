package com.kaue.controlefinanceiro.controller;

import com.kaue.controlefinanceiro.model.Transacao;
import com.kaue.controlefinanceiro.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Transacao> cadastrar(@RequestBody Transacao transacao) {
        Transacao transacaoSalva = transacaoService.salvar(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoSalva);
    }

    @GetMapping
    public List<Transacao> listar() {
        return transacaoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarPorId(@PathVariable Long id) {
        return transacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> atualizar(
            @PathVariable Long id,
            @RequestBody Transacao transacao) {

        return transacaoService.atualizar(id, transacao)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean transacaoExcluida = transacaoService.excluirPorId(id);

        if (!transacaoExcluida) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
