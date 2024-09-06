package models;

import io.restassured.RestAssured;
import pojos.Pet;
import utils.RequestUtils;
import static utils.SharedData.*;

public class AddPetModel extends ApiModel{

    private String PATH = "/pet";

    public AddPetModel(){
        request = RestAssured.given(RequestUtils.buildBasicRequest(BASE_URI,PATH)).when();
    }

    public void enterPet(Pet petToAdd) {
        request.body(petToAdd);
    }

    public Pet getAddedPet() {
        return response.as(Pet.class);
    }
}
