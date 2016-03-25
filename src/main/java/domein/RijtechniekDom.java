package domein;

public class RijtechniekDom {
    
    private Toestand zithouding ;

    public Toestand getZithouding() {
        return zithouding;
    }

    public void setZithouding(Toestand zithouding) {
        this.zithouding = zithouding;
    }
    
    private Toestand koppeling ;

    public Toestand getKoppeling() {
        return koppeling;
    }

    public void setKoppeling(Toestand koppeling) {
        this.koppeling = koppeling;
    }
    
    private Toestand remtechniek ;

    public Toestand getRemtechniek() {
        return remtechniek;
    }

    public void setRemtechniek(Toestand remtechniek) {
        this.remtechniek = remtechniek;
    }
   
    private Toestand stuurTechniek ;

    public Toestand getStuurTechniek() {
        return stuurTechniek;
    }

    public void setStuurTechniek(Toestand stuurTechniek) {
        this.stuurTechniek = stuurTechniek;
    }
    
    private Toestand schakelTechniek ;

    public Toestand getSchakelTechniek() {
        return schakelTechniek;
    }

    public void setSchakelTechniek(Toestand schakelTechniek) {
        this.schakelTechniek = schakelTechniek;
    }
    
    private Toestand kijkTechniek ;

    public Toestand getKijkTechniek() {
        return kijkTechniek;
    }

    public void setKijkTechniek(Toestand kijkTechniek) {
        this.kijkTechniek = kijkTechniek;
    }
    
    private Toestand parkeren ;

    public Toestand getParkeren() {
        return parkeren;
    }

    public void setParkeren(Toestand parkeren) {
        this.parkeren = parkeren;
    }
    
    private Toestand keren ;

    public Toestand getKeren() {
        return keren;
    }

    public void setKeren(Toestand keren) {
        this.keren = keren;
    }
    
    private Toestand garage ;

    public Toestand getGarage() {
        return garage;
    }

    public void setGarage(Toestand garage) {
        this.garage = garage;
    }
    
    private Toestand achteruit ;

    public Toestand getAchteruit() {
        return achteruit;
    }

    public void setAchteruit(Toestand achteruit) {
        this.achteruit = achteruit;
    }
    
    private Toestand acht ;

    public Toestand getAcht() {
        return acht;
    }

    public void setAcht(Toestand acht) {
        this.acht = acht;
    }
    
    private Toestand helling ;

    public Toestand getHelling() {
        return helling;
    }

    public void setHelling(Toestand helling) {
        this.helling = helling;
    }

    public RijtechniekDom(Toestand zithouding, Toestand koppeling, Toestand remtechniek, Toestand stuurTechniek, Toestand schakelTechniek, Toestand kijkTechniek, Toestand parkeren, Toestand keren, Toestand garage, Toestand achteruit, Toestand acht, Toestand helling) {
        this.zithouding = zithouding;
        this.koppeling = koppeling;
        this.remtechniek = remtechniek;
        this.stuurTechniek = stuurTechniek;
        this.schakelTechniek = schakelTechniek;
        this.kijkTechniek = kijkTechniek;
        this.parkeren = parkeren;
        this.keren = keren;
        this.garage = garage;
        this.achteruit = achteruit;
        this.acht = acht;
        this.helling = helling;
    }
    
    
}
