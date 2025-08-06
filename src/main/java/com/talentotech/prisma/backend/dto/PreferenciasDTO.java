package com.talentotech.prisma.backend.dto;

public class PreferenciasDTO {

    private long id;
    private String hijos;
    private String tipo_relacion;
    private int diferencia_edad;
    
    public PreferenciasDTO() {
    }

    public PreferenciasDTO(long id, String hijos, String tipo_relacion, int diferencia_edad) {
        this.id = id;
        this.hijos = hijos;
        this.tipo_relacion = tipo_relacion;
        this.diferencia_edad = diferencia_edad;
    }

    public PreferenciasDTO(String hijos) {
        this.hijos = hijos;
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

    
    
}
