package com.conaf.microservicio.registro_expediente.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class RegistroRequestDTO {
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;
    
    @NotBlank(message = "El tipo de hito es obligatorio")
    private String tipo;
}
