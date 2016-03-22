package domein;

public class VerkeerstechniekDom {

    public VerkeerstechniekDom() {
    }
    
    private Toestand richtingaanwijzers;

    public Toestand getRichtingaanwijzers() {
        return richtingaanwijzers;
    }

    public void setRichtingaanwijzers(Toestand richtingaanwijzers) {
        this.richtingaanwijzers = richtingaanwijzers;
    }
    
    private Toestand openbareWeg;

    public Toestand getOpenbareWeg() {
        return openbareWeg;
    }

    public void setOpenbareWeg(Toestand openbareWeg) {
        this.openbareWeg = openbareWeg;
    }
    
    private Toestand voorrang;

    public Toestand getVoorrang() {
        return voorrang;
    }

    public void setVoorrang(Toestand voorrang) {
        this.voorrang = voorrang;
    }
    
    private Toestand verkeerstekens;

    public Toestand getVerkeerstekens() {
        return verkeerstekens;
    }

    public void setVerkeerstekens(Toestand verkeerstekens) {
        this.verkeerstekens = verkeerstekens;
    }
    
    private Toestand snelheid;

    public Toestand getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(Toestand snelheid) {
        this.snelheid = snelheid;
    }
    
    private Toestand afstandHouden;

    public Toestand getAfstandHouden() {
        return afstandHouden;
    }

    public void setAfstandHouden(Toestand afstandHouden) {
        this.afstandHouden = afstandHouden;
    }
    
    private Toestand inhalen;

    public Toestand getInhalen() {
        return inhalen;
    }

    public void setInhalen(Toestand inhalen) {
        this.inhalen = inhalen;
    }
    
    private Toestand kruisen;

    public Toestand getKruisen() {
        return kruisen;
    }

    public void setKruisen(Toestand kruisen) {
        this.kruisen = kruisen;
    }
    
    private Toestand linksaf;

    public Toestand getLinksaf() {
        return linksaf;
    }

    public void setLinksaf(Toestand linksaf) {
        this.linksaf = linksaf;
    }
    
    private Toestand rechtsaf;

    public Toestand getRechtsaf() {
        return rechtsaf;
    }

    public void setRechtsaf(Toestand rechtsaf) {
        this.rechtsaf = rechtsaf;
    }
}
