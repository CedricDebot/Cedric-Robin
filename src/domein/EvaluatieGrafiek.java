package domein;

/**
 *
 * @author Cédric
 */
public class EvaluatieGrafiek {

    private int positie;

    public EvaluatieGrafiek(int positie) {
        this.positie = positie;
    }

    public int getPositie() {
        return positie;
    }

    public void setPositie(int positie) {
        this.positie = positie;
    }

    public void plusEen() {
        if (positie != 12){
            positie++;
        }
    }

}
