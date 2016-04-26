/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import domein.Toestand;

/**
 *
 * @author Robin
 */
public class IcoonToestanden {

    private DomeinController controller;

    private Toestand RijtechniekIcoonBoven;
    private Toestand RijtechniekIcoonRechts;
    private Toestand RijtechniekIcoonLinks;

    private Toestand verkeerstechniekIcoonLinks;
    private Toestand verkeerstechniekIcoonRechts;
    private Toestand verkeerstechniekIcoonBeneden;

    public IcoonToestanden(DomeinController controller) {
        this.controller = controller;

    }

    public void bepaalToestandenRijtechniek() {
        bepaalToestandBovenRijtechniek();
        bepaalToestandLinksVerkeersrechniek();
        bepaalToestandRechtsRijtechniek();
    }

    public void bepaalToestandBovenRijtechniek() {
        //10 = zithouding
        //0 = koppelng
        //11 = remtechniek
        //1 = stuur
        //2 = schakelen
        //3 = kijken
        if (controller.getButtonRijTechniek(10).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(0).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(11).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(1).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(2).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(3).getHuidigeToestand() == Toestand.GROEN) {
            RijtechniekIcoonBoven = Toestand.GROEN;
        } else {
            RijtechniekIcoonBoven = Toestand.ORANJE;
        }
    }

    public void bepaalToestandRechtsRijtechniek() {
        // 4 = parkeren
        // 5 = keren

        if (controller.getButtonRijTechniek(4).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(5).getHuidigeToestand() == Toestand.GROEN) {
            RijtechniekIcoonRechts = Toestand.GROEN;
        } else {
            RijtechniekIcoonRechts = Toestand.ORANJE;
        }
    }

    public void bepaalToestandLinksVerkeersrechniek() {
        //6 = garage
        //7 = achteruit
        //8 = acht
        //9 = helling
        if (controller.getButtonRijTechniek(6).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(7).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(8).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(9).getHuidigeToestand() == Toestand.GROEN) {
            RijtechniekIcoonLinks = Toestand.GROEN;
        } else {
            RijtechniekIcoonLinks = Toestand.ORANJE;
        }
    }

    public Toestand getRijtechniekIcoonBoven() {
        return RijtechniekIcoonBoven;
    }

    public Toestand getRijtechniekIcoonRechts() {
        return RijtechniekIcoonRechts;
    }

    public Toestand getRijtechniekIcoonLinks() {
        return RijtechniekIcoonLinks;
    }

    public Toestand getVerkeerstechniekIcoonLinks() {
        return verkeerstechniekIcoonLinks;
    }

    public void setVerkeerstechniekIcoonLinks(Toestand verkeerstechniekIcoonLinks) {
        this.verkeerstechniekIcoonLinks = verkeerstechniekIcoonLinks;
    }
    
    
    
    public void bepaalToestandenVerkeerstechniek(){
        bepaalToestandLinks();
        bepaalToestandBeneden();
        bepaalToestandRechts();
    }

    public void bepaalToestandLinks() {
        //8 = pinkers
        //5 = kruisen
        //4 = inhalen
        if (controller.getButtonVerkeersTechniek(8).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonVerkeersTechniek(5).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonVerkeersTechniek(4).getHuidigeToestand() == Toestand.GROEN) {
            setVerkeerstechniekIcoonLinks(Toestand.GROEN);
        } else if (controller.getButtonVerkeersTechniek(8).getHuidigeToestand() == Toestand.ROOD
                || controller.getButtonVerkeersTechniek(5).getHuidigeToestand() == Toestand.ROOD
                || controller.getButtonVerkeersTechniek(4).getHuidigeToestand() == Toestand.ROOD) {
            setVerkeerstechniekIcoonLinks(Toestand.ROOD);
        } else {
            setVerkeerstechniekIcoonLinks(Toestand.ORANJE);
        }
    }

    

    public void bepaalToestandRechts() {
        //9 = OpenbareWeg
        //6 = linksaf
        //7 = rechtsaf
        //3 = afstand
        if (controller.getButtonVerkeersTechniek(9).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonVerkeersTechniek(6).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonVerkeersTechniek(7).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonVerkeersTechniek(3).getHuidigeToestand() == Toestand.GROEN) {
            setVerkeerstechniekIcoonRechts(Toestand.GROEN);
        } else if (controller.getButtonVerkeersTechniek(9).getHuidigeToestand() == Toestand.ROOD
                || controller.getButtonVerkeersTechniek(6).getHuidigeToestand() == Toestand.ROOD
                || controller.getButtonVerkeersTechniek(7).getHuidigeToestand() == Toestand.ROOD
                || controller.getButtonVerkeersTechniek(3).getHuidigeToestand() == Toestand.ROOD) {
            setVerkeerstechniekIcoonRechts(Toestand.ROOD);
        } else {
            setVerkeerstechniekIcoonRechts(Toestand.ORANJE);
        }
    }

    

    public void bepaalToestandBeneden() {
        //0 = voorrang
        //1 = orders
        //2 = snelheid
        if (controller.getButtonVerkeersTechniek(0).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonVerkeersTechniek(1).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonVerkeersTechniek(2).getHuidigeToestand() == Toestand.GROEN) {
            setVerkeerstechniekIcoonBeneden(Toestand.GROEN);
        } else if (controller.getButtonVerkeersTechniek(0).getHuidigeToestand() == Toestand.ROOD
                || controller.getButtonVerkeersTechniek(1).getHuidigeToestand() == Toestand.ROOD
                || controller.getButtonVerkeersTechniek(2).getHuidigeToestand() == Toestand.ROOD) {
            setVerkeerstechniekIcoonBeneden(Toestand.ROOD);
        } else {
            setVerkeerstechniekIcoonBeneden(Toestand.ORANJE);
        }
    }
    
    public Toestand getVerkeerstechniekIcoonBeneden() {
        return verkeerstechniekIcoonBeneden;
    }

    public void setVerkeerstechniekIcoonBeneden(Toestand verkeerstechniekIcoonBeneden) {
        this.verkeerstechniekIcoonBeneden = verkeerstechniekIcoonBeneden;
    }

    public Toestand getVerkeerstechniekIcoonRechts() {
        return verkeerstechniekIcoonRechts;
    }

    public void setVerkeerstechniekIcoonRechts(Toestand verkeerstechniekIcoonRechts) {
        this.verkeerstechniekIcoonRechts = verkeerstechniekIcoonRechts;
    }
}
