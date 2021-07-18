package com.dio.controlepontoacesso.service;

import com.dio.controlepontoacesso.model.Usuario;
import com.dio.controlepontoacesso.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public List<Usuario> findAll(){return repository.findAll();}

    public Optional<Usuario> findById(long id){return repository.findById(id);}

    public Usuario save(Usuario usuario){return repository.save(usuario);}

    public void delete(long id){repository.deleteById(id);}
}
