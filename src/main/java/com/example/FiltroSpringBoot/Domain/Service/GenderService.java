package com.example.FiltroSpringBoot.Domain.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.FiltroSpringBoot.Persistence.Entity.Gender;

public interface GenderService {

    //Obtener todos los generos
    List<String> findAllGenders();

    //Guardar un nuevo genero
    ResponseEntity<Gender> saveGender(Gender gender);

}
