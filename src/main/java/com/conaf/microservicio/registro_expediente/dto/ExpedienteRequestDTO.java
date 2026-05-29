package com.conaf.microservicio.registro_expediente.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class ExpedienteRequestDTO {
    @NotNull(message = "El id del incendio es obligatorio")
    private Long idIncendio;
}
