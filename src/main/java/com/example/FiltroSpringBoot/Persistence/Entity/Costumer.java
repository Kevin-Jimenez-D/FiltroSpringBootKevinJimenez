package com.example.FiltroSpringBoot.Persistence.Entity;

import jakarta.persistence.*;

import java.util.List;

//Ready
@Entity
@Table(name="Costumer")
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "secondName")
    private String secondName;

    @Column(name = "firstLastName", nullable = false)
    private String firstLastName;

    @Column(name = "secondLastName")
    private String secondLastName;

    //Relacion muchos a muchos
    @ManyToMany(mappedBy = "costumers")
    private List<AudioVisual> audioVisuals;
    
    //Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
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
        return "Costumer{" + "id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", firstLastName=" + firstLastName + ", secondLastName=" + secondLastName + ", audioVisuals=" + audioVisuals + '}';
    }
    
    

}
