package gui;

import domein.DomeinController;
import domein.Leerling;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class Beginscherm extends HBox {

//    private ObservableList<String> names = FXCollections.observableArrayList("Cédric", "Robin", "Dries", "Milton");
    private ObservableList<Leerling> leerlingen = FXCollections.observableArrayList();
    private ListView lijstLeerlingen = new ListView();

    private Scene scene;
    private DomeinController controller;
    private VBox nieuweLeerling;

    public Beginscherm() {
        //Labels
        VBox labels = new VBox();
        labels.setId("labels");
        HBox naamLeerling = new HBox();
        naamLeerling.setId("naamLeerling");
        
        Label naam = new Label("Naam: ");
        naam.setMaxWidth(Double.MAX_VALUE);
        naamLeerling.setHgrow(naam, Priority.ALWAYS);
        TextField naamTF = new TextField();
        naamTF.setId("textField");
        naamLeerling.getChildren().addAll(naam, naamTF);
        
        HBox inschrijvingLeerling = new HBox();
        inschrijvingLeerling.setId("inschrijvingLeerling");
        
        Label inschrijvingsnummer = new Label("Inschrijvingsnummer:");
        inschrijvingsnummer.setMaxWidth(Double.MAX_VALUE);
        inschrijvingLeerling.setHgrow(inschrijvingsnummer, Priority.ALWAYS);
        TextField inschrijvingsnummerTF = new TextField();
        inschrijvingsnummerTF.setId("textField");
        inschrijvingLeerling.getChildren().addAll(inschrijvingsnummer, inschrijvingsnummerTF);
        labels.getChildren().addAll(naamLeerling, inschrijvingLeerling);

        
        naamTF.setFocusTraversable(false);
        inschrijvingsnummerTF.setFocusTraversable(false);
        //ButtonLeft
        HBox buttons = new HBox();
        buttons.setId("buttons");
        Button nieuw = new Button("Nieuw");
        Button start = new Button("Start");

        buttons.getChildren().addAll(nieuw, start);

        DropShadow shadow = new DropShadow();
        nieuw.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            nieuw.setEffect(shadow);
        });
        nieuw.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            nieuw.setEffect(null);
        });

        start.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            start.setEffect(shadow);
        });
        start.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            start.setEffect(null);
        });

        //Feedback
        Label feedbackInlog = new Label("");
        feedbackInlog.setId("feedbackLogin");
        //ZoekScherm
        VBox zoekscherm = new VBox();
        zoekscherm.setId("zoekscherm");
        zoekscherm.getChildren().addAll(labels, buttons, feedbackInlog);

        //ListViewLln
        VulLeerlingen();

        lijstLeerlingen.setId("lijstLeerlingen");
        lijstLeerlingen.setItems(leerlingen);

        lijstLeerlingen.setCellFactory(new Callback<ListView<Leerling>, ListCell<Leerling>>() {

            @Override
            public ListCell<Leerling> call(ListView<Leerling> p) {

                ListCell<Leerling> cell = new ListCell<Leerling>() {

                    @Override
                    protected void updateItem(Leerling l, boolean bln) {
                        super.updateItem(l, bln);
                        if (l != null) {
                            setText(l.getVoorNaam() + " " + l.getFamillieNaam());
                        }
                    }
                };
                return cell;
            }
        });
        
        lijstLeerlingen.setOnMouseClicked(e->{
            try{
                Leerling leerlingSelected = (Leerling) lijstLeerlingen.getSelectionModel().getSelectedItem();
                naamTF.setText(leerlingSelected.getVoorNaam() + " " + leerlingSelected.getFamillieNaam());
                inschrijvingsnummerTF.setText(leerlingSelected.getInschrijvingsNr());
                
            }catch(NullPointerException npe){
                
            }
        });

        //ButtonsRight
        HBox buttonsRight = new HBox();
        buttonsRight.setId("buttonsRight");
        Button verwijder = new Button("Verwijder");
        verwijder.setId("btnVerwijder");
        Button sync = new Button("Synchroniseer");
        sync.setId("btnSync");
        buttonsRight.getChildren().addAll(verwijder, sync);

        verwijder.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            verwijder.setEffect(shadow);
        });
        verwijder.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            verwijder.setEffect(null);
        });

        sync.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            sync.setEffect(shadow);
        });
        sync.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            sync.setEffect(null);
        });

        sync.setOnAction(e -> {
            Synchroniseer synchroniseer = new Synchroniseer();
            synchroniseer.setScene(scene);
            scene.setRoot(synchroniseer);
        });

        //ButtonsAllesVerwijderen
        Button allesVerwijderen = new Button("Alles verwijderen");
        allesVerwijderen.setId("btnAllesVerwijderen");

        allesVerwijderen.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            allesVerwijderen.setEffect(shadow);
        });
        allesVerwijderen.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            allesVerwijderen.setEffect(null);
        });

        //NieuweLeerling
        nieuweLeerling = new VBox();

        nieuweLeerling.setId("schermNieuweLeerling");

        Label titel = new Label("Nieuwe Leerling");
        titel.setId("listViewTitle");
        Label nr = new Label("InschrijvingsNr:");
        TextField inputNr = new TextField();
        inputNr.setId("textField");

        VBox fnaam = new VBox();
        Label famNaam = new Label("Famillienaam:");
        TextField inputFamillienaam = new TextField();
        inputFamillienaam.setId("textField");
        Label famillienaamFout = new Label();
        famillienaamFout.setId("foutboodschap");
        fnaam.getChildren().addAll(famNaam, inputFamillienaam);

        VBox vnaam = new VBox();
        Label Voornaam = new Label("Voornaam:");
        TextField inputVoornaam = new TextField();
        inputVoornaam.setId("textField");
        Label voornaamFout = new Label();
        voornaamFout.setId("foutboodschap");
        vnaam.getChildren().addAll(Voornaam, inputVoornaam);

        VBox mail = new VBox();
        Label Email = new Label("Email:");
        TextField inputEmail = new TextField();
        inputEmail.setId("textField");
        Label emailFout = new Label();
        emailFout.setId("foutboodschap");
        mail.getChildren().addAll(Email, inputEmail);

