package domein;

public class DashboardDom {
    private GezienNietGezien banden = GezienNietGezien.NIETGEZIEN;

    public GezienNietGezien getBanden() {
        return banden;
    }

    public void setBanden(GezienNietGezien banden) {
        this.banden = banden;
    }
    
    private GezienNietGezien vloeistoffen = GezienNietGezien.NIETGEZIEN;

    public GezienNietGezien getVloeistoffen() {
        return vloeistoffen;
    }

    public void setVloeistoffen(GezienNietGezien vloeistoffen) {
        this.vloeistoffen = vloeistoffen;
    }
    
    private GezienNietGezien schakelaars = GezienNietGezien.NIETGEZIEN;

    public GezienNietGezien getSchakelaars() {
        return schakelaars;
    }

    public void setSchakelaars(GezienNietGezien schakelaars) {
        this.schakelaars = schakelaars;
    }
    
    private GezienNietGezien tanken = GezienNietGezien.NIETGEZIEN;

    public GezienNietGezien getTanken() {
        return tanken;
    }

    public void setTanken(GezienNietGezien tanken) {
        this.tanken = tanken;
    }
    
    private GezienNietGezien gps = GezienNietGezien.NIETGEZIEN;

    public GezienNietGezien getGps() {
        return gps;
    }

    public void setGps(GezienNietGezien gps) {
        this.gps = gps;
    }
    
    private GezienNietGezien stop = GezienNietGezien.NIETGEZIEN;

    public GezienNietGezien getStop() {
        return stop;
    }

    public void setStop(GezienNietGezien stop) {
        this.stop = stop;
    }
    
    private Toestand rotonde = Toestand.WIT;

    public Toestand getRotonde() {
        return rotonde;
    }

    public void setRotonde(Toestand rotonde) {
        this.rotonde = rotonde;
    }
    
    private Toestand rijbaan = Toestand.WIT;

    public Toestand getRijbaan() {
        return rijbaan;
    }

    public void setRijbaan(Toestand rijbaan) {
        this.rijbaan = rijbaan;
    }
    
    private Toestand stad = Toestand.WIT;

    public Toestand getStad() {
        return stad;
    }

    public void setStad(Toestand stad) {
        this.stad = stad;
    }
    
    private Toestand autosnelweg = Toestand.WIT;

    public Toestand getAutosnelweg() {
        return autosnelweg;
    }

    public void setAutosnelweg(Toestand autosnelweg) {
        this.autosnelweg = autosnelweg;
    }

    public DashboardDom() {
    }
    
    
}
