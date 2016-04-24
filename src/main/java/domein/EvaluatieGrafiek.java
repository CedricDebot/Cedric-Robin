package domein;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EvaluatieGrafiek {

    private int positie = 11;
    private String voortgang = "";
    private Label voortgangLabel;
    
    private Rectangle blok1 = new Rectangle(15, 30, Color.web("#22567b"));
    private Rectangle blok2 = new Rectangle(15, 40, Color.BLACK);
    private Rectangle blok3 = new Rectangle(15, 50, Color.BLACK);
    private Rectangle blok4 = new Rectangle(15, 60, Color.BLACK);
    private Rectangle blok5 = new Rectangle(15, 70, Color.BLACK);
    private Rectangle blok6 = new Rectangle(15, 80, Color.BLACK);
    private Rectangle blok7 = new Rectangle(15, 90, Color.BLACK);
    private Rectangle blok8 = new Rectangle(15, 100, Color.BLACK);
    private Rectangle blok9 = new Rectangle(15, 110, Color.BLACK);
    private Rectangle blok10 = new Rectangle(15, 120, Color.BLACK);
    private Rectangle blok11 = new Rectangle(15, 130, Color.BLACK);
    private Rectangle blok12 = new Rectangle(15, 140, Color.BLACK);

    public EvaluatieGrafiek() {
        voortgangLabel = new Label();
    }

    public int getPositie() {
        return positie;
    }

    public void setPositie(int positie) {
        this.positie = positie;
    }

    public String getVoortgang() {
        return voortgang;
    }

    public void setVoortgang(String voortgang) {
        this.voortgang = voortgang;
    }

    public void plusEen() {
        if (positie != 0){
            positie--;
        }
    }
    
    public void minEen(){
        if(positie != 11){
            positie++;
        }
    }

    public Label getVoortgangLabel() {
        return voortgangLabel;
    }

    public void setVoortgangLabel(Label voortgangLabel) {
        this.voortgangLabel = voortgangLabel;
    }

    public Rectangle getBlok1() {
        return blok1;
    }

    public void setBlok1(Rectangle blok1) {
        this.blok1 = blok1;
    }

    public Rectangle getBlok2() {
        return blok2;
    }

    public void setBlok2(Rectangle blok2) {
        this.blok2 = blok2;
    }

    public Rectangle getBlok3() {
        return blok3;
    }

    public void setBlok3(Rectangle blok3) {
        this.blok3 = blok3;
    }

    public Rectangle getBlok4() {
        return blok4;
    }

    public void setBlok4(Rectangle blok4) {
        this.blok4 = blok4;
    }

    public Rectangle getBlok5() {
        return blok5;
    }

    public void setBlok5(Rectangle blok5) {
        this.blok5 = blok5;
    }

    public Rectangle getBlok6() {
        return blok6;
    }

    public void setBlok6(Rectangle blok6) {
        this.blok6 = blok6;
    }

    public Rectangle getBlok7() {
        return blok7;
    }

    public void setBlok7(Rectangle blok7) {
        this.blok7 = blok7;
    }

    public Rectangle getBlok8() {
        return blok8;
    }

    public void setBlok8(Rectangle blok8) {
        this.blok8 = blok8;
    }

    public Rectangle getBlok9() {
        return blok9;
    }

    public void setBlok9(Rectangle blok9) {
        this.blok9 = blok9;
    }

    public Rectangle getBlok10() {
        return blok10;
    }

    public void setBlok10(Rectangle blok10) {
        this.blok10 = blok10;
    }

    public Rectangle getBlok11() {
        return blok11;
    }

    public void setBlok11(Rectangle blok11) {
        this.blok11 = blok11;
    }

    public Rectangle getBlok12() {
        return blok12;
    }

    public void setBlok12(Rectangle blok12) {
        this.blok12 = blok12;
    }
    
    
}