//        Button foto = new Button("Foto");
        Label feedback = new Label("");

        HBox fotoEnLabel = new HBox();
        fotoEnLabel.setId("fotoEnLabel");
        fotoEnLabel.getChildren().addAll(feedback);

        nieuweLeerling.getChildren().addAll(titel, nr, inputNr, fnaam, vnaam, mail, fotoEnLabel);

        //buttonsNieuweLeerling
        Button ok = new Button("Ok");
        ok.setId("btnVerwijder");
        Button annuleer = new Button("Annuleer");
        annuleer.setId("btnSync");
        HBox knoppenNieuw = new HBox();
        knoppenNieuw.setId("buttonsRight");

        knoppenNieuw.getChildren().addAll(ok, annuleer);

        ok.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            ok.setEffect(shadow);
        });
        ok.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            ok.setEffect(null);
        });

        annuleer.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            annuleer.setEffect(shadow);
        });
        annuleer.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            annuleer.setEffect(null);
        });

        //schermNieuwLeerling
        VBox rightNieuw = new VBox();
        rightNieuw.setId("right");

        VBox nieuweLeerlingWithLabel = new VBox();
        nieuweLeerlingWithLabel.setId("listViewWithLabel");

        nieuweLeerlingWithLabel.getChildren().addAll(titel, nieuweLeerling);

        rightNieuw.getChildren().addAll(nieuweLeerlingWithLabel, knoppenNieuw);

        //LinkerScherm
        VBox left = new VBox();
        left.setId("left");

        Image auto = new Image("images/logo_mobix_app.png");
        ImageView autoImg = new ImageView();
        autoImg.setImage(auto);
        autoImg.setId("autoImg");

//        //lay-out (nog proberen in css te zetten)
        autoImg.setFitWidth(230);
        autoImg.setFitHeight(230);

        left.getChildren().addAll(zoekscherm, autoImg);

        //RechterScherm
        VBox right = new VBox();
        right.setId("right");

        VBox listViewWithLabel = new VBox();
        listViewWithLabel.setId("listViewWithLabel");
        Label listViewTitle = new Label("Leerlingen");
        listViewTitle.setId("listViewTitle");

        listViewWithLabel.getChildren().addAll(listViewTitle, lijstLeerlingen);
        right.getChildren().addAll(listViewWithLabel, buttonsRight, allesVerwijderen);

        getChildren().addAll(left, right);

        nieuw.setOnAction(e -> {
            if (getChildren().contains(right)) {
                getChildren().remove(right);
                getChildren().add(rightNieuw);
            }
        });

