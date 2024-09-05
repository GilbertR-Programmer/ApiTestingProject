package models;

import io.restassured.RestAssured;
import pojos.Pet;
import pojos.TagsItem;
import utils.RequestUtils;
import utils.SharedData;

public class FindPetByTagsModel extends ApiModel{

    private static final String PATH = "/pet/findByTags";

    public FindPetByTagsModel() {
        SharedData.getInstance().request = RestAssured.given(RequestUtils.buildBasicRequest(BASE_URI,PATH)).when();

    }

    public void enterTags(TagsItem[] tags){
        SharedData.getInstance().request.body(tags);
    }

    @Override
    public void sendRequest() {
        SharedData.getInstance().response = SharedData.getInstance().request.get().prettyPeek().thenReturn();
    }

    public void addTagToRequest(String tag) {
        SharedData.getInstance().request.queryParam("tags",tag);
    }

    public Pet[] getPetsFromResponse() {
        return SharedData.getInstance().response.as(Pet[].class);
    }

    public String getResponseMessage() {
        return SharedData.getInstance().response.body().asString();
    }
}
