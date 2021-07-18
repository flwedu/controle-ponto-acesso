package com.dio.controlepontoacesso.controller;

import com.dio.controlepontoacesso.model.Empresa;
import com.dio.controlepontoacesso.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Empresa>> getListaEmpresa() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> saveEmpresa(@RequestBody Empresa empresa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(empresa));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> putEmpresa(@RequestBody Empresa empresa) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.save(empresa));
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> deleteEmpresa(@NotNull @RequestBody Empresa empresa) {
        service.delete(empresa.getId());
        return ResponseEntity.ok().build();
    }
}
