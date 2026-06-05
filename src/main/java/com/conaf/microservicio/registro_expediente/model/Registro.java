package com.conaf.microservicio.registro_expediente.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "registros")
@Data
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long incendioId;
    private Integer familiasAfectadas;

    @Column(columnDefinition = "Resumen")
    private String resumenIncendio;

    @Column(columnDefinition = "Recursos")
    private String detalleRecursos;

    @Column(columnDefinition = "Herramientas")
    private String detalleHerramientas;
}
