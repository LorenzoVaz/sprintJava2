package com.example.odontologyapp.controller;

import com.example.odontologyapp.model.Sinistro;
import com.example.odontologyapp.service.SinistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/sinistros")
public class SinistroController {

    @Autowired
    private SinistroService sinistroService;

    @PostMapping
    public ResponseEntity<Sinistro> salvarSinistro(@Valid @RequestBody Sinistro sinistro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sinistroService.salvarSinistro(sinistro));
    }

    @GetMapping
    public ResponseEntity<Page<Sinistro>> listarSinistros(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(sinistroService.listarTodos(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sinistro> buscarSinistro(@PathVariable UUID id) {
        return ResponseEntity.ok(sinistroService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sinistro> atualizarSinistro(@PathVariable UUID id, @Valid @RequestBody Sinistro sinistro) {
        sinistro.setId(id);
        return ResponseEntity.ok(sinistroService.atualizarSinistro(sinistro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSinistro(@PathVariable UUID id) {
        sinistroService.deletarSinistro(id);
        return ResponseEntity.noContent().build();
    }
}