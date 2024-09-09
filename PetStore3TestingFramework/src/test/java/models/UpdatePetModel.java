package models;

import io.restassured.RestAssured;
import pojos.Pet;
import utils.RequestUtils;
import static utils.SharedData.*;

public class UpdatePetModel extends ApiModel {

    private final String PATH = "/pet";

    public UpdatePetModel() {
        request = RestAssured.given(RequestUtils.buildBasicRequest(BASE_URI, PATH)).when();
    }

    public void enterUpdatedPet(Pet updatedPet) {
        request.body(updatedPet);
    }

    public int getCreatedPetId() {
        return response.jsonPath().getInt("id");
    }
}