package com.conaf.microservicio.registro_expediente.controller;

import com.conaf.microservicio.registro_expediente.dto.*;
import com.conaf.microservicio.registro_expediente.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/expedientes")
@RequiredArgsConstructor
public class ExpedienteController {

    private final ExpedienteService expedienteService;

    @PostMapping
    public ResponseEntity<Void> crearExpediente(@Valid @RequestBody ExpedienteRequestDTO request) {
        // Falta esta validación antes de crear
        expedienteService.validarIncendio(request.getIdIncendio()); 
        expedienteService.crearExpediente(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{id}/registros")
    public ResponseEntity<Void> agregarRegistro(@PathVariable Long id, @Valid @RequestBody RegistroRequestDTO request) {
        expedienteService.agregarRegistro(id, request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}/bitacora")
    public ResponseEntity<List<RegistroResponseDTO>> obtenerBitacora(@PathVariable Long id) {
        return ResponseEntity.ok(expedienteService.obtenerBitacora(id));
    }

    @PutMapping("/{id}/cerrar")
    public ResponseEntity<Void> cerrarExpediente(@PathVariable Long id) {
        expedienteService.cerrarExpediente(id);
        return ResponseEntity.noContent().build();
    }
}
