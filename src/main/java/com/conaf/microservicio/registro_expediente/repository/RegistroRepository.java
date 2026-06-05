package com.conaf.microservicio.registro_expediente.repository;

import com.conaf.microservicio.registro_expediente.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {
    List<Registro> findByIncendioId(Long incendioId);
}
