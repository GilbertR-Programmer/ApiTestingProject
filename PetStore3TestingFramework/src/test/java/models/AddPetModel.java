package models;

import io.restassured.RestAssured;
import pojos.AddPet;

public class AddPetModel extends ApiModel{

    private String PATH = "/pet";

    public AddPetModel(){
        request = RestAssured.given(RequestUtils.buildBasicRequest(BASE_URI,PATH));
    }

    @Override
    public void sendRequest() {
        response = request.when().post().thenReturn();
    }

    public void enterPet(AddPet petToAdd) {
        request.body(petToAdd);
    }
}
