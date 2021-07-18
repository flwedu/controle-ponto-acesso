package com.dio.controlepontoacesso.controller;

import com.dio.controlepontoacesso.model.Ocorrencia;
import com.dio.controlepontoacesso.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    @Autowired
    OcorrenciaService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ocorrencia>> getListaOcorrencia() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ocorrencia> getOcorrenciaById(@PathVariable long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ocorrencia> saveOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(ocorrencia));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ocorrencia> putOcorrencia(@RequestBody Ocorrencia ocorrencia) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.save(ocorrencia));
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ocorrencia> deleteOcorrencia(@NotNull @RequestBody Ocorrencia ocorrencia) {
        service.delete(ocorrencia.getId());
        return ResponseEntity.ok().build();
    }
}
