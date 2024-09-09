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

    public void enterPet(Pet petToUpdate) {
        request.body(petToUpdate);
    }

    public Pet getUpdatedPet() {
        return response.as(Pet.class);
    }
}