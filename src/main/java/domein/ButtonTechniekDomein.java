/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import javafx.scene.paint.Color;

/**
 *
 * @author Robin
 */
public class ButtonTechniekDomein {

    //Toestanden
    private Toestand huidigeToestand;

    //kleuren Knop
    private String huidigeKleur;
    private final String rood;
    private final String oranje;
    private final String groen;
    private final String wit;

    //kleuren vierkantjes
    private Color rectangle1;
    private Color rectangle2;
    private Color rectangle3;

    public ButtonTechniekDomein(String wit, String rood, String oranje, String groen) {
        this.rood = rood;
        this.oranje = oranje;
        this.groen = groen;
        this.wit = wit;
        this.huidigeKleur = wit;
        this.huidigeToestand = Toestand.WIT;

        rectangle1 = Color.WHITE;
        rectangle2 = Color.WHITE;
        rectangle3 = Color.WHITE;
    }

    public String getHuidigeKleur() {
        return huidigeKleur;
    }

    public Toestand getHuidigeToestand() {
        return huidigeToestand;
    }

    public Color getRectangle1() {
        return rectangle1;
    }

    public Color getRectangle2() {
        return rectangle2;
    }

    public Color getRectangle3() {
        return rectangle3;
    }

    public void setRectangle1(Color rectangle1) {
        this.rectangle1 = rectangle1;
    }

    public void setRectangle2(Color rectangle2) {
        this.rectangle2 = rectangle2;
    }

    public void setRectangle3(Color rectangle3) {
        this.rectangle3 = rectangle3;
    }

    public void volgendeKleur() {
        if (huidigeToestand == Toestand.WIT) {
            huidigeKleur = rood;
            huidigeToestand = Toestand.ROOD;
        } else if (huidigeToestand == Toestand.ROOD) {
            huidigeKleur = oranje;
            huidigeToestand = Toestand.ORANJE;
        } else if (huidigeToestand == Toestand.ORANJE) {
            huidigeKleur = groen;
            huidigeToestand = Toestand.GROEN;
        } else {
            huidigeKleur = wit;
            huidigeToestand = Toestand.WIT;
        }
    }

    public boolean isGekleurd() {
        return huidigeToestand != Toestand.WIT;
    }

}
