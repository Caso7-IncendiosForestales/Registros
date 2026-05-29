package com.conaf.microservicio.registro_expediente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpedienteResponseDTO {
    
    private Long id;
    private String codigoCaso;
    private String ubicacion;
    private String estado;
    private String severidad;
    private LocalDateTime fechaCreacion;
}
