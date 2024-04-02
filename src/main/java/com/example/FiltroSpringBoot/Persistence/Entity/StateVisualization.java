package com.example.FiltroSpringBoot.Persistence.Entity;

import java.util.List;

import com.example.FiltroSpringBoot.Persistence.DTO.StateVisualizationDTO;

import jakarta.persistence.*;

//Ready
@Entity
@Table(name="StateVisualization")
public class StateVisualization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stateVisualization", nullable = false)
    private String stateVisualization;

    @OneToMany(mappedBy = "stateVisualization", cascade = CascadeType.ALL)
    private List<AudioVisual> audioVisuals;
    
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

    public List<AudioVisual> getAudioVisuals() {
        return audioVisuals;
    }

    public void setAudioVisuals(List<AudioVisual> audioVisuals) {
        this.audioVisuals = audioVisuals;
    }
    
    // ToString
    @Override
    public String toString() {
        return "StateVisualization{" + "id=" + id + ", stateVisualization=" + stateVisualization + ", audioVisuals=" + audioVisuals + '}';
    }
    
    // DTO
    public StateVisualizationDTO toDTO(){
        StateVisualizationDTO stateVisualizationDTO = new StateVisualizationDTO();
        stateVisualizationDTO.setId(this.id);
        stateVisualizationDTO.setStateVisualization(this.stateVisualization);
        return stateVisualizationDTO;
    }

}