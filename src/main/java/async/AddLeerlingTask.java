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

public class AddLeerlingTask extends Task<Void>{

    private final WebTarget leerlingListResource;
    private final Leerling leerling;
    
    public AddLeerlingTask(Leerling leerling) {
        this.leerling = leerling;
        leerlingListResource = ClientBuilder.newClient()
                .target("http://localhost:8080/Backend_Rijschool/api")
                .path("leerlingen")
                .register(LeerlingWriter.class);
    }

    @Override
    protected Void call() throws Exception {
        Response response = leerlingListResource.request().post(Entity.entity(leerling, MediaType.APPLICATION_JSON));
        switch (response.getStatus()) {
            case 201:
                return null;
            case 400: 
                throw new BadRequestException();
            default:
                throw new ServerException("");
        }
    }
    
    
    
}
