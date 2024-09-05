package models;

import pojos.AddPet;

public class AddPetModel extends ApiModel{

    @Override
    public void sendRequest() {
        
    }

    @Override
    public String getServer() {
        return "";
    }

    @Override
    public int getResponseStatusCode() {
        return 0;
    }

    public void enterPet(AddPet addPet) {
    }
}
