package models;

import io.restassured.RestAssured;
import pojos.Pet;
import utils.RequestUtils;
import utils.SharedData;

public class AddPetModel extends ApiModel{

    private String PATH = "/pet";

    public AddPetModel(){
        SharedData.getInstance().request = RestAssured.given(RequestUtils.buildBasicRequest(BASE_URI,PATH)).when();
    }

    @Override
    public void sendRequest() {
        SharedData.getInstance().response = SharedData.getInstance().request.post().prettyPeek().thenReturn();
    }

    public void enterPet(Pet petToAdd) {
        SharedData.getInstance().request.body(petToAdd);
    }
}
