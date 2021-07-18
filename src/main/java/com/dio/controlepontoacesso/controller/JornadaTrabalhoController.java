package com.dio.controlepontoacesso.controller;

import com.dio.controlepontoacesso.model.JornadaTrabalho;
import com.dio.controlepontoacesso.service.JornadaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    JornadaTrabalhoService service;

    // Construtor que recebe service via injeção de dependência pelo próprio SpringBoot
    @Autowired
    public JornadaTrabalhoController(JornadaTrabalhoService jornadaTrabalhoService) {
        this.service = jornadaTrabalhoService;
    }

    /**
     * Métodos HTTP e suas respostas correspondentes pelo controller.
     * Os métodos HTTP são os clássicos:
     * GET => Retorna um objeto ou lista de objetos;
     * POST => Adiciona um objeto;
     * PUT => Atualiza completamente um objeto;
     * PATCH => Atualiza apenas uma parte do objeto;
     * DELETE => Remove um objeto.
     */

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JornadaTrabalho>> getJornadaList(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable long id){
        return service.findById(id)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JornadaTrabalho> saveJornada(@RequestBody JornadaTrabalho novaJornadaTrabalho){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(novaJornadaTrabalho));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JornadaTrabalho> putJornada(@RequestBody JornadaTrabalho novaJornadaTrabalho){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.save(novaJornadaTrabalho));
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JornadaTrabalho> deleteJornada(@NotNull @RequestBody JornadaTrabalho jornadaASerDeletada){
        service.delete(jornadaASerDeletada.getId());
        return ResponseEntity.ok().build();
    }
}
