package com.dio.controlepontoacesso.service;

import com.dio.controlepontoacesso.model.BancoHoras;
import com.dio.controlepontoacesso.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHorasService {

    @Autowired
    BancoHorasRepository repository;

    public List<BancoHoras> findAll() {
        return repository.findAll();
    }

    public Optional<BancoHoras> findById(Long idBancoHoras) {
        return repository.findByIdIdBancoHoras(idBancoHoras);
    }

    public BancoHoras save(BancoHoras bancoHoras) {
        return repository.save(bancoHoras);
    }

    public void delete(Long idBancoHoras) {
        repository.deleteByIdIdBancoHoras(idBancoHoras);
    }
}
