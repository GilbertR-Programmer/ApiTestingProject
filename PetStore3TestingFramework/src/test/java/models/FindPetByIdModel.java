package models;

import config.AppConfig;
import io.restassured.RestAssured;

public class FindPetByIdModel extends ApiModel {

    private final String PET_PATH = "/pet/{petId}";

    @Override
    public void sendRequest() {
        response = request.get().prettyPeek().thenReturn();
    }

    public FindPetByIdModel() {
        request = RestAssured.given(RequestUtils.buildBasicRequest(BASE_URI, PET_PATH)).when();
    }
}
