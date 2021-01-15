package com.example.demo.mapper;

import com.example.demo.dto.AngajatiDto;
import com.example.demo.dto.UpdateAngajatiDto;
import com.example.demo.model.Angajati;
import org.springframework.stereotype.Component;

@Component
public class AngajatiMapper {

    public Angajati userDtoToUser(AngajatiDto angajatiDto){
        return new Angajati( angajatiDto.getName(), angajatiDto.getEmail(), angajatiDto.getCity());

    }


    public Angajati updateAngajatiDtotoAngajati(UpdateAngajatiDto updateAngajatiDto){
        return new Angajati(updateAngajatiDto.getId(),updateAngajatiDto.getName(),null,updateAngajatiDto.getCity());
    }
}
