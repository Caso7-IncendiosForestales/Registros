package com.conaf.microservicio.registro_expediente.mapper;

import com.conaf.microservicio.registro_expediente.dto.ExpedienteCreateDTO;
import com.conaf.microservicio.registro_expediente.dto.ExpedienteResponseDTO;
import com.conaf.microservicio.registro_expediente.model.Expediente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExpedienteMapper {

    ExpedienteMapper INSTANCE = Mappers.getMapper(ExpedienteMapper.class);

    Expediente toEntity(ExpedienteCreateDTO dto);

    ExpedienteResponseDTO toDto(Expediente entity);

    List<ExpedienteResponseDTO> toDtoList(List<Expediente> entities);
}
