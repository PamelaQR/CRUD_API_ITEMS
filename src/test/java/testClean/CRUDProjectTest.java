package testClean;

import factoryRequest.FactoryRequest;
import factoryRequest.RequestInformation;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ConfigAPI;
import utils.GetProperties;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;


public class CRUDProjectTest {

    @BeforeEach
    public void before() throws IOException {
        new GetProperties().leerPropiedades();
    }

    @Test
    public void verifyCRUDforProject(){
        JSONObject body = new JSONObject();
        body.put("Content","Eynar");
        body.put("Icon",4);

        RequestInformation request = new RequestInformation(ConfigAPI.CREATE_PROJECT,body.toString());
        Response response = FactoryRequest.make(FactoryRequest.POST).send(request);
        response.then()
                .statusCode(200)
                .body("Content", equalTo("Eynar"));
        String id = response.then().extract().path("Id")+"";

        request = new RequestInformation(ConfigAPI.UPDATE_PROJECT.replace("ID",id),body.toString());
        response = FactoryRequest.make(FactoryRequest.PUT).send(request);

        response.then()
                .statusCode(200)
                .body("Content", equalTo("Eynar"));

        request = new RequestInformation(ConfigAPI.READ_PROJECT.replace("ID",id),"");
        response = FactoryRequest.make(FactoryRequest.GET).send(request);

        response.then()
                .statusCode(200)
                .body("Content", equalTo("Eynar"));

        request = new RequestInformation(ConfigAPI.DELETE_PROJECT.replace("ID",id),"");
        response = FactoryRequest.make(FactoryRequest.DELETE).send(request);

        response.then()
                .statusCode(200)
                .body("Deleted", equalTo(true));

    }

}