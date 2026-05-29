package com.conaf.microservicio.registro_expediente.repository;

import com.conaf.microservicio.registro_expediente.model.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpedienteRepository extends JpaRepository<Expediente, Long> {

    Optional<Expediente> findByCodigoCaso(String codigoCaso);

    List<Expediente> findByEstado(String estado);
}
