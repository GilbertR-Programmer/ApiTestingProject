package models;

import config.AppConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class ApiModel {

    protected RequestSpecification request;
    protected Response response;
    protected static final String BASE_URI = AppConfig.getBaseUri();
    protected static final String OAUTH_KEY = AppConfig.getOAuthKey();

    public abstract void sendRequest();

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
