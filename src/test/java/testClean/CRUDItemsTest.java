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


public class CRUDItemsTest {

    @BeforeEach
    public void before() throws IOException {
        new GetProperties().leerPropiedades();
    }

    @Test
    public void verifyCreateItems(){
        JSONObject body = new JSONObject();
        body.put("Content","CreateItemPamela");

        RequestInformation request = new RequestInformation(ConfigAPI.CREATE_ITEMS,body.toString());
        Response response = FactoryRequest.make(FactoryRequest.POST).send(request);
        response.then()
                .statusCode(200)
                .body("Content", equalTo("CreateItemPamela"));

    }
    @Test
    public void verifyUpdateItems(){
        JSONObject body = new JSONObject();
        body.put("Content","ItemPamela");

        RequestInformation request = new RequestInformation(ConfigAPI.CREATE_ITEMS,body.toString());
        Response response = FactoryRequest.make(FactoryRequest.POST).send(request);
        response.then()
                .statusCode(200)
                .body("Content", equalTo("ItemPamela"));
        String id = response.then().extract().path("Id")+"";

        body.put("Content","UpdateItemPamela");
        body.put("Checked",true);

        request = new RequestInformation(ConfigAPI.UPDATE_ITEMS.replace("ID",id),body.toString());
        response = FactoryRequest.make(FactoryRequest.PUT).send(request);

        response.then()
                .statusCode(200)
                .body("Content", equalTo("UpdateItemPamela"))
                .body("Checked", equalTo(true));

    }
    @Test
    public void verifyReadItems(){
        JSONObject body = new JSONObject();
        body.put("Content","GetItemPamela");
        body.put("Collapsed",true);


        RequestInformation request = new RequestInformation(ConfigAPI.CREATE_ITEMS,body.toString());
        Response response = FactoryRequest.make(FactoryRequest.POST).send(request);
        response.then()
                .statusCode(200)
                .body("Content", equalTo("GetItemPamela"));
        String id = response.then().extract().path("Id")+"";

        request = new RequestInformation(ConfigAPI.READ_ITEMS.replace("ID",id),"");
        response = FactoryRequest.make(FactoryRequest.GET).send(request);

        response.then()
                .statusCode(200)
                .body("Content", equalTo("GetItemPamela"))
                .body("Collapsed", equalTo(true));


    }
    @Test
    public void verifyDeleteItem(){
        JSONObject body = new JSONObject();
        body.put("Content","DeleteItemPamela");


        RequestInformation request = new RequestInformation(ConfigAPI.CREATE_ITEMS,body.toString());
        Response response = FactoryRequest.make(FactoryRequest.POST).send(request);
        response.then()
                .statusCode(200)
                .body("Content", equalTo("DeleteItemPamela"));
        String id = response.then().extract().path("Id")+"";

        request = new RequestInformation(ConfigAPI.DELETE_ITEMS.replace("ID",id),"");
        response = FactoryRequest.make(FactoryRequest.DELETE).send(request);

        response.then()
                .statusCode(200)
                .body("Deleted", equalTo(true));

    }

}