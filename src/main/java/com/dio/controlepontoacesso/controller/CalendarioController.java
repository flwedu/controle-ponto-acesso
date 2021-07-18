package com.dio.controlepontoacesso.controller;

import com.dio.controlepontoacesso.model.Calendario;
import com.dio.controlepontoacesso.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

    @Autowired
    CalendarioService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Calendario>> getListaCalendario() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Calendario> getCalendarioById(@PathVariable long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Calendario> saveJornada(@RequestBody Calendario calendario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(calendario));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Calendario> putJornada(@RequestBody Calendario calendario) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.save(calendario));
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Calendario> deleteJornada(@NotNull @RequestBody Calendario calendario) {
        service.delete(calendario.getId());
        return ResponseEntity.ok().build();
    }
}
