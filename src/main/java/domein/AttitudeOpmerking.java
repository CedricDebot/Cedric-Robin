/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

/**
 *
 * @author Robin
 */
public class AttitudeOpmerking {
    
    private String naam;
    private String opmerking;
    private boolean uitroeptekenActive = false;

    public AttitudeOpmerking(String naam, String opmerking) {
        this.naam = naam;
        if(opmerking == null || opmerking.equalsIgnoreCase("")){
            this.opmerking = naam;
        }else{
            this.opmerking = opmerking;
        }
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

    public boolean isUitroeptekenActive() {
        return uitroeptekenActive;
    }

    public void setUitroeptekenActive(boolean uitroeptekenActive) {
        this.uitroeptekenActive = uitroeptekenActive;
    }
}
