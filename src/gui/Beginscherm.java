package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Beginscherm extends HBox
{

    public Beginscherm()
    {
        getChildren().addAll(left(), right());
    }

    public VBox left()
    {
        VBox left = new VBox();
        left.setId("left");

        left.getChildren().addAll(zoekscherm()); //+image

        return left;
    }

    public VBox zoekscherm()
    {
        VBox zoekscherm = new VBox();
        zoekscherm.setId("zoekscherm");

        zoekscherm.getChildren().addAll(labels(), buttonsLeft());

        return zoekscherm;
    }

    public VBox labels()
    {
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

        return labels;
    }

    public HBox buttonsLeft()
    {
        HBox buttons = new HBox();
        buttons.setId("buttons");
        Button zoek = new Button("Zoek");
        zoek.setId("btnZoek");
        Button nieuw = new Button("Nieuw");
        nieuw.setId("btnNieuw");
        buttons.getChildren().addAll(zoek, nieuw);

        return buttons;
    }

    public VBox right()
    {
        VBox right = new VBox();
        right.setId("right");

        right.getChildren().addAll(lijstLeerlingen(), buttonsRight(), btnAllesVerwijderen());

        return right;
    }

    public ListView lijstLeerlingen()
    {
        ObservableList<String> names = FXCollections.observableArrayList(
                "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
        ListView lijstLeerlingen = new ListView();
        lijstLeerlingen.setId("lijstLeerlingen");
        lijstLeerlingen.setItems(names);

        return lijstLeerlingen;
    }

    public HBox buttonsRight()
    {
        HBox buttonsRight = new HBox();
        buttonsRight.setId("buttonsRight");
        Button verwijder = new Button("Verwijder");
        verwijder.setId("btnVerwijder");
        Button sync = new Button("Synchroniseer");
        sync.setId("btnSync");
        buttonsRight.getChildren().addAll(verwijder, sync);


        return buttonsRight;
    }

    public Button btnAllesVerwijderen()
    {
        Button allesVerwijderen = new Button("Alles verwijderen");
        allesVerwijderen.setId("btnAllesVerwijderen");
        
        return allesVerwijderen;
    }
}
