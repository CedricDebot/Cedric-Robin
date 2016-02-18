package gui;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public class Beginscherm extends HBox
{

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
        Button zoek = new Button("Zoek");
        zoek.setId("btnZoek");
        Button nieuw = new Button("Nieuw");
        nieuw.setId("btnNieuw");
        buttons.getChildren().addAll(zoek, nieuw);

        //ZoekScherm
        VBox zoekscherm = new VBox();
        zoekscherm.setId("zoekscherm");
        zoekscherm.getChildren().addAll(labels, buttons);

        //LijstLeerlingen
        ObservableList<String> names = FXCollections.observableArrayList(
              "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan");
        ListView lijstLeerlingen = new ListView();
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
        nieuweLeerling.setId("right");

        Label titel = new Label("Nieuwe Leerling");
        titel.setId("titelNieuw");
        Label nr = new Label("InschrijvingsNr:");
        TextField inputNr = new TextField();
        Label famNaam = new Label("Famillienaam:");
        TextField inputFamillienaam = new TextField();
        Label Voornaam = new Label("Voornaam:");
        TextField inputVoornaam = new TextField();
        Label Email = new Label("Email:");
        TextField inputEmail = new TextField();
        Button foto = new Button("Foto");

        nieuweLeerling.getChildren().addAll(titel, nr, inputNr, famNaam,
                inputFamillienaam, Voornaam, inputVoornaam, Email, inputEmail, foto);

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
            getChildren().remove(right);
            getChildren().add(nieuweLeerling);
        });
        zoek.setOnAction(e -> {
            getChildren().remove(nieuweLeerling);
            getChildren().add(right);
        });
    }
}
