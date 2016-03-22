package gui;

import domein.Leerling;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public class Beginscherm extends HBox
{

    private ObservableList<String> names = FXCollections.observableArrayList("Cédric", "Robin", "Dries", "Milton");
    private ListView lijstLeerlingen = new ListView();
    
    private Scene scene;

    public Beginscherm()
    {
        //Labels
        VBox labels = new VBox();
        labels.setId("labels");
        HBox naamLeerling = new HBox();
        naamLeerling.setId("naamLeerling");
        Label naam = new Label("Naam: ");
        TextField naamTF = new TextField();
        naamTF.setId("textField");
        naamLeerling.getChildren().addAll(naam, naamTF);
        HBox inschrijvingLeerling = new HBox();
        inschrijvingLeerling.setId("inschrijvingLeerling");
        Label inschrijvingsnummer = new Label("Inschrijvingsnummer:");
        TextField inschrijvingsnummerTF = new TextField();
        inschrijvingsnummerTF.setId("textField");
        inschrijvingLeerling.getChildren().addAll(inschrijvingsnummer, inschrijvingsnummerTF);
        labels.getChildren().addAll(naamLeerling, inschrijvingLeerling);

        //ButtonLeft
        HBox buttons = new HBox();
        buttons.setId("buttons");
        Button nieuw = new Button("Nieuw");
        Button start = new Button("Start");

        buttons.getChildren().addAll(nieuw, start);

        //ZoekScherm
        VBox zoekscherm = new VBox();
        zoekscherm.setId("zoekscherm");
        zoekscherm.getChildren().addAll(labels, buttons);

        //LijstLeerlingen
//        ObservableList<String> names = FXCollections.observableArrayList("Cédric", "Robin", "Dries", "Milton");
//        ListView lijstLeerlingen = new ListView();
        lijstLeerlingen.setId("lijstLeerlingen");
        lijstLeerlingen.setItems(names);
        lijstLeerlingen.setCellFactory(CheckBoxListCell.forListView(new Callback<String, ObservableValue<Boolean>>()
        {

            @Override
            public ObservableValue<Boolean> call(String item)
            {
                return null;
            }
        }));

        //ButtonsRight
        HBox buttonsRight = new HBox();
        buttonsRight.setId("buttonsRight");
        Button verwijder = new Button("Verwijder");
        verwijder.setId("btnVerwijder");
        Button sync = new Button("Synchroniseer");
        sync.setId("btnSync");
        buttonsRight.getChildren().addAll(verwijder, sync);

        //ButtonsAllesVerwijderen
        Button allesVerwijderen = new Button("Alles verwijderen");
        allesVerwijderen.setId("btnAllesVerwijderen");

        //NieuweLeerling
        VBox nieuweLeerling = new VBox();

        nieuweLeerling.setId("schermNieuweLeerling");

        Label titel = new Label("Nieuwe Leerling");
        titel.setId("listViewTitle");
        Label nr = new Label("InschrijvingsNr:");
        TextField inputNr = new TextField();
        inputNr.setId("textField");
        Label famNaam = new Label("Famillienaam:");
        TextField inputFamillienaam = new TextField();
        inputFamillienaam.setId("textField");
        Label Voornaam = new Label("Voornaam:");
        TextField inputVoornaam = new TextField();
        inputVoornaam.setId("textField");
        Label Email = new Label("Email:");
        TextField inputEmail = new TextField();
        inputEmail.setId("textField");
        Button foto = new Button("Foto");

        nieuweLeerling.getChildren().addAll(titel, nr, inputNr, famNaam,
                inputFamillienaam, Voornaam, inputVoornaam, Email, inputEmail, foto);

        //buttonsNieuweLeerling
        Button ok = new Button("Ok");
        ok.setId("btnVerwijder");
        Button annuleer = new Button("Annuleer");
        annuleer.setId("btnSync");
        HBox knoppenNieuw = new HBox();
        knoppenNieuw.setId("buttonsRight");

        knoppenNieuw.getChildren().addAll(ok, annuleer);

        //schermNieuwLeerling
        VBox rightNieuw = new VBox();
        rightNieuw.setId("right");
        rightNieuw.getChildren().addAll(titel, nieuweLeerling, knoppenNieuw);

        //LinkerScherm
        VBox left = new VBox();
        left.setId("left");

        Image auto = new Image("images/driving_school.png");
        ImageView autoImg = new ImageView();
        autoImg.setImage(auto);
        autoImg.setId("autoImg");

//        //lay-out (nog proberen in css te zetten)
        autoImg.setFitWidth(200);
        autoImg.setFitHeight(225);

        left.getChildren().addAll(zoekscherm, autoImg);

        //RechterScherm
        VBox right = new VBox();
        right.setId("right");

        Label listViewTitle = new Label("Leerlingen");
        listViewTitle.setId("listViewTitle");

        right.getChildren().addAll(listViewTitle, lijstLeerlingen, buttonsRight, allesVerwijderen);

        getChildren().addAll(left, right);

        nieuw.setOnAction(e -> {
            if (getChildren().contains(right)) {
                getChildren().remove(right);
                getChildren().add(rightNieuw);
            }
        });
        
        naamTF.textProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                ZoekFunctie((String) oldValue, (String) newValue); 
            }
        });

        ok.setOnAction(e -> {
            Leerling leerling = new Leerling(inputNr.getText(), inputFamillienaam.getText(), inputVoornaam.getText(), inputEmail.getText());
            names.add(leerling.getVoorNaam());

            if (getChildren().contains(rightNieuw)) {
                getChildren().remove(rightNieuw);
                getChildren().add(right);
            }
        });
        
        start.setOnAction(e ->{
            Dashboard dashboard = new Dashboard();
            dashboard.setScene(scene);
            scene.setRoot(dashboard);
        });

        //textfields nog leeg maken 
        annuleer.setOnAction(e -> {
            getChildren().remove(rightNieuw);
            getChildren().add(right);
        });
    }
    
    public void ZoekFunctie(String oldVal, String newVal)
    {
        if (oldVal != null && (newVal.length() < oldVal.length())) {
            lijstLeerlingen.setItems(names);
        }
        
        newVal = newVal.toLowerCase();
        
        ObservableList<String> searchNames = FXCollections.observableArrayList();
        for (Object entry : lijstLeerlingen.getItems()) {
            String entryText = (String) entry;
            if (entryText.toLowerCase().contains(newVal)) {
                searchNames.add(entryText);
            }
        }
        lijstLeerlingen.setItems(searchNames);
    }
    
    public void setScene(Scene scene){
        this.scene = scene;
    }
}
