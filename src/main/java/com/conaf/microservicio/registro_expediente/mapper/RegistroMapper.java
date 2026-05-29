package com.conaf.microservicio.registro_expediente.mapper;

import com.conaf.microservicio.registro_expediente.dto.RegistroResponseDTO;
import com.conaf.microservicio.registro_expediente.model.Registro;
import org.springframework.stereotype.Component;

@Component
public class RegistroMapper {
    public RegistroResponseDTO toDTO(Registro registro) {
        return RegistroResponseDTO.builder()
                .id(registro.getId())
                .descripcion(registro.getDescripcion())
                .tipo(registro.getTipo())
                .fechaHora(registro.getFechaHora())
                .build();
    }
}