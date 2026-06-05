package com.conaf.microservicio.registro_expediente.service;

import com.conaf.microservicio.registro_expediente.dto.CreateRegistroRequest;
import com.conaf.microservicio.registro_expediente.dto.RegistroResponse;
import com.conaf.microservicio.registro_expediente.mapper.RegistroMapper;
import com.conaf.microservicio.registro_expediente.model.Registro;
import com.conaf.microservicio.registro_expediente.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository repository;

    @Autowired
    private RegistroMapper mapper;

    @Transactional
    public RegistroResponse crearRegistro(CreateRegistroRequest request) {
        Registro registro = mapper.toEntity(request);
        Registro registroGuardado = repository.save(registro);
        return mapper.toResponse(registroGuardado);
        }

    public List<RegistroResponse> obtenerTodos() {
    return repository.findAll().stream()
            .map(mapper::toResponse)
            .toList();
    }

    public RegistroResponse obtenerPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
    }
}
