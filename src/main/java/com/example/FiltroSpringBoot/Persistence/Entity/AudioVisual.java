package com.example.FiltroSpringBoot.Persistence.Entity;

import java.util.ArrayList;
import java.util.List;

import com.example.FiltroSpringBoot.Persistence.DTO.AudioVisualDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

//Ready
@Entity
@Table(name="AudioVisual")
public class AudioVisual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Cambiado a Long para reflejar el tipo de dato autoincrementable

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "platform_ID")
    @JsonIgnore
    private Platform platform;

    @ManyToOne
    @JoinColumn(name = "gender_ID")
    @JsonIgnore
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "stateVisualization_ID")
    @JsonIgnore
    private StateVisualization stateVisualization;

    @OneToMany(mappedBy = "audioVisual", cascade = CascadeType.ALL)
    private List<Register> registers;

    @JoinTable(
        name = "CostumerAudioVisual",
        joinColumns = @JoinColumn(name = "audioVisual_ID",nullable = false),
        inverseJoinColumns = @JoinColumn(name = "costumer_ID",nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Costumer> costumers;

    public void addCustomer(Costumer costumer){
        if (this.costumers == null) {
            this.costumers = new ArrayList<>();
        }

        this.costumers.add(costumer);
    }

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

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public StateVisualization getStateVisualization() {
        return stateVisualization;
    }

    public void setStateVisualization(StateVisualization stateVisualization) {
        this.stateVisualization = stateVisualization;
    }

    public List<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(List<Register> registers) {
        this.registers = registers;
    }

    public List<Costumer> getCostumers() {
        return costumers;
    }

    public void setCostumers(List<Costumer> costumers) {
        this.costumers = costumers;
    }

    @Override
    public String toString() {
        return "AudioVisual{" + "id=" + id + ", name=" + name + ", platform=" + platform + ", gender=" + gender + ", stateVisualization=" + stateVisualization + ", registers=" + registers + ", costumers=" + costumers + '}';
    }

    public AudioVisualDTO toDTO(){
        AudioVisualDTO audioVisualDTO = new AudioVisualDTO();
        audioVisualDTO.setId(this.id);
        audioVisualDTO.setName(this.name);
        audioVisualDTO.setPlatform_ID(this.platform.getId());
        audioVisualDTO.setGender_ID(this.gender.getId());
        audioVisualDTO.setStateVisualization_ID(this.stateVisualization.getId());
        return audioVisualDTO;
    }
}
