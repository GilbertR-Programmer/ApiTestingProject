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

    @Override
    public void sendRequest() {
        response = request.post().prettyPeek().thenReturn();
    }

    public void enterPet(Pet petToAdd) {
        request.body(petToAdd);
    }
}
