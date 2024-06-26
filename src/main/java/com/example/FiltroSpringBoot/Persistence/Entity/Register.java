package com.example.FiltroSpringBoot.Persistence.Entity;

import com.example.FiltroSpringBoot.Persistence.DTO.RegisterDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

//Ready
@Entity
@Table(name="Register")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "qualification", nullable = false, precision = 1)
    private Double qualification;

    @Column(name = "comment", nullable = false, length = 500)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "audiovisual_ID")
    @JsonIgnore
    private AudioVisual audioVisual;
    
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

    public AudioVisual getAudioVisual() {
        return audioVisual;
    }

    public void setAudioVisual(AudioVisual audioVisual) {
        this.audioVisual = audioVisual;
    }
    
    // ToString
    @Override
    public String toString() {
        return "Register{" + "id=" + id + ", qualification=" + qualification + ", comment=" + comment + ", audioVisual=" + audioVisual + '}';
    }
    
    // DTO
    public RegisterDTO toDTO(){
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setId(this.id);
        registerDTO.setQualification(this.qualification);
        registerDTO.setComment(this.comment);
        registerDTO.setAudioVisual_ID(this.audioVisual.getId());
        return registerDTO;
    }

}