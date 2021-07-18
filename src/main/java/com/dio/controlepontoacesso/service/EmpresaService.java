package com.dio.controlepontoacesso.service;

import com.dio.controlepontoacesso.model.Empresa;
import com.dio.controlepontoacesso.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository repository;

    public List<Empresa> findAll() {
        return repository.findAll();
    }

    public Optional<Empresa> findById(long id) {
        return repository.findById(id);
    }

    public Empresa save(Empresa empresa) {
        return repository.save(empresa);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
