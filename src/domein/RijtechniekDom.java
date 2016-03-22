package domein;

public class RijtechniekDom {

    public RijtechniekDom() {
    }
    
    private Toestand zithouding = Toestand.WIT;

    public Toestand getZithouding() {
        return zithouding;
    }

    public void setZithouding(Toestand zithouding) {
        this.zithouding = zithouding;
    }
    
    private Toestand koppeling = Toestand.WIT;

    public Toestand getKoppeling() {
        return koppeling;
    }

    public void setKoppeling(Toestand koppeling) {
        this.koppeling = koppeling;
    }
    
    private Toestand remtechniek = Toestand.WIT;

    public Toestand getRemtechniek() {
        return remtechniek;
    }

    public void setRemtechniek(Toestand remtechniek) {
        this.remtechniek = remtechniek;
    }
   
    private Toestand stuurTechniek = Toestand.WIT;

    public Toestand getStuurTechniek() {
        return stuurTechniek;
    }

    public void setStuurTechniek(Toestand stuurTechniek) {
        this.stuurTechniek = stuurTechniek;
    }
    
    private Toestand schakelTechniek = Toestand.WIT;

    public Toestand getSchakelTechniek() {
        return schakelTechniek;
    }

    public void setSchakelTechniek(Toestand schakelTechniek) {
        this.schakelTechniek = schakelTechniek;
    }
    
    private Toestand kijkTechniek = Toestand.WIT;

    public Toestand getKijkTechniek() {
        return kijkTechniek;
    }

    public void setKijkTechniek(Toestand kijkTechniek) {
        this.kijkTechniek = kijkTechniek;
    }
    
    private Toestand parkeren = Toestand.WIT;

    public Toestand getParkeren() {
        return parkeren;
    }

    public void setParkeren(Toestand parkeren) {
        this.parkeren = parkeren;
    }
    
    private Toestand keren = Toestand.WIT;

    public Toestand getKeren() {
        return keren;
    }

    public void setKeren(Toestand keren) {
        this.keren = keren;
    }
    
    private Toestand garage = Toestand.WIT;

    public Toestand getGarage() {
        return garage;
    }

    public void setGarage(Toestand garage) {
        this.garage = garage;
    }
    
    private Toestand achteruit = Toestand.WIT;

    public Toestand getAchteruit() {
        return achteruit;
    }

    public void setAchteruit(Toestand achteruit) {
        this.achteruit = achteruit;
    }
    
    private Toestand acht = Toestand.WIT;

    public Toestand getAcht() {
        return acht;
    }

    public void setAcht(Toestand acht) {
        this.acht = acht;
    }
    
    private Toestand helling = Toestand.WIT;

    public Toestand getHelling() {
        return helling;
    }

    public void setHelling(Toestand helling) {
        this.helling = helling;
    }
}
