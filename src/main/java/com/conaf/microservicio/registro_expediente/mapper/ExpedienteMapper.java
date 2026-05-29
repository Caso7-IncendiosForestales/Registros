package com.conaf.microservicio.registro_expediente.mapper;

import com.conaf.microservicio.registro_expediente.dto.ExpedienteCreateDTO;
import com.conaf.microservicio.registro_expediente.dto.ExpedienteResponseDTO;
import com.conaf.microservicio.registro_expediente.model.Expediente;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExpedienteMapper {

    public Expediente toEntity(ExpedienteCreateDTO dto) {
        Expediente entidad = new Expediente();
        entidad.setCodigoCaso(dto.getCodigoCaso());
        entidad.setUbicacion(dto.getUbicacion());
        entidad.setEstado(dto.getEstado());
        entidad.setDescripcion(dto.getDescripcion());
        return entidad;
    }

    public ExpedienteResponseDTO toDto(Expediente entity) {
        return new ExpedienteResponseDTO(
            entity.getId(),
            entity.getCodigoCaso(),
            entity.getUbicacion(),
            entity.getEstado(),
            entity.getSeveridad()
        );
    }

    public List<ExpedienteResponseDTO> toDtoList(List<Expediente> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
