package com.example.FiltroSpringBoot.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.FiltroSpringBoot.Domain.Service.GenderService;
import com.example.FiltroSpringBoot.Persistence.Entity.Gender;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genders")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")            //Para cada controlador
@SecurityRequirement(name = "bearerAuth")   //Para cada controlador
public class GenderController {

    @Autowired
    private GenderService genderService;

    @GetMapping
    public ResponseEntity<List<String>> findAllGenders() {
        List<String> genders = genderService.findAllGenders();
        return ResponseEntity.ok(genders);
    }

    @PostMapping("/save")
    public ResponseEntity<Gender> saveGender(@RequestBody Gender gender) {
        ResponseEntity<Gender> responseEntity = genderService.saveGender(gender);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseEntity.getBody());
    }

}
