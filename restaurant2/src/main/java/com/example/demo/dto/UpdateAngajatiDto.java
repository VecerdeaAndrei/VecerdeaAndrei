package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateAngajatiDto {
    @NotNull
    private int id;
    @NotBlank
    @Size(max = 100)
    private String name;
    @NotBlank
    @Size(max = 100)
    private String city;

    public UpdateAngajatiDto(int id, @NotBlank @Size(max = 100) String name, @NotBlank @Size(max = 100) String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public UpdateAngajatiDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
