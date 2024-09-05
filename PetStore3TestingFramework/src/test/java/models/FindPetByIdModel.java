package models;

import config.AppConfig;
import io.restassured.RestAssured;

public class FindPetByIdModel extends ApiModel {

    private final String PET_PATH = "/pet/{petId}";

    @Override
    public void sendRequest() {
        response = request.get().prettyPeek().thenReturn();
    }

    public FindPetByIdModel(Integer pet_Id) {
        request = RestAssured.given(RequestUtils.buildGetPetByIdRequest(BASE_URI, PET_PATH, pet_Id)).when();
    }
}
