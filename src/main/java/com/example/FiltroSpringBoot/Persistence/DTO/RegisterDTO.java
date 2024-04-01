package com.example.FiltroSpringBoot.Persistence.DTO;

public class RegisterDTO {

    private String id;
    private Double qualification;
    private String comment;
    private String audioVisual_ID;
    
    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAudioVisual_ID() {
        return audioVisual_ID;
    }

    public void setAudioVisual_ID(String audioVisual_ID) {
        this.audioVisual_ID = audioVisual_ID;
    }
    

}
