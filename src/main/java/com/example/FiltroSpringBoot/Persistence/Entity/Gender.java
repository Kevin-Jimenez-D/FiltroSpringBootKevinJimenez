package com.example.FiltroSpringBoot.Persistence.Entity;

import java.util.List;

import com.example.FiltroSpringBoot.Persistence.DTO.GenderDTO;

import jakarta.persistence.*;

//Ready
@Entity
@Table(name="Gender")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "gender", nullable = false)
    private String gender;

    //Llave foranea a otra tabla
    @OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
    private List<AudioVisual> audioVisuals;
    
    //Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<AudioVisual> getAudioVisuals() {
        return audioVisuals;
    }

    public void setAudioVisuals(List<AudioVisual> audioVisuals) {
        this.audioVisuals = audioVisuals;
    }
    
    //ToString
    @Override
    public String toString() {
        return "Gender{" + "id=" + id + ", gender=" + gender + ", audioVisuals=" + audioVisuals + '}';
    }

    //DTO
    public GenderDTO toDTO(){
        GenderDTO genderDTO = new GenderDTO();
        genderDTO.setId(this.id);
        genderDTO.setGender(this.gender);
        return genderDTO;
    }
    
    

}
