/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class Leerling {

    private String inschrijvingsNr;
    private String famillieNaam;
    private String voorNaam;
    private String email;
    //Implementatie foto via tablet?
    private Image foto;

    //Gegevens knoppen
    private DashboardDom dashboardDom;
    private ButtonHolder buttonHolder;
    //Opmerkingen Atttiude
    private ArrayList<AttitudeOpmerking> standaardOpmerkingenList;
    //Grafiek
    private EvaluatieGrafiek evaGraf;
    //Opmerkingen dashboard
    private ObservableList<AttitudeOpmerking> recenteOpmerkingen;

    //EvaluatieMomenten
    private boolean evaluatieMoment1 = true;
    private boolean evaluatieMoment2 = false;
    private boolean evaluatieMoment3 = false;

    public Leerling(String inschrijvingsNr, String famillieNaam, String voorNaam, String email, Image foto) {
        this.famillieNaam = famillieNaam;
        this.voorNaam = voorNaam;
        this.email = email;
        this.inschrijvingsNr = inschrijvingsNr;
        this.foto = foto;
        maakStandaardOpmerkingenList();
        maakOpmerkingSchermLists();
        evaGraf = new EvaluatieGrafiek();
        recenteOpmerkingen = FXCollections.observableArrayList();
        buttonHolder = new ButtonHolder();
        dashboardDom = new DashboardDom();
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

    public ButtonHolder getButtonHolder() {
        return buttonHolder;
    }

    public ArrayList<AttitudeOpmerking> getStandaardOpmerkingenList() {
        return standaardOpmerkingenList;
    }

    public EvaluatieGrafiek getEvaGraf() {
        return evaGraf;
    }

    public ObservableList<AttitudeOpmerking> getRecenteOpmerkingen() {
        return recenteOpmerkingen;
    }

    public ButtonTechniekDomein getButtonRijTechniek(int index) {
        return buttonHolder.getButtonRijTechniek(index);
    }

    public ButtonTechniekDomein getButtonVerkeersTechniek(int index) {
        return buttonHolder.getButtonVerkeersTechniek(index);
    }

    public boolean isEvaluatieMoment1() {
        return evaluatieMoment1;
    }

    public void setEvaluatieMoment1(boolean evaluatieMoment1) {
        this.evaluatieMoment1 = evaluatieMoment1;
    }

    public boolean isEvaluatieMoment2() {
        return evaluatieMoment2;
    }

    public void setEvaluatieMoment2(boolean evaluatieMoment2) {
        this.evaluatieMoment2 = evaluatieMoment2;
    }

    public boolean isEvaluatieMoment3() {
        return evaluatieMoment3;
    }

    public void setEvaluatieMoment3(boolean evaluatieMoment3) {
        this.evaluatieMoment3 = evaluatieMoment3;
    }

    private void maakStandaardOpmerkingenList() {
        standaardOpmerkingenList = new ArrayList<>();

        //standaardOpmerkingen
        AttitudeOpmerking DefensiefRijden1 = new AttitudeOpmerking("Defensief Rijden:   Gedrag t.o.v. anderen", "");
        AttitudeOpmerking DefensiefRijden2 = new AttitudeOpmerking("Defensief Rijden:   Risicoperceptie", "");
        AttitudeOpmerking DefensiefRijden3 = new AttitudeOpmerking("Defensief Rijden:   Beslissingen nemen", "");
        AttitudeOpmerking DefensiefRijden4 = new AttitudeOpmerking("Defensief Rijden:   Voorspelbaar rijgedrag", "");
        AttitudeOpmerking DefensiefRijden5 = new AttitudeOpmerking("Defensief Rijden:   Rijgedrag i.f.v. externe factoren", "");
        AttitudeOpmerking Eco = new AttitudeOpmerking("Ecologisch rijden", "");
        AttitudeOpmerking Zelfreflectie = new AttitudeOpmerking("Zelfreflectie", "");
        AttitudeOpmerking Ongeval = new AttitudeOpmerking("Gedrag bij ongeval", "");
        
        AttitudeOpmerking Zenuwachtig = new AttitudeOpmerking("Zenuwachtig", "");
        AttitudeOpmerking Concentratie = new AttitudeOpmerking("Concentratie", "");
        AttitudeOpmerking Schrik = new AttitudeOpmerking("Schrik", "");
        AttitudeOpmerking Asociaal = new AttitudeOpmerking("Asociaal", "");
        AttitudeOpmerking Verkeersgevaarlijk = new AttitudeOpmerking("Verkeersgevaarlijk", "");
        AttitudeOpmerking AgressiefRijgedrag = new AttitudeOpmerking("Agressief rijgedrag", "");
        AttitudeOpmerking Inzet = new AttitudeOpmerking("Inzet", "");
        AttitudeOpmerking Verstrooid = new AttitudeOpmerking("Verstrooid", "");
        AttitudeOpmerking Eigenwijs = new AttitudeOpmerking("Eigenwijs", "");

        
        
        standaardOpmerkingenList.add(DefensiefRijden1);
        standaardOpmerkingenList.add(DefensiefRijden2);
        standaardOpmerkingenList.add(DefensiefRijden3);
        standaardOpmerkingenList.add(DefensiefRijden4);
        standaardOpmerkingenList.add(DefensiefRijden5);
        standaardOpmerkingenList.add(Eco);
        standaardOpmerkingenList.add(Zelfreflectie);
        standaardOpmerkingenList.add(Ongeval);
        
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

    //VerkeersTechniek
    private ArrayList<AttitudeOpmerking> VoorrangOpmerkingen;
    private ArrayList<AttitudeOpmerking> OwOpmerkingen;
    private ArrayList<AttitudeOpmerking> PinkersOpmerkingen;
    private ArrayList<AttitudeOpmerking> orderOpmerkingen;
    private ArrayList<AttitudeOpmerking> snelheidOpmerkingen;
    private ArrayList<AttitudeOpmerking> afstandOpmerkingen;
    private ArrayList<AttitudeOpmerking> inhalenOpmerkingen;
    private ArrayList<AttitudeOpmerking> kruisenOpmerkingen;
    private ArrayList<AttitudeOpmerking> linksAfslaanOpmerkingen;
    private ArrayList<AttitudeOpmerking> rechtsAfslaanOpmerkingen;

    //Rijtechniek
    private ArrayList<AttitudeOpmerking> sturenOpmerkingen;
    private ArrayList<AttitudeOpmerking> schakelenOpmerking;
    private ArrayList<AttitudeOpmerking> kijkenOpmerkingen;
    private ArrayList<AttitudeOpmerking> parkerenOpmerkingen;
    private ArrayList<AttitudeOpmerking> kerenOpmerkingen;
    private ArrayList<AttitudeOpmerking> garageOpmerkingen;
    private ArrayList<AttitudeOpmerking> achteruitOpmerkingen;
    private ArrayList<AttitudeOpmerking> achtOpmerkingen;
    private ArrayList<AttitudeOpmerking> hellingOpmerkingen;
    private ArrayList<AttitudeOpmerking> zithoudingOpmerkingen;
    private ArrayList<AttitudeOpmerking> remtechniekOpmerkingen;
    private ArrayList<AttitudeOpmerking> embrayageOpmerkingen;

    private void maakOpmerkingSchermLists() {

        //Verkeerstechniek
        //Voorrang
        VoorrangOpmerkingen = new ArrayList<>();
        AttitudeOpmerking Voorrang = new AttitudeOpmerking("Voorrang", "");
        VoorrangOpmerkingen.add(Voorrang);

        //Openbare Weg
        OwOpmerkingen = new ArrayList<>();
        AttitudeOpmerking Openbaar = new AttitudeOpmerking("Openbare weg", "");
        AttitudeOpmerking voorsorteren = new AttitudeOpmerking("Voorsorteren", "");
        OwOpmerkingen.add(Openbaar);
        OwOpmerkingen.add(voorsorteren);

        //Pinkers
        PinkersOpmerkingen = new ArrayList<>();
        AttitudeOpmerking gebruik = new AttitudeOpmerking("Gebruik", "");
        AttitudeOpmerking tijdig = new AttitudeOpmerking("Tijdig aangeven", "");
        PinkersOpmerkingen.add(gebruik);
        PinkersOpmerkingen.add(tijdig);

        //OrdersVolgen
        orderOpmerkingen = new ArrayList<>();
        AttitudeOpmerking verkeerstekens = new AttitudeOpmerking("Verkeerstekens", "");
        AttitudeOpmerking bevelen = new AttitudeOpmerking("Bevelen", "");
        orderOpmerkingen.add(verkeerstekens);
        orderOpmerkingen.add(bevelen);

        //Snelheid
        snelheidOpmerkingen = new ArrayList<>();
        AttitudeOpmerking snelheid = new AttitudeOpmerking("Snelheid", "");
        snelheidOpmerkingen.add(snelheid);

        //Afstand
        afstandOpmerkingen = new ArrayList<>();
        AttitudeOpmerking volgAfstand = new AttitudeOpmerking("Volgafstand", "");
        AttitudeOpmerking zijdeAfstand = new AttitudeOpmerking("Zijdelingse afstand", "");
        afstandOpmerkingen.add(volgAfstand);
        afstandOpmerkingen.add(zijdeAfstand);

        //Inhalen
        inhalenOpmerkingen = new ArrayList<>();
        AttitudeOpmerking inhalen = new AttitudeOpmerking("Inhalen", "");
        AttitudeOpmerking voorbijrijden = new AttitudeOpmerking("Voorbijrijden", "");
        inhalenOpmerkingen.add(inhalen);
        inhalenOpmerkingen.add(voorbijrijden);

        //Kruisen
        kruisenOpmerkingen = new ArrayList<>();
        AttitudeOpmerking kruisen = new AttitudeOpmerking("Kruisen", "");
        kruisenOpmerkingen.add(kruisen);

        //LinksAf
        linksAfslaanOpmerkingen = new ArrayList<>();
        AttitudeOpmerking linksafslaan = new AttitudeOpmerking("Linksaf", "");
        AttitudeOpmerking opstelling = new AttitudeOpmerking("Opstelling", "");
        AttitudeOpmerking uitvoering = new AttitudeOpmerking("Uitvoering", "");
        linksAfslaanOpmerkingen.add(linksafslaan);
        linksAfslaanOpmerkingen.add(opstelling);
        linksAfslaanOpmerkingen.add(uitvoering);

        //RechtsAf
        rechtsAfslaanOpmerkingen = new ArrayList<>();
        AttitudeOpmerking rechtsaf = new AttitudeOpmerking("Rechtsaf", "");
        AttitudeOpmerking opstelling2 = new AttitudeOpmerking("Opstelling", "");
        AttitudeOpmerking uitvoering2 = new AttitudeOpmerking("Uitvoering", "");
        rechtsAfslaanOpmerkingen.add(rechtsaf);
        rechtsAfslaanOpmerkingen.add(opstelling2);
        rechtsAfslaanOpmerkingen.add(uitvoering2);

        //Rijtechniek
        //Sturen
        sturenOpmerkingen = new ArrayList<>();
        AttitudeOpmerking dosering = new AttitudeOpmerking("Dosering", "");
        AttitudeOpmerking houding = new AttitudeOpmerking("Houding", "");
        sturenOpmerkingen.add(dosering);
        sturenOpmerkingen.add(houding);

        //Schakelen
        schakelenOpmerking = new ArrayList<>();
        AttitudeOpmerking bediening = new AttitudeOpmerking("Bediening", "");
        AttitudeOpmerking gebruik2 = new AttitudeOpmerking("Aangepaste versnelling", "");
        schakelenOpmerking.add(bediening);
        schakelenOpmerking.add(gebruik2);

        //kijken
        kijkenOpmerkingen = new ArrayList<>();
        AttitudeOpmerking verGenoeg = new AttitudeOpmerking("Ver/Dichtbij", "");
        AttitudeOpmerking beterVergewissen = new AttitudeOpmerking("Meer vergewissen", "");
        AttitudeOpmerking spiegels = new AttitudeOpmerking("Spiegels", "");
        AttitudeOpmerking dodeHoek = new AttitudeOpmerking("Dode hoeken", "");
        AttitudeOpmerking selecteren = new AttitudeOpmerking("Scannen/Selecteren", "");
        kijkenOpmerkingen.add(beterVergewissen);
        kijkenOpmerkingen.add(spiegels);
        kijkenOpmerkingen.add(dodeHoek);
        kijkenOpmerkingen.add(verGenoeg);
        kijkenOpmerkingen.add(selecteren);

        //Parkeren
        parkerenOpmerkingen = new ArrayList<>();
        AttitudeOpmerking tussenTweeVoertuigen = new AttitudeOpmerking("Tussen twee voertuigen", "");
        AttitudeOpmerking AchterVoertuigen = new AttitudeOpmerking("Achter een voertuig", "");
        AttitudeOpmerking links = new AttitudeOpmerking("Links", "");
        parkerenOpmerkingen.add(tussenTweeVoertuigen);
        parkerenOpmerkingen.add(AchterVoertuigen);
        parkerenOpmerkingen.add(links);

        //Keren
        kerenOpmerkingen = new ArrayList<>();

        //Garage
        garageOpmerkingen = new ArrayList<>();
        AttitudeOpmerking in1Beweging = new AttitudeOpmerking("In 1 beweging", "");
        AttitudeOpmerking in3Bewegingen = new AttitudeOpmerking("In 3 beweging", "");
        AttitudeOpmerking achterwaarts = new AttitudeOpmerking("Achterwaarts", "");
        garageOpmerkingen.add(in1Beweging);
        garageOpmerkingen.add(in3Bewegingen);
        garageOpmerkingen.add(achterwaarts);

        //Achteruit
        achteruitOpmerkingen = new ArrayList<>();

        //Acht
        achtOpmerkingen = new ArrayList<>();

        //Helling
        hellingOpmerkingen = new ArrayList<>();
        AttitudeOpmerking balanceren = new AttitudeOpmerking("Balanceren", "");
        AttitudeOpmerking voetrem = new AttitudeOpmerking("Voetrem", "");
        AttitudeOpmerking handrem = new AttitudeOpmerking("Handrem", "");
        hellingOpmerkingen.add(balanceren);
        hellingOpmerkingen.add(voetrem);
        hellingOpmerkingen.add(handrem);

        //Zithouding
        zithoudingOpmerkingen = new ArrayList<>();
        AttitudeOpmerking zithouding = new AttitudeOpmerking("Zithouding", "");
        AttitudeOpmerking gordel = new AttitudeOpmerking("Gordel", "");
        AttitudeOpmerking spiegels2 = new AttitudeOpmerking("Spiegels", "");
        AttitudeOpmerking handrem2 = new AttitudeOpmerking("Handrem", "");
        AttitudeOpmerking stuurslot = new AttitudeOpmerking("Stuurslot", "");
        zithoudingOpmerkingen.add(zithouding);
        zithoudingOpmerkingen.add(gordel);
        zithoudingOpmerkingen.add(spiegels2);
        zithoudingOpmerkingen.add(handrem2);
        zithoudingOpmerkingen.add(stuurslot);

        //RemTechniek
        remtechniekOpmerkingen = new ArrayList<>();
        AttitudeOpmerking bedieningRem1 = new AttitudeOpmerking("Bediening:     Dosering ", "");
        AttitudeOpmerking bedieningRem2 = new AttitudeOpmerking("Bediening:     Volgorde ", "");
        AttitudeOpmerking gebruikRem1 = new AttitudeOpmerking("Gebruik:     Te laat", "");
        AttitudeOpmerking gebruikRem2 = new AttitudeOpmerking("Gebruik:     Afremmen op de motor", "");
        remtechniekOpmerkingen.add(bedieningRem1);
        remtechniekOpmerkingen.add(bedieningRem2);
        remtechniekOpmerkingen.add(gebruikRem1);
        remtechniekOpmerkingen.add(gebruikRem2);

        //embrayageO / koppeling
        embrayageOpmerkingen = new ArrayList<>();
        AttitudeOpmerking bedieningKop1 = new AttitudeOpmerking("Bediening:     Dosering ", "");
        AttitudeOpmerking bedieningKop2 = new AttitudeOpmerking("Bediening:     Volledig ", "");
        AttitudeOpmerking bedieningKop3 = new AttitudeOpmerking("Bediening:     Plaatsing voet ", "");
        AttitudeOpmerking gebruikKop1 = new AttitudeOpmerking("Gebruik:     Onnodig", "");
        AttitudeOpmerking gebruikKop2 = new AttitudeOpmerking("Gebruik:     Bocht", "");
        embrayageOpmerkingen.add(bedieningKop1);
        embrayageOpmerkingen.add(bedieningKop2);
        embrayageOpmerkingen.add(bedieningKop3);
        embrayageOpmerkingen.add(gebruikKop1);
        embrayageOpmerkingen.add(gebruikKop2);
    }

    //VerkeersTechniek
    public ArrayList<AttitudeOpmerking> getVoorrangOpmerkingen() {
        return VoorrangOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getOwOpmerkingen() {
        return OwOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getPinkersOpmerkingen() {
        return PinkersOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getOrderOpmerkingen() {
        return orderOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getSnelheidOpmerkingen() {
        return snelheidOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getAfstandOpmerkingen() {
        return afstandOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getInhalenOpmerkingen() {
        return inhalenOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getKruisenOpmerkingen() {
        return kruisenOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getLinksAfslaanOpmerkingen() {
        return linksAfslaanOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getRechtsAfslaanOpmerkingen() {
        return rechtsAfslaanOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getSturenOpmerkingen() {
        return sturenOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getSchakelenOpmerking() {
        return schakelenOpmerking;
    }

    public ArrayList<AttitudeOpmerking> getKijkenOpmerkingen() {
        return kijkenOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getParkerenOpmerkingen() {
        return parkerenOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getKerenOpmerkingen() {
        return kerenOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getGarageOpmerkingen() {
        return garageOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getAchteruitOpmerkingen() {
        return achteruitOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getAchtOpmerkingen() {
        return achtOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getHellingOpmerkingen() {
        return hellingOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getZithoudingOpmerkingen() {
        return zithoudingOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getRemtechniekOpmerkingen() {
        return remtechniekOpmerkingen;
    }

    public ArrayList<AttitudeOpmerking> getEmbrayageOpmerkingen() {
        return embrayageOpmerkingen;
    }

}
