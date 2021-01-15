package com.example.demo.controller;

import com.example.demo.dto.AngajatiDto;
import com.example.demo.dto.UpdateAngajatiDto;
import com.example.demo.mapper.AngajatiMapper;
import com.example.demo.model.Angajati;
import com.example.demo.service.AngajatiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/angajati")
public class AngajatiController {
    private AngajatiService angajatiService;
    private AngajatiMapper angajatiMapper;

    public AngajatiController(AngajatiService angajatiService, AngajatiMapper angajatiMapper) {
        this.angajatiService = angajatiService;
        this.angajatiMapper = angajatiMapper;
    }

    @PostMapping
        public ResponseEntity<Angajati> createUser(
                @RequestBody
                @Valid
                        AngajatiDto angajatiDto){

       Angajati saveuser =  angajatiService.createUser(angajatiMapper.userDtoToUser(angajatiDto)) ;
    return ResponseEntity
            .created(null)
            .body(saveuser);
        }



       @PutMapping("/{angajatiId}")
        public void updateAngajati(

        @PathVariable
        int angajatiId,

        @RequestBody
                @Valid
        UpdateAngajatiDto updateAngajatiDto){
        if(angajatiId != updateAngajatiDto.getId()){
            throw new RuntimeException("Variabila din patchu nu se potriveste cu id");
        }
        angajatiService.updateAngajati(angajatiMapper.updateAngajatiDtotoAngajati(updateAngajatiDto));






    }
}
