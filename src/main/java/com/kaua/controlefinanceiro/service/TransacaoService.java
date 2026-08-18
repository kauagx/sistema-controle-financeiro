package com.kaua.controlefinanceiro.service;

import com.kaua.controlefinanceiro.model.Transacao;
import com.kaua.controlefinanceiro.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public Transacao salvar(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> listar() {
        return transacaoRepository.findAll();
    }

    public Optional<Transacao> buscarPorId(Long id) {
        return transacaoRepository.findById(id);
    }

    public Optional<Transacao> atualizar(Long id, Transacao transacaoAtualizada) {
        return transacaoRepository.findById(id)
                .map(transacaoExistente -> {
                    transacaoExistente.setDescricao(transacaoAtualizada.getDescricao());
                    transacaoExistente.setValor(transacaoAtualizada.getValor());
                    transacaoExistente.setTipo(transacaoAtualizada.getTipo());
                    transacaoExistente.setData(transacaoAtualizada.getData());
                    transacaoExistente.setCategoria(transacaoAtualizada.getCategoria());

                    return transacaoRepository.save(transacaoExistente);
                });
    }

    public boolean excluirPorId(Long id) {
        if (!transacaoRepository.existsById(id)) {
            return false;
        }

        transacaoRepository.deleteById(id);
        return true;
    }
}
