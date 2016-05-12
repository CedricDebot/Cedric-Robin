package async;

import domein.Leerling;
import java.rmi.ServerException;
import javafx.concurrent.Task;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import json.LeerlingWriter;

public class PutLeerlingTask extends Task<Void>{

    private final WebTarget leerlingListResource;
    private final Leerling leerling;

    public PutLeerlingTask(Leerling leerling) {
        this.leerlingListResource = ClientBuilder.newClient()
                .target("http://172.20.10.3:8080/Backend_Rijschool/api")
                .path("leerlingen")
                .path(leerling.getInschrijvingsNr())
                .register(LeerlingWriter.class);
        
        this.leerling = leerling;
    }
    
    
    @Override
    protected Void call() throws Exception {
        Response response = leerlingListResource.request().put(Entity.entity(leerling, MediaType.APPLICATION_JSON));
        switch (response.getStatus()) {
            case 204:
                return null;
            case 400:
                throw new BadRequestException();
            default:
                throw new ServerException("");
        }
    }
    
}
