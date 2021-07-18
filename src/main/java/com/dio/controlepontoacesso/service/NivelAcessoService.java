package com.dio.controlepontoacesso.service;

import com.dio.controlepontoacesso.model.NivelAcesso;
import com.dio.controlepontoacesso.repository.NivelAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelAcessoService {

    @Autowired
    NivelAcessoRepository repository;

    public List<NivelAcesso> findAll() {
        return repository.findAll();
    }

    public Optional<NivelAcesso> findById(long id) {
        return repository.findById(id);
    }

    public NivelAcesso save(NivelAcesso nivelAcesso) {
        return repository.save(nivelAcesso);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
