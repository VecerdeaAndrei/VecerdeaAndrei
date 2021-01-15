package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Clienti {
    private long iduser;
    private String name;
    private String email;


    public Clienti(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Clienti() {
    }

    public Clienti(long iduser, String name, String email) {
        this.iduser = iduser;
        this.name = name;
        this.email = email;

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


}
