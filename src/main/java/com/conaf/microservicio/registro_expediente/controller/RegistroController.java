package com.conaf.microservicio.registro_expediente.controller;

import com.conaf.microservicio.registro_expediente.dto.CreateRegistroRequest;
import com.conaf.microservicio.registro_expediente.dto.RegistroResponse;
import com.conaf.microservicio.registro_expediente.service.RegistroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registros")
public class RegistroController {

    @Autowired
    private RegistroService service;

    @PostMapping
    public ResponseEntity<RegistroResponse> crearRegistro(@Valid @RequestBody CreateRegistroRequest request) {
        RegistroResponse response = service.crearRegistro(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }
}
