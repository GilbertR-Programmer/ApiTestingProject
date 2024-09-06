package models;

import config.AppConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.SharedData;
import static utils.SharedData.*;


public class ApiModel {

    protected static final String BASE_URI = AppConfig.getBaseUri();
    protected static final String OAUTH_KEY = AppConfig.getOAuthKey();

    public void sendPostRequest(){
        response = request.post().prettyPeek().thenReturn();
    }

    public void sendGetRequest(){
        response = request.get().prettyPeek().thenReturn();
    }

    public void sendPutRequest(){
        response = request.put().prettyPeek().thenReturn();
    }

    public void sendDeleteRequest(){
        response = request.delete().prettyPeek().thenReturn();
    }

    public void sendPatchRequest(){
        response = request.patch().prettyPeek().thenReturn();
    }

    public String getServer() {
        return response.getHeader("Server");
    }

    public int getResponseStatusCode() {
        return response.getStatusCode();
    }

    public void enterInvalidBody(String invalidBodyAsText) {
        request.body(invalidBodyAsText);
    }
}
