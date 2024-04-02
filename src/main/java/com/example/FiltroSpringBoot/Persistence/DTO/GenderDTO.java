package com.example.FiltroSpringBoot.Persistence.DTO;

public class GenderDTO {

    private Long id; // Cambiado a Long para reflejar el tipo de dato autoincrementable
    private String gender;
    
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
