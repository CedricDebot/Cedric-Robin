/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.ArrayList;
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
    private RijtechniekDom rijtechniekDom;
    private VerkeerstechniekDom verkeerstechniekDom;
    //Opmerkingen Atttiude
    private ArrayList<AttitudeOpmerking> standaardOpmerkingenList;
    //Grafiek
    private EvaluatieGrafiek evaGraf;

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
        maakOpmerkingSchermen();
        evaGraf = new EvaluatieGrafiek();

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

    public EvaluatieGrafiek getEvaGraf() {
        return evaGraf;
    }

    private void maakStandaardOpmerkingenList() {
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

    private void maakOpmerkingSchermen() {

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
        AttitudeOpmerking gebruik2 = new AttitudeOpmerking("Gebruik", "");
        schakelenOpmerking.add(bediening);
        schakelenOpmerking.add(gebruik2);

        //kijken
        kijkenOpmerkingen = new ArrayList<>();
        AttitudeOpmerking beterVergewissen = new AttitudeOpmerking("Beter vergewissen", "");
        AttitudeOpmerking spiegels = new AttitudeOpmerking("spiegels", "");
        AttitudeOpmerking dodeHoek = new AttitudeOpmerking("Dode hoek", "");
        AttitudeOpmerking verGenoeg = new AttitudeOpmerking("Ver genoeg", "");
        AttitudeOpmerking selecteren = new AttitudeOpmerking("selecteren", "");
        kijkenOpmerkingen.add(beterVergewissen);
        kijkenOpmerkingen.add(spiegels);
        kijkenOpmerkingen.add(dodeHoek);
        kijkenOpmerkingen.add(verGenoeg);
        kijkenOpmerkingen.add(selecteren);

        //Parkeren
        parkerenOpmerkingen = new ArrayList<>();
        AttitudeOpmerking tussenTweeVoertuigen = new AttitudeOpmerking("Tussen 2 voertuigen", "");
        AttitudeOpmerking AchterVoertuigen = new AttitudeOpmerking("Achter voertuigen", "");
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
        AttitudeOpmerking bediening3 = new AttitudeOpmerking("Bediening ", "");
        AttitudeOpmerking gebruik3 = new AttitudeOpmerking("Gebruik", "");
        remtechniekOpmerkingen.add(bediening3);
        remtechniekOpmerkingen.add(gebruik3);

        //embrayageO
        embrayageOpmerkingen = new ArrayList<>();
        AttitudeOpmerking bediening4 = new AttitudeOpmerking("Bediening", "");
        AttitudeOpmerking gebruik4 = new AttitudeOpmerking("Gebruik", "");
        embrayageOpmerkingen.add(bediening4);
        embrayageOpmerkingen.add(gebruik4);
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
