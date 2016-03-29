/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import javafx.scene.image.Image;

/**
 *
 * @author Robin Lanneer
 */
public class Leerling {
    private String inschrijvingsNr;
    private String famillieNaam;
    private String voorNaam;
    private String email;
    //attribuut foto
    //Implementatie foto via tablet?
    private Image foto;
    
    private DashboardDom dashboardDom;
    private RijtechniekDom rijtechniekDom;
    private VerkeerstechniekDom verkeerstechniekDom;
    
    public Leerling(String inschrijvingsNr, String famillieNaam, String voorNaam, String email, Image foto) {
        this.famillieNaam = famillieNaam;
        this.voorNaam = voorNaam;
        this.email = email;
        this.inschrijvingsNr = inschrijvingsNr;
        this.foto = foto;
        dashboardDom = new DashboardDom();
        rijtechniekDom = new RijtechniekDom();
        verkeerstechniekDom = new VerkeerstechniekDom();
    }

    public String getInschrijvingsNr() {
        return inschrijvingsNr;
    }

    public void setInschrijvingsNr(String inschrijvingsNr) {
        this.inschrijvingsNr = inschrijvingsNr;
    }

    public String getFamillieNaam() {
        return famillieNaam;
    }

    public void setFamillieNaam(String famillieNaam) {
        this.famillieNaam = famillieNaam;
    }

    public String getVoorNaam() {
        return voorNaam;
    }

    public void setVoorNaam(String voorNaam) {
        this.voorNaam = voorNaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Image getFoto() {
        return foto;
    }

    public DashboardDom getDashboardDom() {
        return dashboardDom;
    }

    public void setDashboardDom(DashboardDom dashboardDom) {
        this.dashboardDom = dashboardDom;
    }

    public void setRijtechniekDom(RijtechniekDom rijtechniekDom) {
        this.rijtechniekDom = rijtechniekDom;
    }

    public RijtechniekDom getRijtechniekDom() {
        return rijtechniekDom;
    }

    public void setVerkeerstechniekDom(VerkeerstechniekDom verkeerstechniekDom) {
        this.verkeerstechniekDom = verkeerstechniekDom;
    }

    public VerkeerstechniekDom getVerkeerstechniekDom() {
        return verkeerstechniekDom;
    }
    
    
    
}
