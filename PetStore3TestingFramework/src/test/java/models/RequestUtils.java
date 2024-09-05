package models;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestUtils {

    public static RequestSpecification buildBasicRequest(String uri, String path){
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .setBasePath(path)
                .addHeaders(Map.of(
                        "Accept", "application/json",
                        "Content-Type", "application/json"
                ))
                .build();
    }
}
