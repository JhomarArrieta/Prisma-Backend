package com.talentotech.prisma.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "match")
@Getter
@Setter
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_persona1", nullable = false)
    private Long idPersona1;

    @Column(name = "id_persona2", nullable = false)
    private Long idPersona2;

    @Column(name = "estado")
    private Boolean estado;
}