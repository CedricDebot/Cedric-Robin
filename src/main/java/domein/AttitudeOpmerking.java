package domein;

public class AttitudeOpmerking {
    
    private String naam;
    private String opmerking;
    private boolean uitroeptekenActive = false;

    public AttitudeOpmerking() {
    }

    
    public AttitudeOpmerking(String naam, String opmerking) {
        this.naam = naam;
        if(opmerking.equalsIgnoreCase(" ") || opmerking.equalsIgnoreCase("")){
            this.opmerking = "";
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
