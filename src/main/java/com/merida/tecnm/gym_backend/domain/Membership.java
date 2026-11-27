package com.merida.tecnm.gym_backend.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.time.LocalDateTime;
import java.util.List;

public class Membership {

    @JsonAlias({"idMembresia", "id"})
    private Integer membershipId;

    @JsonAlias({"idMiembro", "id_miembro"})
    private String memberId;

    @JsonAlias({"fechaInicio", "fecha_inicio", "fecha"})
    private LocalDateTime startDate;

    @JsonAlias({"medioPago", "medio_pago"})
    private String paymentMethod;

    @JsonAlias({"comentario"})
    private String comment;

    @JsonAlias({"estado"})
    private String state;

    @JsonAlias({"planes", "planesContratados", "membresiasPlanes"})
    private List<MembershipItem> items;

    public Integer getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Integer membershipId) {
        this.membershipId = membershipId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<MembershipItem> getItems() {
        return items;
    }

    public void setItems(List<MembershipItem> items) {
        this.items = items;
    }
}
