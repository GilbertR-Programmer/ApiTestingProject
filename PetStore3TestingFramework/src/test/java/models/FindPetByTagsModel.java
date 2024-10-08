package models;

import io.restassured.RestAssured;
import pojos.Pet;
import pojos.TagsItem;
import utils.RequestUtils;
import utils.SharedData;
import static utils.SharedData.*;

public class FindPetByTagsModel extends ApiModel{

    private static final String PATH = "/pet/findByTags";

    public FindPetByTagsModel() {
        request = RestAssured.given(RequestUtils.buildBasicRequest(BASE_URI,PATH)).when();

    }

    public void enterTags(TagsItem[] tags){
        request.body(tags);
    }

    public void addTagToRequest(String tag) {
        request.queryParam("tags",tag);
    }

    public Pet[] getPetsFromResponse() {
        return response.as(Pet[].class);
    }

}
