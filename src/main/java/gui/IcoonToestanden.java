/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DomeinController;
import domein.Toestand;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
        bepaalToestandLinksRijtechniek();
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
        } else if (controller.getButtonRijTechniek(10).getHuidigeToestand() == Toestand.WIT
                && controller.getButtonRijTechniek(11).getHuidigeToestand() == Toestand.WIT
                && controller.getButtonRijTechniek(0).getHuidigeToestand() == Toestand.WIT
                && controller.getButtonRijTechniek(1).getHuidigeToestand() == Toestand.WIT
                && controller.getButtonRijTechniek(2).getHuidigeToestand() == Toestand.WIT
                && controller.getButtonRijTechniek(3).getHuidigeToestand() == Toestand.WIT) {
            
            RijtechniekIcoonBoven = Toestand.WIT;
            
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
        } else if (controller.getButtonRijTechniek(4).getHuidigeToestand() == Toestand.WIT
                && controller.getButtonRijTechniek(5).getHuidigeToestand() == Toestand.WIT) {
            RijtechniekIcoonRechts = Toestand.WIT;
        } else {
            RijtechniekIcoonRechts = Toestand.ORANJE;
        }
    }
    
    public void bepaalToestandLinksRijtechniek() {
        //6 = garage
        //7 = achteruit
        //8 = acht
        //9 = helling
        if (controller.getButtonRijTechniek(6).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(7).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(8).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonRijTechniek(9).getHuidigeToestand() == Toestand.GROEN) {
            RijtechniekIcoonLinks = Toestand.GROEN;
        } else if (controller.getButtonRijTechniek(6).getHuidigeToestand() == Toestand.WIT
                && controller.getButtonRijTechniek(7).getHuidigeToestand() == Toestand.WIT
                && controller.getButtonRijTechniek(8).getHuidigeToestand() == Toestand.WIT
                && controller.getButtonRijTechniek(9).getHuidigeToestand() == Toestand.WIT) {
            RijtechniekIcoonLinks = Toestand.WIT;
            
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
    
    public void bepaalToestandenVerkeerstechniek() {
        bepaalToestandLinks();
        bepaalToestandBeneden();
        bepaalToestandRechts();
    }
    
    public void bepaalToestandLinks() {
        //8 = pinkers
        //7 = rechtsaf
        //9 = openbare weg
        if (controller.getButtonVerkeersTechniek(7).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonVerkeersTechniek(8).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonVerkeersTechniek(9).getHuidigeToestand() == Toestand.GROEN) {
            setVerkeerstechniekIcoonLinks(Toestand.GROEN);
        } else if (controller.getButtonVerkeersTechniek(7).getHuidigeToestand() == Toestand.ROOD
                || controller.getButtonVerkeersTechniek(8).getHuidigeToestand() == Toestand.ROOD
                || controller.getButtonVerkeersTechniek(9).getHuidigeToestand() == Toestand.ROOD) {
            setVerkeerstechniekIcoonLinks(Toestand.ROOD);
        } else if (controller.getButtonVerkeersTechniek(7).getHuidigeToestand() == Toestand.WIT
                && controller.getButtonVerkeersTechniek(8).getHuidigeToestand() == Toestand.WIT
                && controller.getButtonVerkeersTechniek(9).getHuidigeToestand() == Toestand.WIT) {
            setVerkeerstechniekIcoonLinks(Toestand.WIT);
            
        } else {
            setVerkeerstechniekIcoonLinks(Toestand.ORANJE);
        }
    }
    
    public void bepaalToestandRechts() {
        //0 = voorrang
        //1 = orders
        //2 = snelheid
        //3 = afstand
        if (controller.getButtonVerkeersTechniek(0).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonVerkeersTechniek(1).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonVerkeersTechniek(2).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonVerkeersTechniek(3).getHuidigeToestand() == Toestand.GROEN) {
            setVerkeerstechniekIcoonRechts(Toestand.GROEN);
        } else if (controller.getButtonVerkeersTechniek(0).getHuidigeToestand() == Toestand.ROOD
                || controller.getButtonVerkeersTechniek(1).getHuidigeToestand() == Toestand.ROOD
                || controller.getButtonVerkeersTechniek(2).getHuidigeToestand() == Toestand.ROOD
                || controller.getButtonVerkeersTechniek(3).getHuidigeToestand() == Toestand.ROOD) {
            setVerkeerstechniekIcoonRechts(Toestand.ROOD);
        }else if(controller.getButtonVerkeersTechniek(0).getHuidigeToestand() == Toestand.WIT
                && controller.getButtonVerkeersTechniek(1).getHuidigeToestand() == Toestand.WIT
                && controller.getButtonVerkeersTechniek(2).getHuidigeToestand() == Toestand.WIT
                && controller.getButtonVerkeersTechniek(3).getHuidigeToestand() == Toestand.WIT){
            setVerkeerstechniekIcoonRechts(Toestand.WIT);
        } else {
            setVerkeerstechniekIcoonRechts(Toestand.ORANJE);
        }
    }
    
    public void bepaalToestandBeneden() {
        //4 = inhalen
        //5 = kruisen
        //6 = linksaf
        if (controller.getButtonVerkeersTechniek(4).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonVerkeersTechniek(5).getHuidigeToestand() == Toestand.GROEN
                && controller.getButtonVerkeersTechniek(6).getHuidigeToestand() == Toestand.GROEN) {
            setVerkeerstechniekIcoonBeneden(Toestand.GROEN);
        } else if (controller.getButtonVerkeersTechniek(4).getHuidigeToestand() == Toestand.ROOD
                || controller.getButtonVerkeersTechniek(5).getHuidigeToestand() == Toestand.ROOD
                || controller.getButtonVerkeersTechniek(6).getHuidigeToestand() == Toestand.ROOD) {
            setVerkeerstechniekIcoonBeneden(Toestand.ROOD);
        }else if(controller.getButtonVerkeersTechniek(4).getHuidigeToestand() == Toestand.WIT
                && controller.getButtonVerkeersTechniek(5).getHuidigeToestand() == Toestand.WIT
                && controller.getButtonVerkeersTechniek(6).getHuidigeToestand() == Toestand.WIT){
            setVerkeerstechniekIcoonBeneden(Toestand.WIT);
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
    
    public void kleurStuur() {
        bepaalToestandenRijtechniek();
        kleurStuurBoven();
        kleurStuurRechts();
        kleurStuurLinks();
    }
    
    private Group rijtechniekIcoonGroup = new Group();
   

    public void kleurStuurBoven() {
        ImageView stuurBoven = new ImageView();
        stuurBoven.setFitWidth(150);
        stuurBoven.setFitHeight(150);
        if (rijtechniekIcoonGroup.getChildren().contains(stuurBoven)) {
            rijtechniekIcoonGroup.getChildren().remove(stuurBoven);
        }

        if (controller.getIcoonToestanden().getRijtechniekIcoonBoven() == Toestand.GROEN) {
            Image stuurGroenBoven = new Image("images/rijtechniekIcoon/stuurGroenBoven.png");
            stuurBoven.setImage(stuurGroenBoven);
        } else if (controller.getIcoonToestanden().getRijtechniekIcoonBoven() == Toestand.ORANJE) {
            Image stuurOranjeBoven = new Image("images/rijtechniekIcoon/stuurOranjeBoven.png");
            stuurBoven.setImage(stuurOranjeBoven);
        }else{
            //Doe niets/ laat wit
        }
        rijtechniekIcoonGroup.getChildren().add(stuurBoven);
    }

    public void kleurStuurRechts() {
        ImageView stuurRechts = new ImageView();
        stuurRechts.setFitWidth(150);
        stuurRechts.setFitHeight(150);
        if (rijtechniekIcoonGroup.getChildren().contains(stuurRechts)) {
            rijtechniekIcoonGroup.getChildren().remove(stuurRechts);
        }

        if (controller.getIcoonToestanden().getRijtechniekIcoonRechts() == Toestand.GROEN) {
            Image stuurGroenRechts = new Image("images/rijtechniekIcoon/stuurGroenRechts.png");
            stuurRechts.setImage(stuurGroenRechts);
        } else if (controller.getIcoonToestanden().getRijtechniekIcoonRechts() == Toestand.ORANJE) {
            Image stuurOranjeRechts = new Image("images/rijtechniekIcoon/stuurOranjeRechts.png");
            stuurRechts.setImage(stuurOranjeRechts);
        }else{
            //Doe niets / laat wit
        }

        rijtechniekIcoonGroup.getChildren().add(stuurRechts);
    }

    public void kleurStuurLinks() {
        ImageView stuurLinks = new ImageView();
        stuurLinks.setFitWidth(150);
        stuurLinks.setFitHeight(150);
        if (rijtechniekIcoonGroup.getChildren().contains(stuurLinks)) {
            rijtechniekIcoonGroup.getChildren().remove(stuurLinks);
        }

        if (controller.getIcoonToestanden().getRijtechniekIcoonLinks() == Toestand.GROEN) {
            Image stuurGroenLinks = new Image("images/rijtechniekIcoon/stuurGroenLinks.png");
            stuurLinks.setImage(stuurGroenLinks);
        } else if (controller.getIcoonToestanden().getRijtechniekIcoonLinks() == Toestand.ORANJE) {
            Image stuurOranjeLinks = new Image("images/rijtechniekIcoon/stuurOranjeLinks.png");
            stuurLinks.setImage(stuurOranjeLinks);
        }else{
            //doe niets, laat wit
        }

        rijtechniekIcoonGroup.getChildren().add(stuurLinks);
    }

    public Group getRijtechniekIcoonGroup() {
        return rijtechniekIcoonGroup;
    }
    
    private Group verkeerstechniekGroup = new Group();

    public Group getVerkeerstechniekGroup() {
        return verkeerstechniekGroup;
    }
    
    
    
    public void kleurRotonde() {
        controller.getIcoonToestanden().bepaalToestandenVerkeerstechniek();
        kleurRotondeLinks();
        kleurRotondeRechts();
        kleurRotondeBeneden();
    }

    public void kleurRotondeLinks() {
        ImageView rotondeLinks = new ImageView();
        rotondeLinks.setFitWidth(150);
        rotondeLinks.setFitHeight(150);

        if (verkeerstechniekGroup.getChildren().contains(rotondeLinks)) {
            verkeerstechniekGroup.getChildren().remove(rotondeLinks);
        }

        if (controller.getIcoonToestanden().getVerkeerstechniekIcoonLinks() == Toestand.GROEN) {
            Image rotondeGroenLinks = new Image("images/verkeerstechniekIcoon/rotondeGroenLinks.png");
            rotondeLinks.setImage(rotondeGroenLinks);
        } else if (controller.getIcoonToestanden().getVerkeerstechniekIcoonLinks() == Toestand.ORANJE) {
            Image rotondeOranjeLinks = new Image("images/verkeerstechniekIcoon/rotondeOranjeLinks.png");
            rotondeLinks.setImage(rotondeOranjeLinks);
        } else if (controller.getIcoonToestanden().getVerkeerstechniekIcoonLinks() == Toestand.ROOD) {
            Image rotondeRoodLinks = new Image("images/verkeerstechniekIcoon/rotondeRoodLinks.png");
            rotondeLinks.setImage(rotondeRoodLinks);
        }else{
            //Doe niets/laat wit
        }

        verkeerstechniekGroup.getChildren().add(rotondeLinks);
    }

    public void kleurRotondeRechts() {
        ImageView rotondeRechts = new ImageView();
        rotondeRechts.setFitWidth(150);
        rotondeRechts.setFitHeight(150);

        if (verkeerstechniekGroup.getChildren().contains(rotondeRechts)) {
            verkeerstechniekGroup.getChildren().remove(rotondeRechts);
        }

        if (controller.getIcoonToestanden().getVerkeerstechniekIcoonRechts() == Toestand.GROEN) {
            Image rotondeGroenRechts = new Image("images/verkeerstechniekIcoon/rotondeGroenRechts.png");
            rotondeRechts.setImage(rotondeGroenRechts);
        } else if (controller.getIcoonToestanden().getVerkeerstechniekIcoonRechts() == Toestand.ORANJE) {
            Image rotondeOranjeRechts = new Image("images/verkeerstechniekIcoon/rotondeOranjeRechts.png");
            rotondeRechts.setImage(rotondeOranjeRechts);
        } else if (controller.getIcoonToestanden().getVerkeerstechniekIcoonRechts() == Toestand.ROOD) {
            Image rotondeRoodRechts = new Image("images/verkeerstechniekIcoon/rotondeRoodRechts.png");
            rotondeRechts.setImage(rotondeRoodRechts);
        }else{
            //doe niets / laat wit
        }

        verkeerstechniekGroup.getChildren().add(rotondeRechts);
    }

    public void kleurRotondeBeneden() {
        ImageView rotondeBeneden = new ImageView();
        rotondeBeneden.setFitWidth(150);
        rotondeBeneden.setFitHeight(150);

        if (verkeerstechniekGroup.getChildren().contains(rotondeBeneden)) {
            verkeerstechniekGroup.getChildren().remove(rotondeBeneden);
        }

        if (controller.getIcoonToestanden().getVerkeerstechniekIcoonBeneden() == Toestand.GROEN) {
            Image rotondeGroenBeneden = new Image("images/verkeerstechniekIcoon/rotondeGroenBeneden.png");
            rotondeBeneden.setImage(rotondeGroenBeneden);
        } else if (controller.getIcoonToestanden().getVerkeerstechniekIcoonBeneden() == Toestand.ORANJE) {
            Image rotondeOranjeBeneden = new Image("images/verkeerstechniekIcoon/rotondeOranjeBeneden.png");
            rotondeBeneden.setImage(rotondeOranjeBeneden);
        } else if (controller.getIcoonToestanden().getVerkeerstechniekIcoonBeneden() == Toestand.ROOD) {
            Image rotondeRoodBeneden = new Image("images/verkeerstechniekIcoon/rotondeRoodBeneden.png");
            rotondeBeneden.setImage(rotondeRoodBeneden);
        }else{
            //doe niets/ laat  wit
        }

        verkeerstechniekGroup.getChildren().add(rotondeBeneden);
    }
}
