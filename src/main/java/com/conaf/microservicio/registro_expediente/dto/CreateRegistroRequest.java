package com.conaf.microservicio.registro_expediente.dto;

public record CreateRegistroRequest(
    Long incendioId,
    Integer familiasAfectadas,
    String resumenIncendio,
    String detalleRecursos,
    String detalleHerramientas
) {}