package com.conaf.microservicio.registro_expediente.mapper;

import com.conaf.microservicio.registro_expediente.dto.CreateRegistroRequest;
import com.conaf.microservicio.registro_expediente.dto.RegistroResponse;
import com.conaf.microservicio.registro_expediente.model.Registro;
import org.springframework.stereotype.Component;

@Component
public class RegistroMapper {

    public Registro toEntity(CreateRegistroRequest request) {
        Registro registro = new Registro();
        
        registro.setIncendioId(request.incendioId());
        registro.setFamiliasAfectadas(request.familiasAfectadas());
        registro.setResumenIncendio(request.resumenIncendio());
        registro.setDetalleRecursos(request.detalleRecursos());
        registro.setDetalleHerramientas(request.detalleHerramientas());
        
        return registro;
    }

    public RegistroResponse toResponse(Registro registro) {
        return new RegistroResponse(
            registro.getId(),
            registro.getIncendioId(),
            registro.getFamiliasAfectadas(),
            registro.getResumenIncendio(),
            registro.getDetalleRecursos(),
            registro.getDetalleHerramientas()
        );
    }
}
