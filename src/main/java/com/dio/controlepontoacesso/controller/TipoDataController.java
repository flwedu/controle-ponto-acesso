package com.dio.controlepontoacesso.controller;

import com.dio.controlepontoacesso.model.TipoData;
import com.dio.controlepontoacesso.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/tipodata")
public class TipoDataController {

    @Autowired
    TipoDataService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TipoData>> getListaTipoData() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoData> getTipoDataById(@PathVariable long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoData> saveTipoData(@RequestBody TipoData tipoData) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tipoData));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoData> putTipoData(@RequestBody TipoData tipoData) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.save(tipoData));
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipoData> deleteTipoData(@NotNull @RequestBody TipoData tipoData) {
        service.delete(tipoData.getId());
        return ResponseEntity.ok().build();
    }
}
