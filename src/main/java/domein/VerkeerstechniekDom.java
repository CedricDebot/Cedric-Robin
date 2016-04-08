package domein;

public class VerkeerstechniekDom {

    public VerkeerstechniekDom() {
    }
    
    private Toestand richtingaanwijzers = Toestand.WIT;

    public Toestand getRichtingaanwijzers() {
        return richtingaanwijzers;
    }

    public void setRichtingaanwijzers(Toestand richtingaanwijzers) {
        this.richtingaanwijzers = richtingaanwijzers;
    }
    
    private Toestand openbareWeg = Toestand.WIT;

    public Toestand getOpenbareWeg() {
        return openbareWeg;
    }

    public void setOpenbareWeg(Toestand openbareWeg) {
        this.openbareWeg = openbareWeg;
    }
    
    private Toestand voorrang = Toestand.WIT;

    public Toestand getVoorrang() {
        return voorrang;
    }

    public void setVoorrang(Toestand voorrang) {
        this.voorrang = voorrang;
    }
    
    private Toestand verkeerstekens = Toestand.WIT;

    public Toestand getVerkeerstekens() {
        return verkeerstekens;
    }

    public void setVerkeerstekens(Toestand verkeerstekens) {
        this.verkeerstekens = verkeerstekens;
    }
    
    private Toestand snelheid = Toestand.WIT;

    public Toestand getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(Toestand snelheid) {
        this.snelheid = snelheid;
    }
    
    private Toestand afstandHouden = Toestand.WIT;

    public Toestand getAfstandHouden() {
        return afstandHouden;
    }

    public void setAfstandHouden(Toestand afstandHouden) {
        this.afstandHouden = afstandHouden;
    }
    
    private Toestand inhalen = Toestand.WIT;

    public Toestand getInhalen() {
        return inhalen;
    }

    public void setInhalen(Toestand inhalen) {
        this.inhalen = inhalen;
    }
    
    private Toestand kruisen = Toestand.WIT;

    public Toestand getKruisen() {
        return kruisen;
    }

    public void setKruisen(Toestand kruisen) {
        this.kruisen = kruisen;
    }
    
    private Toestand linksaf = Toestand.WIT;

    public Toestand getLinksaf() {
        return linksaf;
    }

    public void setLinksaf(Toestand linksaf) {
        this.linksaf = linksaf;
    }
    
    private Toestand rechtsaf = Toestand.WIT;

    public Toestand getRechtsaf() {
        return rechtsaf;
    }

    public void setRechtsaf(Toestand rechtsaf) {
        this.rechtsaf = rechtsaf;
    }
    
    private Toestand verkeerstechniekIcoonLinks;

    public Toestand getVerkeerstechniekIcoonLinks() {
        return verkeerstechniekIcoonLinks;
    }

    public void setVerkeerstechniekIcoonLinks(Toestand verkeerstechniekIcoonLinks) {
        this.verkeerstechniekIcoonLinks = verkeerstechniekIcoonLinks;
    }
    
    public void bepaalToestandLinks(){
        if(richtingaanwijzers == Toestand.GROEN && kruisen == Toestand.GROEN && inhalen == Toestand.GROEN){
            setVerkeerstechniekIcoonLinks(Toestand.GROEN);
        }else if(richtingaanwijzers == Toestand.ROOD || kruisen == Toestand.ROOD || inhalen == Toestand.ROOD){
            setVerkeerstechniekIcoonLinks(Toestand.ROOD);
        }else {
            setVerkeerstechniekIcoonLinks(Toestand.ORANJE);
        }
    }
    
    private Toestand verkeerstechniekIcoonRechts;

    public Toestand getVerkeerstechniekIcoonRechts() {
        return verkeerstechniekIcoonRechts;
    }

    public void setVerkeerstechniekIcoonRechts(Toestand verkeerstechniekIcoonRechts) {
        this.verkeerstechniekIcoonRechts = verkeerstechniekIcoonRechts;
    }
    
    public void bepaalToestandRechts(){
        if(openbareWeg == Toestand.GROEN && linksaf == Toestand.GROEN && rechtsaf == Toestand.GROEN && afstandHouden == Toestand.GROEN){
            setVerkeerstechniekIcoonRechts(Toestand.GROEN);
        }else if(openbareWeg == Toestand.ROOD || linksaf == Toestand.ROOD || rechtsaf == Toestand.ROOD || afstandHouden == Toestand.ROOD){
            setVerkeerstechniekIcoonRechts(Toestand.ROOD);
        }else {
            setVerkeerstechniekIcoonRechts(Toestand.ORANJE);
        }
    }
    
    private Toestand verkeerstechniekIcoonBeneden;

    public Toestand getVerkeerstechniekIcoonBeneden() {
        return verkeerstechniekIcoonBeneden;
    }

    public void setVerkeerstechniekIcoonBeneden(Toestand verkeerstechniekIcoonBeneden) {
        this.verkeerstechniekIcoonBeneden = verkeerstechniekIcoonBeneden;
    }
    
    public void bepaalToestandBeneden(){
        if(voorrang == Toestand.GROEN && verkeerstekens == Toestand.GROEN && snelheid == Toestand.GROEN){
            setVerkeerstechniekIcoonBeneden(Toestand.GROEN);
        }else if (voorrang == Toestand.ROOD || verkeerstekens == Toestand.ROOD || snelheid == Toestand.ROOD){
            setVerkeerstechniekIcoonBeneden(Toestand.ROOD);
        }else {
            setVerkeerstechniekIcoonBeneden(Toestand.ORANJE);
        }
    }
}
