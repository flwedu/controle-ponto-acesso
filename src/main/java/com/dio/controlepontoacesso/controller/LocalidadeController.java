package com.dio.controlepontoacesso.controller;

import com.dio.controlepontoacesso.model.Localidade;
import com.dio.controlepontoacesso.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    LocalidadeService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Localidade>> getListaLocalidade() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Localidade> getLocalidadeById(@PathVariable long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Localidade> saveLocalidade(@RequestBody Localidade localidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(localidade));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Localidade> putLocalidade(@RequestBody Localidade localidade) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.save(localidade));
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Localidade> deleteLocalidade(@NotNull @RequestBody Localidade localidade) {
        service.delete(localidade.getId());
        return ResponseEntity.ok().build();
    }
}
