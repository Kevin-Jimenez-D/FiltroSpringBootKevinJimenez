package com.example.FiltroSpringBoot.Persistence.DTO;

public class RegisterDTO {

    private Long id; // Cambiado a Long para reflejar el tipo de dato autoincrementable
    private Double qualification;
    private String comment;
    private Long audioVisual_ID; // Cambiado a Long para reflejar el tipo de dato autoincrementable
    
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQualification() {
        return qualification;
    }

    public void setQualification(Double qualification) {
        this.qualification = qualification;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getAudioVisual_ID() {
        return audioVisual_ID;
    }

    public void setAudioVisual_ID(Long audioVisual_ID) {
        this.audioVisual_ID = audioVisual_ID;
    }
}