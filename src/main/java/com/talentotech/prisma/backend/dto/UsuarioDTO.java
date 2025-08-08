package com.talentotech.prisma.backend.dto;
import java.time.LocalDate;

public class UsuarioDTO{

    private long id;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String ubicacion;
    private String email;
    private String contrasena;
    private Boolean administrador;
    private LocalDate fecha_nacimiento;

    public UsuarioDTO(){
    }

    public UsuarioDTO(long id){
        this.id = id;
    }

    public UsuarioDTO(long id, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido,
            String ubicacion, String email, String contrasena, Boolean administrador, LocalDate fecha_nacimiento) {
        this.id = id;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.ubicacion = ubicacion;
        this.email = email;
        this.contrasena = contrasena;
        this.administrador = administrador;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public UsuarioDTO(long id, String primer_nombre, String primer_apellido, String ubicacion) {
        this.id=id;
        this.primer_nombre = primer_nombre;
        this.primer_apellido = primer_apellido;
        this.ubicacion = ubicacion;
    }

    
    public UsuarioDTO(long id, String primer_nombre, String segundo_nombre, String primer_apellido,
            String segundo_apellido, String ubicacion, String email, String contrasena, LocalDate fecha_nacimiento) {
        this.id = id;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.ubicacion = ubicacion;
        this.email = email;
        this.contrasena = contrasena;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id=id;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

}
