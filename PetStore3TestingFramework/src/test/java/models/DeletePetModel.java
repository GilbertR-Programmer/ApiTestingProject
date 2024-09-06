package models;

import io.restassured.RestAssured;
import utils.RequestUtils;

import java.util.Map;

import static utils.SharedData.*;

public class DeletePetModel extends ApiModel {

    private static final String DELETE_PET_PATH = "/pet/{petId}";

    public DeletePetModel(Integer petId, String apiKey) {
        request = RestAssured.given(RequestUtils.buildRequestWithPathParams(BASE_URI, DELETE_PET_PATH, Map.of(
                        "petId", petId
                )))
                .header("api_key", apiKey)
                .when();
    }
}
