package models;

import io.restassured.RestAssured;
import pojos.FindPetByIdResponse;
import pojos.Pet;
import utils.RequestUtils;

import java.util.Map;

import static utils.SharedData.*;

public class FindPetByIdModel extends ApiModel {

    private static final String PET_PATH = "/pet/{petId}";

    @Override
    public void sendRequest() {
        response = request.get().prettyPeek().thenReturn();
    }

    public FindPetByIdModel(String pet_Id) {
        request = RestAssured.given(RequestUtils.buildRequestWithPathParams(BASE_URI, PET_PATH, Map.of(
                "petId", pet_Id
        ))).when();
    }

    public String getPetIdInResponse() {
        return String.valueOf(response.as(FindPetByIdResponse.class).id());
    }

    public Pet getPetInResponse() {
        return response.as(Pet.class);
    }
}
