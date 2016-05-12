package json;

import domein.AttitudeOpmerking;
import domein.ButtonHolder;
import domein.ButtonTechniekDomein;
import domein.Leerling;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class LeerlingWriter implements MessageBodyWriter<Leerling> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Leerling.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(Leerling t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(Leerling leerling, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        try (JsonWriter out = Json.createWriter(entityStream)) {
            JsonObjectBuilder jsonLeerling = Json.createObjectBuilder();
            jsonLeerling.add("inschrijvingsnummer", leerling.getInschrijvingsNr());
            jsonLeerling.add("familienaam", leerling.getFamillieNaam());
            jsonLeerling.add("voornaam", leerling.getVoorNaam());
            jsonLeerling.add("email", leerling.getEmail());
            jsonLeerling.add("wachtwoord", "666");

            JsonObjectBuilder jsonEvaGraf = Json.createObjectBuilder();
            jsonEvaGraf.add("positie", leerling.getEvaGraf().getPositie());
            jsonEvaGraf.add("voortgang", leerling.getEvaGraf().getVoortgang());
            jsonLeerling.add("evaluatiegrafiek", jsonEvaGraf);

            JsonArrayBuilder jsonAttituden = Json.createArrayBuilder();
            for (AttitudeOpmerking attitudeOpmerking : leerling.getStandaardOpmerkingenList()) {
                JsonObjectBuilder jsonAttitude = Json.createObjectBuilder();
                jsonAttitude.add("naam", attitudeOpmerking.getNaam());
                jsonAttitude.add("opmerking", attitudeOpmerking.getOpmerking());
                jsonAttitude.add("uitroeptekenActive", attitudeOpmerking.isUitroeptekenActive());

                jsonAttituden.add(jsonAttitude);
            }
            jsonLeerling.add("attituden", jsonAttituden);

//            JsonArrayBuilder jsonEvaluatiemomenten = Json.createArrayBuilder();
//            for (ButtonTechniekDomein evamoment : leerling.getButtonHolder().getRijTechniekButtons()) {
//                
//            }
            
            JsonArrayBuilder jsonIconen = Json.createArrayBuilder();
            for (ButtonTechniekDomein icoon : leerling.getButtonHolder().getRijTechniekButtons()) {
                JsonObjectBuilder jsonIcoon = Json.createObjectBuilder();
                if (leerling.getButtonHolder().getRijTechniekButtons().indexOf(icoon) == 0) {
                    jsonIcoon.add("naam", "koppeling");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "rijtechniek");
                }
                if(leerling.getButtonHolder().getRijTechniekButtons().indexOf(icoon) == 1){
                    jsonIcoon.add("naam", "stuur");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "rijtechniek");
                }
                if(leerling.getButtonHolder().getRijTechniekButtons().indexOf(icoon) == 2){
                jsonIcoon.add("naam", "schakelen");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "rijtechniek");}
                if(leerling.getButtonHolder().getRijTechniekButtons().indexOf(icoon) == 3){
                jsonIcoon.add("naam", "kijken");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "rijtechniek");}
                if(leerling.getButtonHolder().getRijTechniekButtons().indexOf(icoon) == 4){
                jsonIcoon.add("naam", "parkeren");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "rijtechniek");}
                if(leerling.getButtonHolder().getRijTechniekButtons().indexOf(icoon) == 5){
                jsonIcoon.add("naam", "keren");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "rijtechniek");}
                if(leerling.getButtonHolder().getRijTechniekButtons().indexOf(icoon) == 6){
                jsonIcoon.add("naam", "garage");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "rijtechniek");}
                if(leerling.getButtonHolder().getRijTechniekButtons().indexOf(icoon) == 7){
                jsonIcoon.add("naam", "achteruit");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "rijtechniek");}
                if(leerling.getButtonHolder().getRijTechniekButtons().indexOf(icoon) == 8){
                jsonIcoon.add("naam", "acht");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "rijtechniek");}
                if(leerling.getButtonHolder().getRijTechniekButtons().indexOf(icoon) == 9){
                jsonIcoon.add("naam", "helling");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "rijtechniek");}
                if(leerling.getButtonHolder().getRijTechniekButtons().indexOf(icoon) == 10){
                jsonIcoon.add("naam", "zithouding");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "rijtechniek");}
                if(leerling.getButtonHolder().getRijTechniekButtons().indexOf(icoon) == 11){
                    jsonIcoon.add("naam", "remtechniek");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "rijtechniek");}
            
                jsonIconen.add(jsonIcoon);
            }
            for (ButtonTechniekDomein icoon : leerling.getButtonHolder().getVerkeersTechniekButtons()) {
                JsonObjectBuilder jsonIcoon = Json.createObjectBuilder();
                if(leerling.getButtonHolder().getVerkeersTechniekButtons().indexOf(icoon) == 0) {
                    jsonIcoon.add("naam", "voorrang");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "verkeerstechniek");
                }
                if(leerling.getButtonHolder().getVerkeersTechniekButtons().indexOf(icoon) == 1) {
                    jsonIcoon.add("naam", "orderOpvolgen");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "verkeerstechniek");
                }
                if(leerling.getButtonHolder().getVerkeersTechniekButtons().indexOf(icoon) == 2) {
                    jsonIcoon.add("naam", "snelheid");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "verkeerstechniek");
                }
                if(leerling.getButtonHolder().getVerkeersTechniekButtons().indexOf(icoon) == 3) {
                    jsonIcoon.add("naam", "afstand");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "verkeerstechniek");
                }
                if(leerling.getButtonHolder().getVerkeersTechniekButtons().indexOf(icoon) == 4) {
                    jsonIcoon.add("naam", "inhalen");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "verkeerstechniek");
                }
                if(leerling.getButtonHolder().getVerkeersTechniekButtons().indexOf(icoon) == 5) {
                    jsonIcoon.add("naam", "kruisen");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "verkeerstechniek");
                }
                if(leerling.getButtonHolder().getVerkeersTechniekButtons().indexOf(icoon) == 6) {
                    jsonIcoon.add("naam", "linksAf");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "verkeerstechniek");
                }
                if(leerling.getButtonHolder().getVerkeersTechniekButtons().indexOf(icoon) == 7) {
                    jsonIcoon.add("naam", "rechtsAf");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "verkeerstechniek");
                }
                if(leerling.getButtonHolder().getVerkeersTechniekButtons().indexOf(icoon) == 8) {
                    jsonIcoon.add("naam", "pinkers");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "verkeerstechniek");
                }
                if(leerling.getButtonHolder().getVerkeersTechniekButtons().indexOf(icoon) == 9) {
                    jsonIcoon.add("naam", "openbareWeg");
                    jsonIcoon.add("toestand", icoon.getHuidigeToestand().toString());
                    jsonIcoon.add("type", "verkeerstechniek");
                }
                jsonIconen.add(jsonIcoon);
            }
            
            jsonLeerling.add("iconen", jsonIconen);
                out.writeObject(jsonLeerling.build());
            }
        }

    }
