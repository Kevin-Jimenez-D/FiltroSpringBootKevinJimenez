package com.example.FiltroSpringBoot.Persistence.DTO;

public class AudioVisualDTO {

    private String id;
    private String name;
    private String platform_ID;
    private String gender_ID;
    private String stateVisualization_ID;
    
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

    public String getPlatform_ID() {
        return platform_ID;
    }

    public void setPlatform_ID(String platform_ID) {
        this.platform_ID = platform_ID;
    }

    public String getGender_ID() {
        return gender_ID;
    }

    public void setGender_ID(String gender_ID) {
        this.gender_ID = gender_ID;
    }

    public String getStateVisualization_ID() {
        return stateVisualization_ID;
    }

    public void setStateVisualization_ID(String stateVisualization_ID) {
        this.stateVisualization_ID = stateVisualization_ID;
    }
    

}
