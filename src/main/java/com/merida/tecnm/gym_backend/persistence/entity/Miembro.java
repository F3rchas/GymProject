package com.merida.tecnm.gym_backend.persistence.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "miembros")
public class Miembro {

    @Id
    @Column(name = "id_miembro")
    private String idMiembro;

    private String nombre;

    private String apellidos;

    private Long celular;

    @Column(name = "correo_electronico", unique = true)
    private String correoElectronico;

    private String password;

    private Boolean estado;

    @OneToMany(mappedBy = "miembro")
    private List<Membresia> membresias;

    public String getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(String idMiembro) {
        this.idMiembro = idMiembro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Membresia> getMembresias() {
        return membresias;
    }

    public void setMembresias(List<Membresia> membresias) {
        this.membresias = membresias;
    }
}
