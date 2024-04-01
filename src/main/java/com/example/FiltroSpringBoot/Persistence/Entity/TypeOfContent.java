package com.example.FiltroSpringBoot.Persistence.Entity;

import java.util.List;

import jakarta.persistence.*;

//Ready
@Entity
@Table(name="TypeOfContent")
public class TypeOfContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    //Si en una tabla, hay un valor que se referencia como llave foránea en otra tabla, trae una lista y es @OneToMany, mappedBy es el nombre en Java
    @OneToMany(mappedBy = "typeOfContent", cascade = CascadeType.ALL)
    private List<Platform> platforms;
    
    //Getters and Setters
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
    
    
}
