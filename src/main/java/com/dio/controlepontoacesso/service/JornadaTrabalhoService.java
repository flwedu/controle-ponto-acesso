package com.dio.controlepontoacesso.service;

import com.dio.controlepontoacesso.model.JornadaTrabalho;
import com.dio.controlepontoacesso.repository.JornadaTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaTrabalhoService {

    JornadaTrabalhoRepository repository;

    @Autowired
    public JornadaTrabalhoService(JornadaTrabalhoRepository repository) {
        this.repository = repository;
    }

    public List<JornadaTrabalho> findAll() {
        return repository.findAll();
    }

    public Optional<JornadaTrabalho> findById(Long id){
        return repository.findById(id);
    }

    public JornadaTrabalho save(JornadaTrabalho jornada){
        return repository.save(jornada);
    }

    public void delete(long id){
        repository.deleteById(id);
    }

}
