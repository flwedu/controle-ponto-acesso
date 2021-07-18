package com.dio.controlepontoacesso.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.dio.controlepontoacesso.model.CategoriaUsuario;
import com.dio.controlepontoacesso.service.CategoriaUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoriausuario")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaUsuarioService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoriaUsuario>> getListaTipoData() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaUsuario> getTipoDataById(@PathVariable long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaUsuario> saveJornada(@RequestBody CategoriaUsuario categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(categoria));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaUsuario> putJornada(@RequestBody CategoriaUsuario categoria) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.save(categoria));
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoriaUsuario> deleteJornada(@NotNull @RequestBody CategoriaUsuario categoria) {
        service.delete(categoria.getId());
        return ResponseEntity.ok().build();
    }
}
