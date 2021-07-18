package com.dio.controlepontoacesso.service;

import com.dio.controlepontoacesso.model.Localidade;
import com.dio.controlepontoacesso.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadeService {

    @Autowired
    LocalidadeRepository repository;

    public List<Localidade> findAll() {
        return repository.findAll();
    }

    public Optional<Localidade> findById(long id) {
        return repository.findById(id);
    }

    public Localidade save(Localidade localidade) {
        return repository.save(localidade);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
