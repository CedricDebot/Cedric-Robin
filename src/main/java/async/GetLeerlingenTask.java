package async;

import domein.Leerling;
import java.rmi.ServerException;
import java.util.List;
import javafx.concurrent.Task;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import json.LeerlingListReader;

public class GetLeerlingenTask extends Task<List<Leerling>> {

    private final WebTarget leerlingenListResource;

    public GetLeerlingenTask() {
        leerlingenListResource = ClientBuilder.newClient()
                .target("http://172.20.10.3:8080/Backend_Rijschool/api")
                .path("leerlingen")
                .register(LeerlingListReader.class);
    }
    
    
    @Override
    protected List<Leerling> call() throws Exception {
        Response response = leerlingenListResource.request(MediaType.APPLICATION_JSON).get();
        if(response.getStatus() == 200){
            List<Leerling> leerlingen = response.readEntity(new GenericType<List<Leerling>>(){});
            return leerlingen;
        }else {
            throw new ServerException("");
        }
    }
    
}
