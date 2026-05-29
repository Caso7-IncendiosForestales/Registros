package com.conaf.microservicio.registro_expediente.service;

import com.conaf.microservicio.registro_expediente.dto.ExpedienteCreateDTO;
import com.conaf.microservicio.registro_expediente.dto.ExpedienteResponseDTO;
import com.conaf.microservicio.registro_expediente.exception.ResourceNotFoundException;
import com.conaf.microservicio.registro_expediente.mapper.ExpedienteMapper;
import com.conaf.microservicio.registro_expediente.model.Expediente;
import com.conaf.microservicio.registro_expediente.repository.ExpedienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpedienteService {

    @Autowired
    private ExpedienteRepository repository;

    @Autowired
    private ExpedienteMapper mapper;

    public ExpedienteResponseDTO crearExpediente(ExpedienteCreateDTO dto) {
        Expediente entidad = mapper.toEntity(dto);
        Expediente guardado = repository.save(entidad);
        return mapper.toDto(guardado);
    }

    public ExpedienteResponseDTO obtenerPorCodigo(String codigoCaso) {
        return repository.findByCodigoCaso(codigoCaso)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el caso: " + codigoCaso));
    }

    public List<ExpedienteResponseDTO> listarTodos() {
        return mapper.toDtoList(repository.findAll());
    }
}