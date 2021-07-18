package com.dio.controlepontoacesso.service;

import com.dio.controlepontoacesso.model.Movimentacao;
import com.dio.controlepontoacesso.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MovimentacaoService {

    @Autowired
    MovimentacaoRepository repository;

    public List<Movimentacao> findAll(){return repository.findAll();}

    public Optional<Movimentacao> findById(Movimentacao.MovimentacaoId id){return repository.findById(id);}

    public Movimentacao save(Movimentacao movimentacao){return repository.save(movimentacao);}

    public void delete(Movimentacao.MovimentacaoId id){repository.deleteById(id);}
}
