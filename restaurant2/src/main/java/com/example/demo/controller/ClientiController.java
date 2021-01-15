package com.example.demo.controller;

import com.example.demo.dto.ClientiDto;
import com.example.demo.mapper.ClientiMapper;
import com.example.demo.model.Clienti;
import com.example.demo.service.ClientiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clienti")
public class ClientiController {
    private ClientiService clientiService;
    private ClientiMapper clientiMapper;

    public ClientiController(ClientiService clientiService, ClientiMapper clientiMapper) {
        this.clientiService = clientiService;
        this.clientiMapper = clientiMapper;
    }

    @PostMapping
    public ResponseEntity<Clienti> createUser(
            @RequestBody
            @Valid
                    ClientiDto clientiDto){

        Clienti saveuser =  clientiService.createUser(clientiMapper.userDtoToUser(clientiDto)) ;
        return ResponseEntity
                .created(null)
                .body(saveuser);
    }



}
