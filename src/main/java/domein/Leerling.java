/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
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
    //Implementatie foto via tablet?
    private Image foto;
    
    //Gegevens knoppen
    private DashboardDom dashboardDom;
    private RijtechniekDom rijtechniekDom;
    private VerkeerstechniekDom verkeerstechniekDom;
    //Opmerkingen Atttiude
    private ArrayList<AttitudeOpmerking> standaardOpmerkingenList;
    
    public Leerling(String inschrijvingsNr, String famillieNaam, String voorNaam, String email, Image foto) {
        this.famillieNaam = famillieNaam;
        this.voorNaam = voorNaam;
        this.email = email;
        this.inschrijvingsNr = inschrijvingsNr;
        this.foto = foto;
        dashboardDom = new DashboardDom();
        rijtechniekDom = new RijtechniekDom();
        verkeerstechniekDom = new VerkeerstechniekDom();
        maakStandaardOpmerkingenList();
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

    public ArrayList<AttitudeOpmerking> getStandaardOpmerkingenList() {
        return standaardOpmerkingenList;
    }
    
    
    
    private void maakStandaardOpmerkingenList(){
        standaardOpmerkingenList = new ArrayList<>();
        
         //standaardOpmerkingen
         AttitudeOpmerking Zenuwachtig = new AttitudeOpmerking("Zenuwachtig", "");
         AttitudeOpmerking Concentratie = new AttitudeOpmerking("Concentratie", "");
         AttitudeOpmerking Schrik = new AttitudeOpmerking("Schrik", "");
         AttitudeOpmerking Asociaal = new AttitudeOpmerking("Asociaal", "");
         AttitudeOpmerking Verkeersgevaarlijk = new AttitudeOpmerking("Verkeersgevaarlijk", "");
         AttitudeOpmerking AgressiefRijgedrag = new AttitudeOpmerking("Agressief rijgedrag", "");
         AttitudeOpmerking Inzet = new AttitudeOpmerking("Inzet", "");
         AttitudeOpmerking Verstrooid = new AttitudeOpmerking("Verstrooid", "");
         AttitudeOpmerking Eigenwijs = new AttitudeOpmerking("Eigenwijs", "");
         
         standaardOpmerkingenList.add(Zenuwachtig);
         standaardOpmerkingenList.add(Concentratie);
         standaardOpmerkingenList.add(Schrik);
         standaardOpmerkingenList.add(Asociaal);
         standaardOpmerkingenList.add(Verkeersgevaarlijk);
         standaardOpmerkingenList.add(AgressiefRijgedrag);
         standaardOpmerkingenList.add(Inzet);
         standaardOpmerkingenList.add(Verstrooid);
         standaardOpmerkingenList.add(Eigenwijs);
    }
    
}
