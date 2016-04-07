package com.project.domein;

/**
 *
 * @author Cédric
 */
public class RijtechniekIcoon {

    private RijtechniekDom rijtechniekDom;

    private Toestand boven = Toestand.WIT;
    private Toestand links = Toestand.WIT;
    private Toestand rechts = Toestand.WIT;

    public RijtechniekIcoon(Toestand boven, Toestand links, Toestand rechts) {
        this.boven = boven;
        this.links = links;
        this.rechts = rechts;
    }

    public Toestand getBoven() {
        return boven;
    }

    public void setBoven(Toestand boven) {
        this.boven = boven;
    }

    public Toestand getLinks() {
        return links;
    }

    public void setLinks(Toestand links) {
        this.links = links;
    }

    public Toestand getRechts() {
        return rechts;
    }

    public void setRechts(Toestand rechts) {
        this.rechts = rechts;
    }

    public void kleurStuurBoven() {
        if(rijtechniekDom.getZithouding() == Toestand.GROEN && rijtechniekDom.getRemtechniek() == Toestand.GROEN 
                && rijtechniekDom.getKoppeling() == Toestand.GROEN && rijtechniekDom.getStuurTechniek() == Toestand.GROEN 
                && rijtechniekDom.getSchakelTechniek() == Toestand.GROEN && rijtechniekDom.getKijkTechniek() == Toestand.GROEN){
            setBoven(Toestand.GROEN);
        }else {
            setBoven(Toestand.ORANJE);
        }
    }

    public void kleurStuurRechts() {
        if(rijtechniekDom.getParkeren() == Toestand.GROEN && rijtechniekDom.getKeren() == Toestand.GROEN && rijtechniekDom.getGarage() == Toestand.GROEN && rijtechniekDom.getAchteruit() == Toestand.GROEN){
            setRechts(Toestand.GROEN);
        }else {
            setRechts(Toestand.ORANJE);
        }
    }

    public void kleurStuurLinks() {
        if(rijtechniekDom.getAcht() == Toestand.GROEN && rijtechniekDom.getHelling() == Toestand.GROEN){
            setLinks(Toestand.GROEN);
        }else {
            setLinks(Toestand.ORANJE);
        }
    }
}
