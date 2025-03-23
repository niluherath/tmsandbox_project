package com.utils;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class ServiceUtils {

    private final static String ACCEPT = "accept";
    private final static String ACCEPT_ENCODING = "accept-encoding";
    private final static String ACCEPT_HEADERS = "*/*";
    private final static String ACCEPT_ENCODING_HEADERS = "gzip, deflate, br";


    public static Response getCategoryResponse(String categoryId){

        RestAssured.baseURI = "https://api.tmsandbox.co.nz";
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.header(ACCEPT, ACCEPT_HEADERS);
        request.header(ACCEPT_ENCODING, ACCEPT_ENCODING_HEADERS);
        request.param("catalogue", false);
        return request.get("v1/Categories/" + categoryId + "/Details.json");

    }

}
