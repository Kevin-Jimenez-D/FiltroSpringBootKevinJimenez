package com.example.FiltroSpringBoot.Persistence.DTO;

public class PlatformDTO {

    private String id;
    private String name;
    private String typeOfContent_ID;
    
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

    public String getTypeOfContent_ID() {
        return typeOfContent_ID;
    }

    public void setTypeOfContent_ID(String typeOfContent_ID) {
        this.typeOfContent_ID = typeOfContent_ID;
    }
    

}
