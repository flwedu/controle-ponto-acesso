package com.dio.controlepontoacesso.controller;

import com.dio.controlepontoacesso.model.Movimentacao;
import com.dio.controlepontoacesso.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Movimentacao>> getMovimentacao() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movimentacao> getMovimentacaoById(@PathVariable long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movimentacao> saveMovimentacao(@RequestBody Movimentacao movimentacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(movimentacao));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movimentacao> putMovimentacao(@RequestBody Movimentacao movimentacao) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.save(movimentacao));
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movimentacao> deleteMovimentacao(@NotNull @RequestBody Movimentacao movimentacao) {
        service.delete(movimentacao.getId().getIdMovimento());
        return ResponseEntity.ok().build();
    }
}
