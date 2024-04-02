package com.example.FiltroSpringBoot.Persistence.DTO;

public class StateVisualizationDTO {

    private Long id; // Cambiado a Long para reflejar el tipo de dato autoincrementable
    private String stateVisualization;
    
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStateVisualization() {
        return stateVisualization;
    }

    public void setStateVisualization(String stateVisualization) {
        this.stateVisualization = stateVisualization;
    }
}
