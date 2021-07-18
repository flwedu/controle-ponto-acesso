package com.dio.controlepontoacesso.controller;

import com.dio.controlepontoacesso.model.BancoHoras;
import com.dio.controlepontoacesso.service.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/bancohoras")
public class BancoHorasController {

    @Autowired
    BancoHorasService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BancoHoras>> getListaBancoHoras() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id1}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BancoHoras> getBancoHorasById(@PathVariable long id) {

        return service.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BancoHoras> saveBancoHoras(@RequestBody BancoHoras bancoHoras) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(bancoHoras));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BancoHoras> putBancoHoras(@RequestBody BancoHoras bancoHoras) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.save(bancoHoras));
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BancoHoras> deleteBancoHoras(@NotNull @RequestBody BancoHoras bancoHoras) {
        service.delete(bancoHoras.getId().getIdBancoHoras());
        return ResponseEntity.ok().build();
    }
}
