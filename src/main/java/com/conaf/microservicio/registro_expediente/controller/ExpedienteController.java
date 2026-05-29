package com.conaf.microservicio.registro_expediente.controller;

import com.conaf.microservicio.registro_expediente.dto.ExpedienteCreateDTO;
import com.conaf.microservicio.registro_expediente.dto.ExpedienteResponseDTO;
import com.conaf.microservicio.registro_expediente.service.ExpedienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expedientes")
public class ExpedienteController {

    @Autowired
    private ExpedienteService service;

    @PostMapping
    public ResponseEntity<ExpedienteResponseDTO> crear(@Valid @RequestBody ExpedienteCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearExpediente(dto));
    }

    @GetMapping("/{codigoCaso}")
    public ResponseEntity<ExpedienteResponseDTO> obtenerPorCodigo(@PathVariable String codigoCaso) {
        return ResponseEntity.ok(service.obtenerPorCodigo(codigoCaso));
    }

    @GetMapping
    public ResponseEntity<List<ExpedienteResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }
}
