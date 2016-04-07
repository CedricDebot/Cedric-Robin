package com.project.domein;

/**
 *
 * @author Cédric
 */
public class EvaluatieGrafiek {

    private int positie = 11;
    private String voortgang = "";

    public EvaluatieGrafiek() {
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
}
