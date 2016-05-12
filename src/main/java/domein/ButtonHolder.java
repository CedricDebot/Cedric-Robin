package domein;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class ButtonHolder {

    private ArrayList<ButtonTechniekDomein> rijTechniekButtons;
    private ArrayList<ButtonTechniekDomein> verkeersTechniekButtons;

    private ButtonTechniekDomein koppeling = new ButtonTechniekDomein("images/rijtechniek/embrayageWit.png", "images/rijtechniek/embrayageRood.png",
            "images/rijtechniek/embrayageOranje.png", "images/rijtechniek/embrayageGroen.png");
    private ButtonTechniekDomein stuur = new ButtonTechniekDomein("images/rijtechniek/stuurWit.png", "images/rijtechniek/stuurRood.png",
            "images/rijtechniek/stuurOranje.png", "images/rijtechniek/stuurGroen.png");
    private ButtonTechniekDomein schakelen = new ButtonTechniekDomein("images/rijtechniek/schakelenWit.png", "images/rijtechniek/schakelenRood.png",
            "images/rijtechniek/schakelenOranje.png", "images/rijtechniek/schakelenGroen.png");
    private ButtonTechniekDomein kijken = new ButtonTechniekDomein("images/rijtechniek/kijkenWit.png", "images/rijtechniek/kijkenRood.png",
            "images/rijtechniek/kijkenOranje.png", "images/rijtechniek/kijkenGroen.png");
    private ButtonTechniekDomein parkeren = new ButtonTechniekDomein("images/rijtechniek/parkerenWit.png", "images/rijtechniek/parkerenRood.png",
            "images/rijtechniek/parkerenOranje.png", "images/rijtechniek/parkerenGroen.png");
    private ButtonTechniekDomein keren = new ButtonTechniekDomein("images/rijtechniek/kerenWit.png", "images/rijtechniek/kerenRood.png",
            "images/rijtechniek/kerenOranje.png", "images/rijtechniek/kerenGroen.png");
    private ButtonTechniekDomein garage = new ButtonTechniekDomein("images/rijtechniek/garageWit.png", "images/rijtechniek/garageRood.png",
            "images/rijtechniek/garageOranje.png", "images/rijtechniek/garageGroen.png");
    private ButtonTechniekDomein achteruit = new ButtonTechniekDomein("images/rijtechniek/achteruitWit.png", "images/rijtechniek/achteruitRood.png",
            "images/rijtechniek/achteruitOranje.png", "images/rijtechniek/achteruitGroen.png");
    private ButtonTechniekDomein acht = new ButtonTechniekDomein("images/rijtechniek/achtWit.png", "images/rijtechniek/achtRood.png",
            "images/rijtechniek/achtOranje.png", "images/rijtechniek/achtGroen.png");
    private ButtonTechniekDomein helling = new ButtonTechniekDomein("images/rijtechniek/hellingWit.png", "images/rijtechniek/hellingRood.png",
                "images/rijtechniek/hellingOranje.png", "images/rijtechniek/hellingGroen.png");
    private ButtonTechniekDomein zithouding = new ButtonTechniekDomein("images/rijtechniek/zithoudingWit.png", "images/rijtechniek/zithoudingRood.png",
                "images/rijtechniek/zithoudingOranje.png", "images/rijtechniek/zithoudingGroen.png");
    private ButtonTechniekDomein remtechniek = new ButtonTechniekDomein("images/rijtechniek/remWit.png", "images/rijtechniek/remRood.png",
                "images/rijtechniek/remOranje.png", "images/rijtechniek/remGroen.png");

    public void setKoppeling(ButtonTechniekDomein koppeling) {
        this.koppeling = koppeling;
    }

    public void setStuur(ButtonTechniekDomein stuur) {
        this.stuur = stuur;
    }

    public void setSchakelen(ButtonTechniekDomein schakelen) {
        this.schakelen = schakelen;
    }

    public void setKijken(ButtonTechniekDomein kijken) {
        this.kijken = kijken;
    }

    public void setParkeren(ButtonTechniekDomein parkeren) {
        this.parkeren = parkeren;
    }

    public void setKeren(ButtonTechniekDomein keren) {
        this.keren = keren;
    }

    public void setAcht(ButtonTechniekDomein acht) {
        this.acht = acht;
    }

    public void setAchteruit(ButtonTechniekDomein achteruit) {
        this.achteruit = achteruit;
    }

    public void setGarage(ButtonTechniekDomein garage) {
        this.garage = garage;
    }

    public void setHelling(ButtonTechniekDomein helling) {
        this.helling = helling;
    }

    public void setRemtechniek(ButtonTechniekDomein remtechniek) {
        this.remtechniek = remtechniek;
    }

    public void setZithouding(ButtonTechniekDomein zithouding) {
        this.zithouding = zithouding;
    }

    public ButtonHolder() {
        rijTechniekButtons = new ArrayList<>();
        verkeersTechniekButtons = new ArrayList<>();

        //Rijtechniek
        //0 = Koppeling
        rijTechniekButtons.add(koppeling);
        //1 = Stuur
        rijTechniekButtons.add(stuur);
        //2 = Schakelen
        rijTechniekButtons.add(schakelen);
        //3 = Kijken
        rijTechniekButtons.add(kijken);
        //4 = Parkeren
        rijTechniekButtons.add(parkeren);
        //5 = Keren
        rijTechniekButtons.add(keren);
        //6 = Garage
        rijTechniekButtons.add(garage);
        //7 = Achteruit
        rijTechniekButtons.add(achteruit);
        //8 = Acht
        rijTechniekButtons.add(acht);
        //9 = Helling
        rijTechniekButtons.add(helling);
        //10 = Zithouding
        rijTechniekButtons.add(zithouding);
        //11 = Remtechniek
        rijTechniekButtons.add(remtechniek);

        //VerkeersTechniek
        //0 = Voorrang
        verkeersTechniekButtons.add(new ButtonTechniekDomein("images/verkeersTechniek/voorrangWit.png", "images/verkeersTechniek/voorrangRood.png",
                "images/verkeersTechniek/voorrangOranje.png", "images/verkeersTechniek/voorrangGroen.png"));
        //1 = OrderOpvolgen
        verkeersTechniekButtons.add(new ButtonTechniekDomein("images/verkeersTechniek/ordersWit.png", "images/verkeersTechniek/ordersRood.png",
                "images/verkeersTechniek/ordersOranje.png", "images/verkeersTechniek/ordersGroen.png"));
        //2 = Snelheid
        verkeersTechniekButtons.add(new ButtonTechniekDomein("images/verkeersTechniek/snelheidWit.png", "images/verkeersTechniek/snelheidRood.png",
                "images/verkeersTechniek/snelheidOranje.png", "images/verkeersTechniek/snelheidGroen.png"));
        //3 = Afstand
        verkeersTechniekButtons.add(new ButtonTechniekDomein("images/verkeersTechniek/afstandWit.png", "images/verkeersTechniek/afstandRood.png",
                "images/verkeersTechniek/afstandOranje.png", "images/verkeersTechniek/afstandGroen.png"));
        //4 = Inhalen
        verkeersTechniekButtons.add(new ButtonTechniekDomein("images/verkeersTechniek/inhalenWit.png", "images/verkeersTechniek/inhalenRood.png",
                "images/verkeersTechniek/inhalenOranje.png", "images/verkeersTechniek/inhalenGroen.png"));
        //5 = Kruisen
        verkeersTechniekButtons.add(new ButtonTechniekDomein("images/verkeersTechniek/kruisenWit.png", "images/verkeersTechniek/kruisenRood.png",
                "images/verkeersTechniek/kruisenOranje.png", "images/verkeersTechniek/kruisenGroen.png"));
        //6 = Linksaf
        verkeersTechniekButtons.add(new ButtonTechniekDomein("images/verkeersTechniek/linksAfWit.png", "images/verkeersTechniek/linksAfRood.png",
                "images/verkeersTechniek/linksAfOranje.png", "images/verkeersTechniek/linksAfGroen.png"));
        //7 = Rechtsaf
        verkeersTechniekButtons.add(new ButtonTechniekDomein("images/verkeersTechniek/rechtsAfWit.png", "images/verkeersTechniek/rechtsAfRood.png",
                "images/verkeersTechniek/rechtsAfOranje.png", "images/verkeersTechniek/rechtsAfGroen.png"));
        //8 = Pinkers
        verkeersTechniekButtons.add(new ButtonTechniekDomein("images/verkeersTechniek/pinkersWit.png", "images/verkeersTechniek/pinkersRood.png",
                "images/verkeersTechniek/pinkersOranje.png", "images/verkeersTechniek/pinkersGroen.png"));
        //9 = OpenbareWeg
        verkeersTechniekButtons.add(new ButtonTechniekDomein("images/verkeersTechniek/OWWit.png", "images/verkeersTechniek/OWRood.png",
                "images/verkeersTechniek/OWOranje.png", "images/verkeersTechniek/OWGroen.png"));

    }

    public ButtonTechniekDomein getButtonRijTechniek(int index) {
        return rijTechniekButtons.get(index);
    }

    public ButtonTechniekDomein getButtonVerkeersTechniek(int index) {
        return verkeersTechniekButtons.get(index);
    }

    public void setEva1() {
        for (ButtonTechniekDomein rijTechniekButton : rijTechniekButtons) {
            if (null != rijTechniekButton.getHuidigeToestand()) {
                switch (rijTechniekButton.getHuidigeToestand()) {
                    case WIT:
                        rijTechniekButton.setRectangle1(Color.WHITE);
                        break;
                    case GROEN:
                        rijTechniekButton.setRectangle1(Color.GREEN);
                        break;
                    case ORANJE:
                        rijTechniekButton.setRectangle1(Color.ORANGE);
                        break;
                    default:
                        rijTechniekButton.setRectangle1(Color.RED);
                        break;
                }
            }

        }
        for (ButtonTechniekDomein verkeersTechniekButton : verkeersTechniekButtons) {
            if (null != verkeersTechniekButton.getHuidigeToestand()) {
                switch (verkeersTechniekButton.getHuidigeToestand()) {
                    case WIT:
                        verkeersTechniekButton.setRectangle1(Color.WHITE);
                        break;
                    case GROEN:
                        verkeersTechniekButton.setRectangle1(Color.GREEN);
                        break;
                    case ORANJE:
                        verkeersTechniekButton.setRectangle1(Color.ORANGE);
                        break;
                    default:
                        verkeersTechniekButton.setRectangle1(Color.RED);
                        break;
                }
            }

        }
    }

    public void setEva2() {
        for (ButtonTechniekDomein verkeersTechniekButton : verkeersTechniekButtons) {
            if (null != verkeersTechniekButton.getHuidigeToestand()) {
                switch (verkeersTechniekButton.getHuidigeToestand()) {
                    case WIT:
                        verkeersTechniekButton.setRectangle2(Color.WHITE);
                        break;
                    case GROEN:
                        verkeersTechniekButton.setRectangle2(Color.GREEN);
                        break;
                    case ORANJE:
                        verkeersTechniekButton.setRectangle2(Color.ORANGE);
                        break;
                    default:
                        verkeersTechniekButton.setRectangle2(Color.RED);
                        break;
                }
            }

        }
        for (ButtonTechniekDomein rijTechniekButton : rijTechniekButtons) {
            if (null != rijTechniekButton.getHuidigeToestand()) {
                switch (rijTechniekButton.getHuidigeToestand()) {
                    case WIT:
                        rijTechniekButton.setRectangle2(Color.WHITE);
                        break;
                    case GROEN:
                        rijTechniekButton.setRectangle2(Color.GREEN);
                        break;
                    case ORANJE:
                        rijTechniekButton.setRectangle2(Color.ORANGE);
                        break;
                    default:
                        rijTechniekButton.setRectangle2(Color.RED);
                        break;
                }
            }

        }
    }

    public void setEva3() {
        for (ButtonTechniekDomein rijTechniekButton : rijTechniekButtons) {
            if (null != rijTechniekButton.getHuidigeToestand()) {
                switch (rijTechniekButton.getHuidigeToestand()) {
                    case WIT:
                        rijTechniekButton.setRectangle3(Color.WHITE);
                        break;
                    case GROEN:
                        rijTechniekButton.setRectangle3(Color.GREEN);
                        break;
                    case ORANJE:
                        rijTechniekButton.setRectangle3(Color.ORANGE);
                        break;
                    default:
                        rijTechniekButton.setRectangle3(Color.RED);
                        break;
                }
            }

        }
        for (ButtonTechniekDomein verkeersTechniekButton : verkeersTechniekButtons) {
            if (null != verkeersTechniekButton.getHuidigeToestand()) {
                switch (verkeersTechniekButton.getHuidigeToestand()) {
                    case WIT:
                        verkeersTechniekButton.setRectangle3(Color.WHITE);
                        break;
                    case GROEN:
                        verkeersTechniekButton.setRectangle3(Color.GREEN);
                        break;
                    case ORANJE:
                        verkeersTechniekButton.setRectangle3(Color.ORANGE);
                        break;
                    default:
                        verkeersTechniekButton.setRectangle3(Color.RED);
                        break;
                }
            }

        }
    }

    public ArrayList<ButtonTechniekDomein> getRijTechniekButtons() {
        return rijTechniekButtons;
    }

    public ArrayList<ButtonTechniekDomein> getVerkeersTechniekButtons() {
        return verkeersTechniekButtons;
    }

}
