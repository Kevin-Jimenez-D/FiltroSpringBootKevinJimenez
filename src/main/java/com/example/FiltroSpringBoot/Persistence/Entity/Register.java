package com.example.FiltroSpringBoot.Persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

//Ready
@Entity
@Table(name="Register")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "qualification", nullable = false, precision = 1)
    private Double qualification;

    @Column(name = "comment", nullable = false, length = 500)
    private String comment;

    //Llave foránea
    @ManyToOne
    @JoinColumn(name = "audiovisual_ID")
    @JsonIgnore
    private AudioVisual audioVisual;
    
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

    public AudioVisual getAudioVisual() {
        return audioVisual;
    }

    public void setAudioVisual(AudioVisual audioVisual) {
        this.audioVisual = audioVisual;
    }
    
    //ToString
    @Override
    public String toString() {
        return "Register{" + "id=" + id + ", qualification=" + qualification + ", comment=" + comment + ", audioVisual=" + audioVisual + '}';
    }
    
    

}
