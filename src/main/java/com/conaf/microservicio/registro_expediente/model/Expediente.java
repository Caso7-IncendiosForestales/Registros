package com.conaf.microservicio.registro_expediente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "expedientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigoCaso;

    @Column(nullable = false)
    private String ubicacion;

    private String estado;

    private String severidad;

    private String descripcion;

}

