package models;

import io.restassured.RestAssured;
import pojos.Pet;
import pojos.TagsItem;
import utils.RequestUtils;

import java.io.Serializable;

import static utils.SharedData.request;
import static utils.SharedData.response;

public class UploadImageModel extends ApiModel{

    private static final String PATH = "/pet/{petId}/uploadImage";

    public UploadImageModel() {
        request = RestAssured.given(RequestUtils.buildOctetRequest(BASE_URI,PATH)).when();
    }

    public void enterId(Integer id){
        request.pathParam("petId",id);
    }

    public void enterId(String id){
        request.pathParam("petId",id);
    }

    public void addImageToBody(byte[] imageBytes){
        request.body(imageBytes);
    }

    public Pet getPetFromResponse() {
        return response.as(Pet.class);
    }
}
