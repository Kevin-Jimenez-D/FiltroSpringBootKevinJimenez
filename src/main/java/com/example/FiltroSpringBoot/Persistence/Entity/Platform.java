package com.example.FiltroSpringBoot.Persistence.Entity;

import java.util.List;

import com.example.FiltroSpringBoot.Persistence.DTO.PlatformDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

//Ready
@Entity
@Table(name="Platform")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    //Si en una tabla, hay llaves foráneas, trae un objeto y es @ManyToOne name = es el nombre en la base de datos
    @ManyToOne
    @JoinColumn(name = "typeOfContent_ID")
    @JsonIgnore
    private TypeOfContent typeOfContent;

    //Llave foránea en otra tabla
    @OneToMany(mappedBy = "platform", cascade = CascadeType.ALL)
    private List<AudioVisual> audioVisuals;
    
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

    public TypeOfContent getTypeOfContent() {
        return typeOfContent;
    }

    public void setTypeOfContent(TypeOfContent typeOfContent) {
        this.typeOfContent = typeOfContent;
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
        return "Platform{" + "id=" + id + ", name=" + name + ", typeOfContent=" + typeOfContent + ", audioVisuals=" + audioVisuals + '}';
    }
    
    //DTO
    public PlatformDTO toDTO(){
        PlatformDTO platformDTO = new PlatformDTO();
        platformDTO.setId(this.id);
        platformDTO.setName(this.name);
        return platformDTO;
    }
    

}
