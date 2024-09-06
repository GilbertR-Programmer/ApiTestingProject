package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.entity.ContentType;

import java.io.Serializable;
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

    public static RequestSpecification buildOctetRequest(String uri, String path){
        return getOctetRequest(uri,path)
                .build();
    }

    private static RequestSpecBuilder getOctetRequest(String uri, String path){
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .setBasePath(path)
                .setContentType("application/octet-stream")
                .addHeaders(Map.of(
                        "Accept", "application/json"
                ));
    }



    public static RequestSpecification buildRequestWithPathParams(String uri, String path,Map<String, ? extends Serializable> pathParams){
        return getRequestWithPathParams(uri,path,pathParams)
                .build();
    }

    public static RequestSpecBuilder getRequestWithPathParams(String uri, String path, Map<String, ? extends Serializable> pathParams){
        return getBasicRequest(uri, path)
                .addPathParams(pathParams);
    }
}