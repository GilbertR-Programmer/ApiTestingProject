package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SharedData {
    private static final SharedData instance = new SharedData();

    public static Response response;
    public static RequestSpecification request;

    // Private constructor to prevent external instantiation
    private SharedData() {}

    // Get the singleton instance
    public static SharedData getInstance() {
        return instance;
    }
}

