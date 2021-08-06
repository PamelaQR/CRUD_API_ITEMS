package factoryRequest;

import io.restassured.response.Response;
import utils.ConfigEnv;

import static io.restassured.RestAssured.given;

public class RequestDELETE implements IRequest{
    @Override
    public Response send(RequestInformation information) {
        Response response=given()
                .auth()
                .preemptive()
                .basic(ConfigEnv.user,ConfigEnv.password)
                .log()
                .all()
                .when()
                .delete(information.getUrl());
        response.then()
                .log()
                .all();
        return response;
    }
}
