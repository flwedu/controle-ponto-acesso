package com.dio.controlepontoacesso.service;

import com.dio.controlepontoacesso.model.CategoriaUsuario;
import com.dio.controlepontoacesso.repository.CategoriaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoriaUsuarioService {

    @Autowired
    CategoriaUsuarioRepository repository;

    public List<CategoriaUsuario> findAll(){return repository.findAll();}

    public Optional<CategoriaUsuario> findById(long id){return repository.findById(id);}

    public CategoriaUsuario save(CategoriaUsuario categoriaUsuario){return repository.save(categoriaUsuario);}

    public void delete(long id){repository.deleteById(id);}
}
