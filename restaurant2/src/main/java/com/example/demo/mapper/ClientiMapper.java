package com.example.demo.mapper;

import com.example.demo.dto.ClientiDto;
import com.example.demo.model.Clienti;
import org.springframework.stereotype.Component;

@Component
public class ClientiMapper {

    public Clienti userDtoToUser(ClientiDto clientiDto){
        return new Clienti( clientiDto.getName(), clientiDto.getEmail());

    }


}
