package com.conaf.microservicio.registro_expediente.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Registros")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descripcion;

    private String tipo; // EJ: "AVANCE", "RECURSO_ASIGNADO", "ALERTA"

    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "expediente_id")
    private Expediente expediente;
}