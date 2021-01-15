package com.example.demo.service;

import com.example.demo.model.Angajati;
import com.example.demo.repository.AngajatiRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AngajatiServiceTest {

    @Mock
    private AngajatiRepository angajatiRepository;
    @InjectMocks
    private AngajatiService angajatiService;

    @Test
    @DisplayName("Creaza Angajat")
    void createUser() {
        Angajati angajati = new Angajati("Mitica","sdasd@gmail.com","Oradea");
        Angajati savedAngatati = new Angajati(1,"Mitica","sdasd@gmail.com","Oradea");
        when (angajatiRepository.getByEmail(any())).thenReturn(Optional.empty());
        when (angajatiRepository.createUser(any())).thenReturn(savedAngatati);

        Angajati result = angajatiService.createUser(angajati);

        assertEquals(angajati.getName(),result.getName());
        assertEquals(angajati.getEmail(),result.getEmail());
        assertEquals(angajati.getCity(),result.getCity());
        assertEquals(1,result.getIduser());

        verify(angajatiRepository).getByEmail(any());
        verify(angajatiRepository).createUser(any());

    }
}