package com.dio.controlepontoacesso.service;

import com.dio.controlepontoacesso.model.Movimentacao;
import com.dio.controlepontoacesso.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    @Autowired
    MovimentacaoRepository repository;

    public List<Movimentacao> findAll() {
        return repository.findAll();
    }

    public Optional<Movimentacao> findById(long id) {
        return repository.findByIdIdMovimento(id);
    }

    public Movimentacao save(Movimentacao movimentacao) {
        return repository.save(movimentacao);
    }

    public void delete(long id) {
        repository.deleteByIdIdMovimento(id);
    }
}
