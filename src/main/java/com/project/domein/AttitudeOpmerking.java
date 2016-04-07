package com.project.domein;

public class AttitudeOpmerking {
    
    private String naam;
    private String opmerking;

    public AttitudeOpmerking(String naam, String opmerking) {
        this.naam = naam;
        this.opmerking = opmerking;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setOpmerking(String opmerking) {
        this.opmerking = opmerking;
    }

    public String getOpmerking() {
        return opmerking;
    }
    
    
}
