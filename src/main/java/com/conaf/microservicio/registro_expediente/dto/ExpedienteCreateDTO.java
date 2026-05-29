package com.conaf.microservicio.registro_expediente.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ExpedienteCreateDTO {

    @NotBlank(message = "El código del caso es obligatorio")
    @Size(min = 5, max = 20, message = "El código debe tener entre 5 y 20 caracteres")
    private String codigoCaso;

    @NotBlank(message = "La ubicación es obligatoria")
    private String ubicacion;

    @NotBlank(message = "El estado inicial es obligatorio")
    private String estado;

    private String severidad;

    private String descripcion;
}
