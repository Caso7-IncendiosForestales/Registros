package com.conaf.microservicio.registro_expediente.dto;

public record RegistroResponse(
    Long id,
    Long incendioId,
    Integer familiasAfectadas,
    String resumenIncendio,
    String detalleRecursos,
    String detalleHerramientas
) {}
