package com.conaf.microservicio.registro_expediente.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class RegistroResponseDTO {
    private Long id;
    private String descripcion;
    private String tipo;
    private LocalDateTime fechaHora;
}