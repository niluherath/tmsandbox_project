package com.utils;

import com.api.CategoryTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.log4testng.Logger;


public class ServiceUtils {

    private final static String ACCEPT = "accept";
    private final static String ACCEPT_ENCODING = "accept-encoding";
    private final static String ACCEPT_HEADERS = "*/*";
    private final static String ACCEPT_ENCODING_HEADERS = "gzip, deflate, br";
    public static org.testng.log4testng.Logger logger = Logger.getLogger(CategoryTest.class);


    public static Response getCategoryResponse(String categoryId){

        RestAssured.baseURI = "https://api.tmsandbox.co.nz";
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        logger.info("Request URI: " + request.log().uri());
        logger.info("Request headers: " + request.log().headers());
        logger.info("Request params: " + request.log().params());
        request.header(ACCEPT, ACCEPT_HEADERS);
        request.header(ACCEPT_ENCODING, ACCEPT_ENCODING_HEADERS);
        request.param("catalogue", false);
        Response response = request.get("v1/Categories/" + categoryId + "/Details.json");
        return response;

    }

}
