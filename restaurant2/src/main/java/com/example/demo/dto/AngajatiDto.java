package com.example.demo.dto;

import javax.validation.constraints.*;

public class AngajatiDto {
    @NotBlank
    @Size(max = 100)
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    @Size(max = 100)
    private String city;

    public AngajatiDto() {
    }

    public AngajatiDto(String name, String email, String city) {
        this.name = name;
        this.email = email;
        this.city = city;
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
