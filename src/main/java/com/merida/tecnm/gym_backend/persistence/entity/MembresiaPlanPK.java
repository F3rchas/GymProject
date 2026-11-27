package com.merida.tecnm.gym_backend.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MembresiaPlanPK implements Serializable {

    @Column(name = "id_membresia")
    private Integer idMembresia;

    @Column(name = "id_plan")
    private Integer idPlan;

    public Integer getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(Integer idMembresia) {
        this.idMembresia = idMembresia;
    }

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembresiaPlanPK that = (MembresiaPlanPK) o;
        return Objects.equals(idMembresia, that.idMembresia) &&
               Objects.equals(idPlan, that.idPlan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMembresia, idPlan);
    }
}
