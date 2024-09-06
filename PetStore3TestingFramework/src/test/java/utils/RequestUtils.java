package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestUtils {

    public static RequestSpecification buildBasicRequest(String uri, String path){
        return getBasicRequest(uri,path)
                .build();
    }

    private static RequestSpecBuilder getBasicRequest(String uri, String path){
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .setBasePath(path)
                .addHeaders(Map.of(
                        "Accept", "application/json",
                        "Content-Type", "application/json"
                ));
    }

    public static RequestSpecification buildGetPetByIdRequest(String uri, String path, Integer petId){
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .setBasePath(path)
                .addHeaders(Map.of(
                        "Accept", "application/json",
                        "Content-Type", "application/json"
                ))
                .addPathParams(Map.of(
                        "petId", petId
                ))
                .build();
    }
}
