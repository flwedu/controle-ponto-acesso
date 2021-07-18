package com.dio.controlepontoacesso.service;

import com.dio.controlepontoacesso.model.Calendario;
import com.dio.controlepontoacesso.repository.CalendarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CalendarioService {

    @Autowired
    CalendarioRepository repository;

    public List<Calendario> findAll(){return repository.findAll();}

    public Optional<Calendario> findById(long id){return repository.findById(id);}

    public Calendario save(Calendario calendario){return repository.save(calendario);}

    public void delete(long id){repository.deleteById(id);}
}
