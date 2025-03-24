package com.utils;

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
    public static Logger LOG = Logger.getLogger(ServiceUtils.class);


    public static Response getCategoryResponse(String categoryId) {

        RestAssured.baseURI = ConfigLoader.getInstance().getAPIBaseUrl();
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.header(ACCEPT, ACCEPT_HEADERS);
        request.header(ACCEPT_ENCODING, ACCEPT_ENCODING_HEADERS);
        request.header(CONTENT_TYPE, CONTENT_TYPE_HEADERS);
        request.param("catalogue", false);
        LOG.info("Request URI: " + request.log().uri());
        LOG.info("Request headers: " + request.log().headers());
        LOG.info("Request params: " + request.log().params());
        return request.get(V_1_CATEGORIES + categoryId + DETAILS_JSON);
    }

    public static Response getCategoryResponseForIncorrectHeaders(String categoryId) {

        RestAssured.baseURI = ConfigLoader.getInstance().getAPIBaseUrl();
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.header(CONTENT_TYPE, INCORRECT_CONTENT_TYPE_HEADERS);
        request.param("catalogue", false);
        LOG.info("Request URI: " + request.log().uri());
        LOG.info("Request headers: " + request.log().headers());
        LOG.info("Request params: " + request.log().params());
        return request.get(V_1_CATEGORIES + categoryId + DETAILS_JSON);

    }

    public static Response getCategoryResponseForInvalidParameters(String categoryId) {

        RestAssured.baseURI = ConfigLoader.getInstance().getAPIBaseUrl();
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.param("catalogue", 1234);
        LOG.info("Request URI: " + request.log().uri());
        LOG.info("Request headers: " + request.log().headers());
        LOG.info("Request params: " + request.log().params());
        return request.get(V_1_CATEGORIES + categoryId + DETAILS_JSON);
    }

    public static Response getCategoryResponseforACategoryIdThatDoesntExist(String categoryId) {

        RestAssured.baseURI = ConfigLoader.getInstance().getAPIBaseUrl();
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.header(ACCEPT, ACCEPT_HEADERS);
        request.header(ACCEPT_ENCODING, ACCEPT_ENCODING_HEADERS);
        request.param("catalogue", false);
        LOG.info("Request URI: " + request.log().uri());
        LOG.info("Request headers: " + request.log().headers());
        LOG.info("Request params: " + request.log().params());
        return request.get(V_1_CATEGORIES + categoryId + DETAILS_JSON);
    }

    public static Response getCategoryResponseForEmptyHeaders(String categoryId) {

        RestAssured.baseURI = ConfigLoader.getInstance().getAPIBaseUrl();
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.header(ACCEPT, "");
        request.header(ACCEPT_ENCODING, "");
        request.header(CONTENT_TYPE, "");
        request.param("catalogue", false);
        LOG.info("Request URI: " + request.log().uri());
        LOG.info("Request headers: " + request.log().headers());
        LOG.info("Request params: " + request.log().params());
        return request.get(V_1_CATEGORIES + categoryId + DETAILS_JSON);
    }

}
