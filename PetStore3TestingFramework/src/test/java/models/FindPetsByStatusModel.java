package models;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FindPetsByStatusModel extends ApiModel {

    private String PATH = "/pet/findByStatus";

    public FindPetsByStatusModel() {
        request = RestAssured.given(RequestUtils.buildBasicRequest(BASE_URI, PATH)).when();
    }

    public Response getPetsByStatus(String status) {
        return request.param("status", status).get().prettyPeek().thenReturn();
    }

    @Override
    public void sendRequest() {

    }
}