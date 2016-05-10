package json;

import domein.Leerling;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
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
           jsonLeerling.add("wachtwoord","666");
           
           out.writeObject(jsonLeerling.build());
       }
    }
        
}
