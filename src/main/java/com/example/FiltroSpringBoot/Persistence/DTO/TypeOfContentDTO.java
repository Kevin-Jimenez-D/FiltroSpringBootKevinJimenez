package com.example.FiltroSpringBoot.Persistence.DTO;

public class TypeOfContentDTO {

    private Long id; // Cambiando el tipo de dato de la ID a Long
    private String name;

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
}
