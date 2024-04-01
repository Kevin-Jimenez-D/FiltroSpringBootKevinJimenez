package com.example.FiltroSpringBoot.Persistence.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

//Ready
@Entity
@Table(name="AudioVisual")
public class AudioVisual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    //3 llaves foraneas
    @ManyToMany
    @JoinColumn(name = "platform_ID")
    @JsonIgnore
    private Platform platform;

    @ManyToMany
    @JoinColumn(name = "gender_ID")
    @JsonIgnore
    private Gender gender;

    @ManyToMany
    @JoinColumn(name = "stateVisualization_ID")
    @JsonIgnore
    private StateVisualization stateVisualization;

    //Es llave foránea en otra tabla
    @OneToMany(mappedBy = "audioVisual", cascade = CascadeType.ALL)
    private List<Register> registers;

    //Relacion muchos a muchos
    @JoinTable(
        name = "CostumerAudioVisual",
        joinColumns = @JoinColumn(name = "audioVisual_ID",nullable = false),
        inverseJoinColumns = @JoinColumn(name = "costumer_ID",nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Costumer> costumers;

    //Metodo para añadir cliente
    public void addCustomer(Costumer costumer){
        if (this.costumers == null) {
            this.costumers = new ArrayList<>();
    }

    this.costumers.add(costumer);
    }
    
    //Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    
    //ToString
    @Override
    public String toString() {
        return "AudioVisual{" + "id=" + id + ", name=" + name + ", platform=" + platform + ", gender=" + gender + ", stateVisualization=" + stateVisualization + ", registers=" + registers + ", costumers=" + costumers + '}';
    }
    

}
