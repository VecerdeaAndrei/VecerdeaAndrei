package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Angajati {
    private long iduser;
    private String name;
    private String email;
    private String city;

    public Angajati(String name, String email, String city) {
        this.name = name;
        this.email = email;
        this.city = city;
    }

    public Angajati() {
    }

    public Angajati(long iduser, String name, String email, String city) {
        this.iduser = iduser;
        this.name = name;
        this.email = email;
        this.city = city;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
