package com.example.demo.service;

import com.example.demo.exception.DuplicateClientiException;
import com.example.demo.model.Angajati;
import com.example.demo.model.Clienti;
import com.example.demo.repository.ClientiRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientiService {
    private ClientiRepository clientiRepository;

    public ClientiService(ClientiRepository clientiRepository) {
        this.clientiRepository = clientiRepository;
    }

    public Clienti createUser(Clienti clienti){

        Optional<Clienti> userWithSameEmail = clientiRepository.getByEmail(clienti.getEmail());
        if(userWithSameEmail.isPresent()) {
            throw new DuplicateClientiException();
        }
        return clientiRepository.createUser(clienti);
    }



}
