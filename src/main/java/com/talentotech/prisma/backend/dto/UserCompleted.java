package com.talentotech.prisma.backend.dto;

public class UserCompleted {
    private String primer_nombre;
    private String primer_apellido;
    private String ubicacion;
    private String tipo_relacion;
    
    public UserCompleted() {
    }

    public UserCompleted(String primer_nombre, String primer_apellido, String ubicacion, String tipo_relacion) {
        this.primer_nombre = primer_nombre;
        this.primer_apellido = primer_apellido;
        this.ubicacion = ubicacion;
        this.tipo_relacion = tipo_relacion;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo_relacion() {
        return tipo_relacion;
    }

    public void setTipo_relacion(String tipo_relacion) {
        this.tipo_relacion = tipo_relacion;
    }


}
