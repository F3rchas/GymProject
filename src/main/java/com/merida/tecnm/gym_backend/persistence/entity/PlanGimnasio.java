package com.merida.tecnm.gym_backend.persistence.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "planes")
public class PlanGimnasio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan")
    private Integer idPlan;

    private String nombre;

    private Double precio;

    @Column(name = "duracion_dias")
    private Integer duracionDias;

    private Boolean estado;

    @OneToMany(mappedBy = "plan")
    private List<MembresiaPlan> membresiasPlanes;

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(Integer duracionDias) {
        this.duracionDias = duracionDias;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<MembresiaPlan> getMembresiasPlanes() {
        return membresiasPlanes;
    }

    public void setMembresiasPlanes(List<MembresiaPlan> membresiasPlanes) {
        this.membresiasPlanes = membresiasPlanes;
    }
}
