package com.conaf.microservicio.registro_expediente.service;

import com.conaf.microservicio.registro_expediente.config.IncendioClient;
import com.conaf.microservicio.registro_expediente.dto.ExpedienteRequestDTO;
import com.conaf.microservicio.registro_expediente.dto.RegistroRequestDTO;
import com.conaf.microservicio.registro_expediente.dto.RegistroResponseDTO;
import com.conaf.microservicio.registro_expediente.mapper.RegistroMapper;
import com.conaf.microservicio.registro_expediente.model.Expediente;
import com.conaf.microservicio.registro_expediente.model.Registro;
import com.conaf.microservicio.registro_expediente.repository.ExpedienteRepository;
import com.conaf.microservicio.registro_expediente.repository.RegistroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpedienteService {

    private final ExpedienteRepository expedienteRepository;
    private final RegistroRepository registroRepository;
    private final RegistroMapper registroMapper;
    private final IncendioClient incendioClient; 

    public List<RegistroResponseDTO> obtenerBitacora(Long expedienteId) {
        return registroRepository.findByExpedienteIdOrderByFechaHoraAsc(expedienteId)
                .stream()
                .map(registro -> registroMapper.toDTO(registro))
                .collect(Collectors.toList());
    }

    public void crearExpediente(ExpedienteRequestDTO request) {
        validarIncendio(request.getIdIncendio());

        Expediente nuevoExpediente = Expediente.builder()
                .idIncendio(request.getIdIncendio())
                .estado("ABIERTO")
                .build();

        expedienteRepository.save(nuevoExpediente);
    }

    public void agregarRegistro(Long expedienteId, RegistroRequestDTO requestDTO) {
        Expediente expediente = expedienteRepository.findById(expedienteId)
                .orElseThrow(() -> new RuntimeException("Expediente no encontrado con ID: " + expedienteId));

        if ("CERRADO".equals(expediente.getEstado())) {
            throw new RuntimeException("No se pueden agregar registros a un expediente cerrado.");
        }

        Registro nuevoRegistro = Registro.builder()
                .descripcion(requestDTO.getDescripcion())
                .tipo(requestDTO.getTipo())
                .fechaHora(LocalDateTime.now())
                .expediente(expediente)
                .build();

        registroRepository.save(nuevoRegistro);
    }

    public void validarIncendio(Long idIncendio) {
        if (Boolean.FALSE.equals(incendioClient.existeIncendio(idIncendio))) {
            throw new RuntimeException("El incendio con ID " + idIncendio + " no existe.");
        }
    }

    public void cerrarExpediente(Long id) {
        Expediente expediente = expedienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expediente no encontrado"));
        
        if ("CERRADO".equals(expediente.getEstado())) {
            throw new RuntimeException("El expediente ya se encuentra cerrado");
        }
        
        expediente.setEstado("CERRADO");
        expedienteRepository.save(expediente);
    }
}