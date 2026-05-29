package com.conaf.microservicio.registro_expediente.repository;

import com.conaf.microservicio.registro_expediente.model.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpedienteRepository extends JpaRepository<Expediente, Long> {

}
