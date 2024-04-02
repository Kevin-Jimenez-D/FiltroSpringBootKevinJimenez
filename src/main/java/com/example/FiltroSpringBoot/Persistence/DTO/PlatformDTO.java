package com.example.FiltroSpringBoot.Persistence.DTO;

public class PlatformDTO {

    private Long id; // Cambiado a Long para reflejar el tipo de dato autoincrementable
    private String name;
    private Long typeOfContent_ID; // Cambiado a Long para reflejar el tipo de dato autoincrementable
    
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTypeOfContent_ID() {
        return typeOfContent_ID;
    }

    public void setTypeOfContent_ID(Long typeOfContent_ID) {
        this.typeOfContent_ID = typeOfContent_ID;
    }
}