package com.merida.tecnm.gym_backend.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Plan {

    @JsonAlias({"idPlan", "id"})
    private Integer planId;

    @JsonAlias({"nombre"})
    private String name;

    @JsonAlias({"precio"})
    private Double price;

    @JsonAlias({"duracionDias", "duracion_dias"})
    private Integer durationDays;

    @JsonAlias({"estado"})
    private Boolean active;

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
