package com.example.demo.service;

import com.example.demo.exception.DuplicateAngajatiException;
import com.example.demo.model.Angajati;
import com.example.demo.repository.AngajatiRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AngajatiService {
    private AngajatiRepository angajatiRepository;

    public AngajatiService(AngajatiRepository angajatiRepository) {
        this.angajatiRepository = angajatiRepository;
    }

    public Angajati createUser(Angajati angajati){

        Optional<Angajati> userWithSameEmail = angajatiRepository.getByEmail(angajati.getEmail());
        if(userWithSameEmail.isPresent()) {
            throw new DuplicateAngajatiException();
        }
       return angajatiRepository.createUser(angajati);
    }

    public void updateAngajati (Angajati angajati){
         angajatiRepository.updateAngajati(angajati);
    }

}
