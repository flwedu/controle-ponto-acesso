package com.dio.controlepontoacesso.service;

import com.dio.controlepontoacesso.model.Ocorrencia;
import com.dio.controlepontoacesso.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OcorrenciaService {

    @Autowired
    OcorrenciaRepository repository;

    public List<Ocorrencia> findAll(){return repository.findAll();}

    public Optional<Ocorrencia> findById(long id){return repository.findById(id);}

    public Ocorrencia save(Ocorrencia ocorrencia){return repository.save(ocorrencia);}

    public void delete(long id){repository.deleteById(id);}
}
