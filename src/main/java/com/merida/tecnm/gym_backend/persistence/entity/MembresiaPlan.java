package com.merida.tecnm.gym_backend.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "membresias_planes")
public class MembresiaPlan {

    @EmbeddedId
    private MembresiaPlanPK id;

    private Integer cantidad;

    private Double total;

    private Boolean estado;

    @ManyToOne
    @MapsId("idMembresia")
    @JoinColumn(name = "id_membresia")
    private Membresia membresia;

    @ManyToOne
    @JoinColumn(name = "id_plan", insertable = false, updatable = false)
    private PlanGimnasio plan;

    public MembresiaPlanPK getId() {
        return id;
    }

    public void setId(MembresiaPlanPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public PlanGimnasio getPlan() {
        return plan;
    }

    public void setPlan(PlanGimnasio plan) {
        this.plan = plan;
    }
}
