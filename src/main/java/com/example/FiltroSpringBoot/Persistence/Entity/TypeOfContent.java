package com.example.FiltroSpringBoot.Persistence.Entity;

import java.util.List;

import com.example.FiltroSpringBoot.Persistence.DTO.TypeOfContentDTO;

import jakarta.persistence.*;

//Ready
@Entity
@Table(name="TypeOfContent")
public class TypeOfContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Utilizando GenerationType.IDENTITY para generar automáticamente las IDs
    private Long id; // Cambiando el tipo de dato de la ID a Long

    @Column(name = "name", nullable = false)
    private String name;

    //Si en una tabla, hay un valor que se referencia como llave foránea en otra tabla, trae una lista y es @OneToMany, mappedBy es el nombre en Java
    @OneToMany(mappedBy = "typeOfContent", cascade = CascadeType.ALL)
    private List<Platform> platforms;
    
    //Getters and Setters
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

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }
    
    //ToString
    @Override
    public String toString() {
        return "TypeOfContent{" + "id=" + id + ", name=" + name + ", platforms=" + platforms + '}';
    }
    
    //DTO
    public TypeOfContentDTO toDTO(){
        TypeOfContentDTO typeOfContentDTO = new TypeOfContentDTO();
        typeOfContentDTO.setId(this.id); // No se necesita convertir a String
        typeOfContentDTO.setName(this.name);
        return typeOfContentDTO;
    }
    
}