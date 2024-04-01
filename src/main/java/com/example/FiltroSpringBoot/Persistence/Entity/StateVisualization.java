package com.example.FiltroSpringBoot.Persistence.Entity;

import java.util.List;

import jakarta.persistence.*;

//Ready
@Entity
@Table(name="StateVisualization")
public class StateVisualization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "stateVisualization", nullable = false)
    private String stateVisualization;

    //Llave foránea a otra tabla
    @OneToMany(mappedBy = "stateVisualization", cascade = CascadeType.ALL)
    private List<AudioVisual> audioVisuals;
    
    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStateVisualization() {
        return stateVisualization;
    }

    public void setStateVisualization(String stateVisualization) {
        this.stateVisualization = stateVisualization;
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
        return "StateVisualization{" + "id=" + id + ", stateVisualization=" + stateVisualization + ", audioVisuals=" + audioVisuals + '}';
    }
    
    

}
