package com.dio.controlepontoacesso.service;

import com.dio.controlepontoacesso.model.BancoHoras;
import com.dio.controlepontoacesso.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BancoHorasService {

    @Autowired
    BancoHorasRepository repository;

    public List<BancoHoras> findAll(){return repository.findAll();}

    public Optional<BancoHoras> findById(BancoHoras.BancoHorasId id){return repository.findById(id);}

    public BancoHoras save(BancoHoras bancoHoras){return repository.save(bancoHoras);}

    public void delete(BancoHoras.BancoHorasId id){repository.deleteById(id);}
}
