
package domein;

import java.util.ArrayList;
import javafx.scene.paint.Color;


public class ButtonHolder {
    
    private ArrayList<ButtonTechniekDomein> rijTechniekButtons;
    private ArrayList<ButtonTechniekDomein> verkeersTechniekButtons;

    public ButtonHolder() {
        rijTechniekButtons = new ArrayList<>();
        verkeersTechniekButtons = new ArrayList<>();
        
        //Rijtechniek
        
        //0 = Koppeling
        rijTechniekButtons.add(new ButtonTechniekDomein("images/rijtechniek/embrayageWit.png", "images/rijtechniek/embrayageRood.png",
                "images/rijtechniek/embrayageOranje.png", "images/rijtechniek/embrayageGroen.png"));
        //1 = Stuur
        rijTechniekButtons.add(new ButtonTechniekDomein("images/rijtechniek/stuurWit.png", "images/rijtechniek/stuurRood.png",
                "images/rijtechniek/stuurOranje.png", "images/rijtechniek/stuurGroen.png"));
        //2 = Schakelen
        rijTechniekButtons.add(new ButtonTechniekDomein("images/rijtechniek/schakelenWit.png", "images/rijtechniek/schakelenRood.png",
                "images/rijtechniek/schakelenOranje.png", "images/rijtechniek/schakelenGroen.png"));
        //3 = Kijken
        rijTechniekButtons.add(new ButtonTechniekDomein("images/rijtechniek/kijkenWit.png", "images/rijtechniek/kijkenRood.png",
                "images/rijtechniek/kijkenOranje.png", "images/rijtechniek/kijkenGroen.png"));
        //4 = Parkeren
        rijTechniekButtons.add(new ButtonTechniekDomein("images/rijtechniek/parkerenWit.png", "images/rijtechniek/parkerenRood.png",
                "images/rijtechniek/parkerenOranje.png", "images/rijtechniek/parkerenGroen.png"));
        //5 = Keren
        rijTechniekButtons.add(new ButtonTechniekDomein("images/rijtechniek/kerenWit.png", "images/rijtechniek/kerenRood.png",
                "images/rijtechniek/kerenOranje.png", "images/rijtechniek/kerenGroen.png"));
        //6 = Garage
        rijTechniekButtons.add(new ButtonTechniekDomein("images/rijtechniek/garageWit.png", "images/rijtechniek/garageRood.png",
                "images/rijtechniek/garageOranje.png", "images/rijtechniek/garageGroen.png"));
        //7 = Achteruit
        rijTechniekButtons.add(new ButtonTechniekDomein("images/rijtechniek/achteruitWit.png", "images/rijtechniek/achteruitRood.png",
                "images/rijtechniek/achteruitOranje.png", "images/rijtechniek/achteruitGroen.png"));
        //8 = Acht
        rijTechniekButtons.add(new ButtonTechniekDomein("images/rijtechniek/achtWit.png", "images/rijtechniek/achtRood.png",
                "images/rijtechniek/achtOranje.png", "images/rijtechniek/achtGroen.png"));
        //9 = Helling
        rijTechniekButtons.add(new ButtonTechniekDomein("images/rijtechniek/hellingWit.png", "images/rijtechniek/hellingRood.png",
                "images/rijtechniek/hellingOranje.png", "images/rijtechniek/hellingGroen.png"));
        //10 = Zithouding
        rijTechniekButtons.add(new ButtonTechniekDomein("images/rijtechniek/zithoudingWit.png", "images/rijtechniek/zithoudingRood.png", 
                "images/rijtechniek/zithoudingOranje.png", "images/rijtechniek/zithoudingGroen.png"));
        //11 = Remtechniek
        rijTechniekButtons.add(new ButtonTechniekDomein("images/rijtechniek/remWit.png", "images/rijtechniek/remRood.png",
                "images/rijtechniek/remOranje.png", "images/rijtechniek/remGroen.png"));
        
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
    
    public ButtonTechniekDomein getButtonRijTechniek(int index){
        return rijTechniekButtons.get(index);
    }
    
    public ButtonTechniekDomein getButtonVerkeersTechniek(int index){
        return verkeersTechniekButtons.get(index);
    }
    
    public void setEva1(){
        for (ButtonTechniekDomein rijTechniekButton : rijTechniekButtons) {
            if(null != rijTechniekButton.getHuidigeToestand())switch (rijTechniekButton.getHuidigeToestand()) {
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
        for (ButtonTechniekDomein verkeersTechniekButton : verkeersTechniekButtons) {
            if(null != verkeersTechniekButton.getHuidigeToestand())switch (verkeersTechniekButton.getHuidigeToestand()) {
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
    public void setEva2(){
        for (ButtonTechniekDomein verkeersTechniekButton : verkeersTechniekButtons) {
            if(null != verkeersTechniekButton.getHuidigeToestand())switch (verkeersTechniekButton.getHuidigeToestand()) {
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
        for (ButtonTechniekDomein rijTechniekButton : rijTechniekButtons) {
            if(null != rijTechniekButton.getHuidigeToestand())switch (rijTechniekButton.getHuidigeToestand()) {
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
    public void setEva3(){
        for (ButtonTechniekDomein rijTechniekButton : rijTechniekButtons) {
            if(null != rijTechniekButton.getHuidigeToestand())switch (rijTechniekButton.getHuidigeToestand()) {
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
        for (ButtonTechniekDomein verkeersTechniekButton : verkeersTechniekButtons) {
            if(null != verkeersTechniekButton.getHuidigeToestand())switch (verkeersTechniekButton.getHuidigeToestand()) {
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
