package com.example.FiltroSpringBoot.Persistence.DTO;

public class AudioVisualDTO {

    private Long id; // Cambiado a Long para reflejar el tipo de dato autoincrementable
    private String name;
    private Long platform_ID; // Cambiado a Long para reflejar el tipo de dato autoincrementable
    private Long gender_ID; // Cambiado a Long para reflejar el tipo de dato autoincrementable
    private Long stateVisualization_ID; // Cambiado a Long para reflejar el tipo de dato autoincrementable
    
    //Getters and Setters
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

    public Long getPlatform_ID() {
        return platform_ID;
    }

    public void setPlatform_ID(Long platform_ID) {
        this.platform_ID = platform_ID;
    }

    public Long getGender_ID() {
        return gender_ID;
    }

    public void setGender_ID(Long gender_ID) {
        this.gender_ID = gender_ID;
    }

    public Long getStateVisualization_ID() {
        return stateVisualization_ID;
    }

    public void setStateVisualization_ID(Long stateVisualization_ID) {
        this.stateVisualization_ID = stateVisualization_ID;
    }
}
