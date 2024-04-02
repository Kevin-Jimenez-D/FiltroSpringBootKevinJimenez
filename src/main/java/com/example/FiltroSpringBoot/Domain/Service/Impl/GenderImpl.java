package com.example.FiltroSpringBoot.Domain.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FiltroSpringBoot.Domain.Repository.GenderRepository;
import com.example.FiltroSpringBoot.Domain.Service.GenderService;
import com.example.FiltroSpringBoot.Persistence.Entity.Gender;

@Service // Indica que la clase es un servicio de Spring
public class GenderImpl implements GenderService {

    @Autowired // Inyecta una instancia de GenderRepository automáticamente
    private GenderRepository genderRepository;

    @Override
    public List<String> findAllGenders() {
        List<Gender> genders = genderRepository.findAll();
        return genders.stream()
                     .map(Gender::getGender)
                     .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Gender> saveGender(Gender gender) {
        if (gender == null) {
            return ResponseEntity.badRequest().build();
        }

        gender = genderRepository.save(gender);
        return ResponseEntity.ok(gender);
    }

}
