package async;

import domein.Leerling;
import java.rmi.ServerException;
import javafx.concurrent.Task;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class DeleteLeerlingTask extends Task<Void> {

    private final WebTarget leerlingResource;

    public DeleteLeerlingTask(Leerling leerling) {
        this.leerlingResource = ClientBuilder.newClient()
                .target("http://172.20.10.3:8080/Backend_Rijschool/api")
                .path("leerlingen")
                .path(leerling.getInschrijvingsNr());
    }
    
    
    
    @Override
    protected Void call() throws Exception {
        Response response = leerlingResource.request().delete();
        switch (response.getStatus()){
            case 204 : 
                return null;
            case 404 :  
                throw new NotFoundException();
            default :
                throw new ServerException("");
        }
    }
    
}
