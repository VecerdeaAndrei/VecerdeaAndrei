package com.example.demo.dto;

import javax.validation.constraints.*;

public class ClientiDto {
    @NotBlank
    @Size(max = 100)
    private String name;
    @NotBlank
    private String email;


    public ClientiDto() {
    }

    public ClientiDto(String name, String email) {
        this.name = name;
        this.email = email;

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
