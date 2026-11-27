package com.merida.tecnm.gym_backend.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Member {

    @JsonAlias({"id", "idMiembro"})
    private String memberId;

    @JsonAlias({"nombre"})
    private String name;

    @JsonAlias({"apellidos"})
    private String lastName;

    @JsonAlias({"celular", "telefono"})
    private Long cellphone;

    @JsonAlias({"correoElectronico", "correo"})
    private String email;

    @JsonAlias({"contrasena", "clave"})
    private String password;

    @JsonAlias({"estado"})
    private Boolean active;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCellphone() {
        return cellphone;
    }

    public void setCellphone(Long cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
