package com.talentotech.prisma.backend.entities;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;

    @Size(max = 20)
    @Column(name="primer_nombre", nullable = false, length = 20)
    private String primer_nombre;

    @Size(max = 20)
    @Column(name="segundo_nombre", length = 20)
    private String segundo_nombre;

    @Size(max = 20)
    @Column(name = "primer_apellido", nullable = false, length = 20)
    private String primer_apellido;

    @Size(max = 20)
    @Column(name = "segundo_apellido", length = 20)
    private String segundo_apellido;

    @Size(max = 20)
    @Column(name = "ubicacion", length = 20)
    private String ubicacion;

    @Size(max = 50)
    @Column(name = "email", length = 50, unique = true)
    private String email;

    @Size(max = 244)
    @Column(name = "contrasena", length = 244)
    private String contrasena;

    @Column(name = "administrador")
    private Boolean administrador;

    @Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name="preferencias_usuario",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_preferencias")
    )
    private Set<Preferencias> preferencias;

    public Usuario(){
    }

    public Usuario(long id){
        this.id = id;
    }

    public Usuario(long id, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido,
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

    public Usuario(long id, String primer_nombre, String primer_apellido, String ubicacion) {
        this.id=id;
        this.primer_nombre = primer_nombre;
        this.primer_apellido = primer_apellido;
        this.ubicacion = ubicacion;
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

    public Boolean getAdministrador(){
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

    
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", primer_nombre=" + primer_nombre + ", segundo_nombre=" + segundo_nombre
                + ", primer_apellido=" + primer_apellido + ", segundo_apellido=" + segundo_apellido + ", ubicacion="
                + ubicacion + ", email=" + email + ", contrasena=" + contrasena + ", administrador=" + administrador
                + ", fecha_nacimiento=" + fecha_nacimiento + "]";
    }

    public Set<Preferencias> getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(Set<Preferencias> preferencias) {
        this.preferencias = preferencias;
    }
}
