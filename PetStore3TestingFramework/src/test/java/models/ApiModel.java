package models;

import config.AppConfig;
import io.restassured.response.Response;

public abstract class ApiModel {

    private Response response;
    private static final String BASE_URI = AppConfig.getBaseUri();
    private static final String OAUTH_KEY = AppConfig.getOAuthKey();

    abstract void sendRequest();
    abstract void getServer();
    abstract void getResponseStatusCode();
}