//        naamTF.textProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                ZoekFunctie((String) oldValue, (String) newValue);
//            }
//        });

        ok.setOnAction(e -> {
            boolean geldig = true;
            if (inputFamillienaam.getText().equals("")) {
                if (!fnaam.getChildren().contains(famillienaamFout)) {
                    fnaam.getChildren().add(famillienaamFout);
                }
                famillienaamFout.setText("Gelieve een familienaam in te vullen");
                geldig = false;
            } else if (fnaam.getChildren().contains(famillienaamFout)) {
                fnaam.getChildren().remove(famillienaamFout);
            }

            if (inputVoornaam.getText().equals("")) {
                if (!vnaam.getChildren().contains(voornaamFout)) {
                    vnaam.getChildren().add(voornaamFout);
                }

                voornaamFout.setText("Gelieve een voornaam in te vullen");
                geldig = false;
            } else if (vnaam.getChildren().contains(voornaamFout)) {
                vnaam.getChildren().remove(voornaamFout);
            }

            if (inputEmail.getText().equals("")) {
                if (!mail.getChildren().contains(emailFout)) {
                    mail.getChildren().add(emailFout);
                }
                emailFout.setText("Gelieve een geldig e-mailadres in te vullen");
                geldig = false;
            } else if (mail.getChildren().contains(emailFout)) {
                mail.getChildren().remove(emailFout);
            }

            if (validateEmail(inputEmail.getText()) == false) {
                if (!mail.getChildren().contains(emailFout)) {
                    mail.getChildren().add(emailFout);
                }

                emailFout.setText("Gelieve een geldig e-mailadres in te vullen");
                geldig = false;
            } else if (mail.getChildren().contains(emailFout)) {
                mail.getChildren().remove(emailFout);
            }

            if (geldig) {
                Leerling leerling = new Leerling(inputNr.getText(), inputFamillienaam.getText(), inputVoornaam.getText(), inputEmail.getText(), null);
                leerlingen.add(leerling);

                if (getChildren().contains(rightNieuw)) {
                    getChildren().remove(rightNieuw);
                    getChildren().add(right);
                }
            }

        });

        start.setOnAction(e
                -> {
            if (lijstLeerlingen.getSelectionModel().getSelectedItem() == null) {
                feedbackInlog.setText("Gelieve een leerling te selecteren");
            } else {
                Leerling leerling = (Leerling) lijstLeerlingen.getSelectionModel().getSelectedItem();
                //haal leerling op uit db/backend

                controller = new DomeinController(this, leerling);
                IcoonToestanden icoon = new IcoonToestanden(controller);
                controller.setToestanden(icoon);
                Dashboard dashboard = new Dashboard(controller);
                controller.setDashboard(dashboard);
                dashboard.setScene(scene);
                scene.setRoot(dashboard);
            }
        }
        );

        //textfields nog leeg maken 
        annuleer.setOnAction(e
                -> {
            getChildren().remove(rightNieuw);
            getChildren().add(right);
        }
        );
    }

//    public void ZoekFunctie(String oldVal, String newVal) {
//        //if (oldVal != null && (newVal.length() <= oldVal.length())) {
////        lijstLeerlingen.setItems(leerlingen);
//        //}
//        newVal = newVal.toLowerCase();
//
//        ObservableList<Leerling> searchNames = FXCollections.observableArrayList();
//        for (Leerling leerling : leerlingen) {
//            String entryText = (String) leerling.getVoorNaam();
//            if (entryText.toLowerCase().contains(newVal)) {
//                searchNames.add(leerling);
//            }
//        }
//        lijstLeerlingen.setItems(searchNames);
//    }

    public boolean validateEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    private void VulLeerlingen() {
        Image CedricFoto = new Image("images/testLeerlingen/1.png");
        Leerling Cedric = new Leerling("100401", "Debot", "Cédric", null, CedricFoto);
        leerlingen.add(Cedric);

        Image RobinFoto = new Image("images/testLeerlingen/4.png");
        Leerling Robin = new Leerling("104050", "Lanneer", "Robin", null, RobinFoto);
        leerlingen.add(Robin);

        Image DriesFoto = new Image("images/testLeerlingen/2.png");
        Leerling Dries = new Leerling("054501", "Meert", "Dries", null, DriesFoto);
        leerlingen.add(Dries);

        Image MiltonFoto = new Image("images/testLeerlingen/3.png");
        Leerling Milton = new Leerling("254241", "Hooft", "Milton", null, MiltonFoto);
        leerlingen.add(Milton);
    }

    public ObservableList<Leerling> getLeerlingen() {
        return leerlingen;
    }

}
