package models;

import config.AppConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.SharedData;

public abstract class ApiModel {

    protected static final String BASE_URI = AppConfig.getBaseUri();
    protected static final String OAUTH_KEY = AppConfig.getOAuthKey();

    public abstract void sendRequest();

    public String getServer() {
        return SharedData.getInstance().response.getHeader("Server");
    }

    public int getResponseStatusCode() {
        return SharedData.getInstance().response.getStatusCode();
    }

    public void enterInvalidBody(String invalidBodyAsText) {
        SharedData.getInstance().request.body(invalidBodyAsText);
    }
}
