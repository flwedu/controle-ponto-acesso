package com.dio.controlepontoacesso.controller;

import com.dio.controlepontoacesso.model.NivelAcesso;
import com.dio.controlepontoacesso.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/nivelacesso")
public class NivelAcessoController {

    @Autowired
    NivelAcessoService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NivelAcesso>> getListaNivelAcesso() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NivelAcesso> getNivelAcessoById(@PathVariable long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NivelAcesso> saveNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(nivelAcesso));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NivelAcesso> putNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.save(nivelAcesso));
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NivelAcesso> deleteNivelAcesso(@NotNull @RequestBody NivelAcesso nivelAcesso) {
        service.delete(nivelAcesso.getId());
        return ResponseEntity.ok().build();
    }
}
