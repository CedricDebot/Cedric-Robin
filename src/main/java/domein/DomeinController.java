/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import gui.Beginscherm;
import gui.Dashboard;

/**
 *
 * @author Robin Lanneer
 */
public class DomeinController {
    
    private Beginscherm beginscherm;
    private Leerling leerling;
    private Dashboard dashboard;

    public DomeinController(Beginscherm beginscherm, Leerling leerling) {
        this.beginscherm = beginscherm;
        this.leerling = leerling;
    }

    public Leerling getLeerling() {
        return leerling;
    }

    public Beginscherm getBeginscherm() {
        return beginscherm;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }
    
    public ButtonTechniekDomein getButtonRijTechniek(int index){
        return leerling.getButtonRijTechniek(index);
    }
    public ButtonTechniekDomein getButtonVerkeersTechniek(int index){
        return leerling.getButtonVerkeersTechniek(index);
    }
    
    public void setEva1(){
        leerling.getButtonHolder().setEva1();
    }
    public void setEva2(){
        leerling.getButtonHolder().setEva2();
    }
    public void setEva3(){
        leerling.getButtonHolder().setEva3();
    }
}
