package models;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.AddPet;

public class AddPetModel extends ApiModel{

    private String PATH = "/pet";

    public AddPetModel(){
        request = RequestUtils.buildBasicRequest();
    }

    @Override
    public void sendRequest() {
        response = request.post().thenReturn();
    }

    public void enterPet(AddPet petToAdd) {
    }
}
