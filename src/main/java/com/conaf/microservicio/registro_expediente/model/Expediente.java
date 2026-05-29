package com.conaf.microservicio.registro_expediente.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Expedientes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Expediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idIncendio; // Referencia externa (Microservicio de Incendios)

    private LocalDateTime fechaApertura;
    
    private String estado; // EJ: "ABIERTO", "CERRADO"

    @OneToMany(mappedBy = "expediente", cascade = CascadeType.ALL)
    private List<Registro> bitacora;
}
