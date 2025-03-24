package com.utils;

import com.api.CategoryTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.log4testng.Logger;


public class ServiceUtils {

    private static final String ACCEPT = "accept";
    private static final String ACCEPT_ENCODING = "accept-encoding";
    private static final String ACCEPT_HEADERS = "*/*";
    private static final String ACCEPT_ENCODING_HEADERS = "gzip, deflate, br";
    private static final String CONTENT_TYPE = "content_type";
    private static final String CONTENT_TYPE_HEADERS = "application/json";
    private static final String INCORRECT_CONTENT_TYPE_HEADERS = "text/plain";
    private static final String V_1_CATEGORIES = "v1/Categories/";
    private static final String DETAILS_JSON = "/Details.json";
    public static org.testng.log4testng.Logger logger = Logger.getLogger(CategoryTest.class);


    public static Response getCategoryResponse(String categoryId) {

        RestAssured.baseURI = ConfigLoader.getInstance().getAPIBaseUrl();
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.header(ACCEPT, ACCEPT_HEADERS);
        request.header(ACCEPT_ENCODING, ACCEPT_ENCODING_HEADERS);
        request.header(CONTENT_TYPE, CONTENT_TYPE_HEADERS);
        request.param("catalogue", false);
        logger.info("Request URI: " + request.log().uri());
        logger.info("Request headers: " + request.log().headers());
        logger.info("Request params: " + request.log().params());
        return request.get(V_1_CATEGORIES + categoryId + DETAILS_JSON);
    }

    public static Response getInvalidCategoryResponseForIncorrectHeaders(String categoryId) {

        RestAssured.baseURI = ConfigLoader.getInstance().getAPIBaseUrl();
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.header(CONTENT_TYPE, INCORRECT_CONTENT_TYPE_HEADERS);
        request.param("catalogue", false);
        logger.info("Request URI: " + request.log().uri());
        logger.info("Request headers: " + request.log().headers());
        logger.info("Request params: " + request.log().params());
        return request.get(V_1_CATEGORIES + categoryId + DETAILS_JSON);

    }

    public static Response getInvalidCategoryResponseForInvalidURI(String categoryId) {

        RestAssured.baseURI = ConfigLoader.getInstance().getAPIBaseUrl();
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.param("catalogue", false);
        logger.info("Request URI: " + request.log().uri());
        logger.info("Request headers: " + request.log().headers());
        logger.info("Request params: " + request.log().params());
        return request.get("v1/xxxxxCategories/" + categoryId + DETAILS_JSON);
    }

    public static Response getInvalidCategoryResponseForInvalidParameters(String categoryId) {

        RestAssured.baseURI = ConfigLoader.getInstance().getAPIBaseUrl();
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.param("catalogue", 1234);
        logger.info("Request URI: " + request.log().uri());
        logger.info("Request headers: " + request.log().headers());
        logger.info("Request params: " + request.log().params());
        return request.get(V_1_CATEGORIES + categoryId + DETAILS_JSON);
    }

    public static Response getCategoryResponseforACategoryIdThatDoesntExist(String categoryId) {

        RestAssured.baseURI = ConfigLoader.getInstance().getAPIBaseUrl();
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.header(ACCEPT, ACCEPT_HEADERS);
        request.header(ACCEPT_ENCODING, ACCEPT_ENCODING_HEADERS);
        request.param("catalogue", false);
        logger.info("Request URI: " + request.log().uri());
        logger.info("Request headers: " + request.log().headers());
        logger.info("Request params: " + request.log().params());
        return request.get(V_1_CATEGORIES + categoryId + DETAILS_JSON);
    }

    public static Response getInvalidCategoryResponseForEmptyHeaders(String categoryId) {

        RestAssured.baseURI = ConfigLoader.getInstance().getAPIBaseUrl();
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.header(ACCEPT, "");
        request.header(ACCEPT_ENCODING, "");
        request.header(CONTENT_TYPE, "");
        request.param("catalogue", false);
        logger.info("Request URI: " + request.log().uri());
        logger.info("Request headers: " + request.log().headers());
        logger.info("Request params: " + request.log().params());
        return request.get(V_1_CATEGORIES + categoryId + DETAILS_JSON);
    }

}
