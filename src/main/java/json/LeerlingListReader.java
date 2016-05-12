package json;

import domein.AttitudeOpmerking;
import domein.ButtonTechniekDomein;
import domein.EvaluatieGrafiek;
import domein.Leerling;
import domein.Toestand;
import gui.ButtonTechniek;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class LeerlingListReader implements MessageBodyReader<List<Leerling>>{

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
       if (!List.class.isAssignableFrom(type)) {
           return false;
       }
       
       if(genericType instanceof ParameterizedType){
           Type[] arguments = ((ParameterizedType) genericType).getActualTypeArguments();
           return arguments.length == 1 || arguments[0].equals(Leerling.class);
       } else {
           return false;
       }
    }
    

    @Override
    public List<Leerling> readFrom(Class<List<Leerling>> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        try (JsonReader in = Json.createReader(entityStream)){
            JsonArray jsonLeerlingen = in.readArray();
            List<Leerling> leerlingen = new ArrayList<>();
            for (JsonObject jsonLeerling : jsonLeerlingen.getValuesAs(JsonObject.class)){
                    String inschrijvingsNr = jsonLeerling.getString("inschrijvingsnummer");
                    String familienaam = jsonLeerling.getString("familienaam", null);
                    String voornaam = jsonLeerling.getString("voornaam", null);
                    String email = jsonLeerling.getString("email", null);
                    Leerling leerling = new Leerling(inschrijvingsNr,familienaam, voornaam, email, null);
//                   
//                    Leerling leerling = new Leerling();
//                    leerling.setInschrijvingsNr(jsonLeerling.getString("inschrijvingsnummer"));
//                    leerling.setFamillieNaam(jsonLeerling.getString("familienaam"));
//                    leerling.setVoorNaam(jsonLeerling.getString("voornaam"));
//                    leerling.setEmail(jsonLeerling.getString("email"));
//
                    EvaluatieGrafiek evaluatieGrafiek = new EvaluatieGrafiek();
                    JsonObject jsonEvaGraf = jsonLeerling.getJsonObject("evaluatiegrafiek");
                    evaluatieGrafiek.setPositie(jsonEvaGraf.getInt("positie"));
                    evaluatieGrafiek.setVoortgang(jsonEvaGraf.getString("voortgang"));
                    leerling.setEvaGraf(evaluatieGrafiek);
                    
                    List<AttitudeOpmerking> attituden = new ArrayList<>();
                    JsonArray jsonAttituden = jsonLeerling.getJsonArray("attituden");
                    for(int i = 0; i < jsonAttituden.size(); i++){
                        JsonObject jsonAttitude = jsonAttituden.getJsonObject(i);
                        AttitudeOpmerking attitudeOpmerking = new AttitudeOpmerking();
                        attitudeOpmerking.setNaam(jsonAttitude.getString("naam"));
                        attitudeOpmerking.setOpmerking(jsonAttitude.getString("opmerking"));
                        attitudeOpmerking.setUitroeptekenActive(jsonAttitude.getBoolean("uitroeptekenActive"));
                        leerling.getStandaardOpmerkingenList().add(attitudeOpmerking);
                    }
                    
                    List<ButtonTechniekDomein> rijTechniekButtons = new ArrayList<>();
                    List<ButtonTechniekDomein> verkeersTechniekButtons = new ArrayList<>();
                    JsonArray jsonIconen = jsonLeerling.getJsonArray("iconen");
                    for(int i = 0; i < jsonIconen.size(); i++){
                        JsonObject jsonIcoon = jsonIconen.getJsonObject(i);
                        String naam = jsonIcoon.getString("naam");
                        ButtonTechniekDomein button = new ButtonTechniekDomein();
                        button.setHuidigeToestand(Toestand.valueOf(jsonIcoon.getString("toestand")));
                        if(jsonIcoon.getString("type").toLowerCase() == "rijtechniek"){
                            leerling.getButtonHolder().getRijTechniekButtons().add(button);
                        }
                        if(jsonIcoon.getString("type").toLowerCase() == "verkeerstechniek"){
                            leerling.getButtonHolder().getVerkeersTechniekButtons().add(button);
                        }
//                        if(naam == "koppeling"){
//                            leerling.getButtonHolder().setKoppeling(button);
//                        }
//                        if(naam == "stuur"){
//                            leerling.getButtonHolder().setStuur(button);
//                        }
//                        if(naam == "schakelen"){
//                            leerling.getButtonHolder().setSchakelen(button);
//                        }
//                        if(naam == "kijken"){
//                            leerling.getButtonHolder().setKijken(button);
//                        }
//                        if(naam == "parkeren"){
//                            leerling.getButtonHolder().setParkeren(button);
//                        }
//                        if(naam == "keren"){
//                            leerling.getButtonHolder().setKeren(button);
//                        }
//                        if(naam == "garage"){
//                            leerling.getButtonHolder().setGarage(button);
//                        }
//                        if(naam == "achteruit"){
//                            leerling.getButtonHolder().setAchteruit(button);
//                        }
//                        if(naam == "acht"){
//                            leerling.getButtonHolder().setAcht(button);
//                        }
//                        if(naam == "helling"){
//                            leerling.getButtonHolder().setHelling(button);
//                        }
//                        if(naam == "zithouding"){
//                            leerling.getButtonHolder().setZithouding(button);
//                        }
//                        if(naam == "remtechniek"){
//                            leerling.getButtonHolder().setRemtechniek(button);
//                        }
                        
                        
                        
                        
                        
                    }
                    
                    leerlingen.add(leerling);
            } 
            return leerlingen;
        }catch (JsonException | ClassCastException ex){
            return new ArrayList<>();
        }
    }
    
}
