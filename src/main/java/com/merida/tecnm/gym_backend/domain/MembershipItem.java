package com.merida.tecnm.gym_backend.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MembershipItem {

    @JsonAlias({"idPlan", "id"})
    private Integer planId;

    @JsonAlias({"cantidad"})
    private Integer quantity;

    @JsonAlias({"subtotal"})
    private Double total;

    @JsonAlias({"estado"})
    private Boolean active = true;

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
