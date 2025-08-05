package com.talentotech.prisma.backend.entities;

import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "preferencias")
public class Preferencias{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;

    @Size(max = 20)
    @Column(name="hijos", length = 20)
    private String hijos;

    @Size(max = 20)
    @Column(name="tipo_relacion", length = 20)
    private String tipo_relacion;

    @Column(name = "diferencia_edad")
    private int diferencia_edad;

    @ManyToMany(mappedBy = "preferencias", fetch = FetchType.LAZY)
    private Set<Usuario> usuarios;

    public Preferencias() {
    }

    public Preferencias(long id, @Size(max = 20) String hijos, @Size(max = 20) String tipo_relacion,
            int diferencia_edad) {
        this.id = id;
        this.hijos = hijos;
        this.tipo_relacion = tipo_relacion;
        this.diferencia_edad = diferencia_edad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHijos() {
        return hijos;
    }

    public void setHijos(String hijos) {
        this.hijos = hijos;
    }

    public String getTipo_relacion() {
        return tipo_relacion;
    }

    public void setTipo_relacion(String tipo_relacion) {
        this.tipo_relacion = tipo_relacion;
    }

    public int getDiferencia_edad() {
        return diferencia_edad;
    }

    public void setDiferencia_edad(int diferencia_edad) {
        this.diferencia_edad = diferencia_edad;
    }

    @Override
    public String toString() {
        return "Preferencias [id=" + id + ", hijos=" + hijos + ", tipo_relacion=" + tipo_relacion + ", diferencia_edad="
                + diferencia_edad + "]";
    }

}