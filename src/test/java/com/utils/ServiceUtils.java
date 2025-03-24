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
    private static final String CATALOGUE = "catalogue";
    private static final String REQUST_URI = "Request URI: ";
    private static final String REQUEST_HEADERS = "Request headers: ";
    private static final String REQUEST_PARAM = "Request params: ";
    public static Logger logger = Logger.getLogger(ServiceUtils.class);


    public static Response getCategoryResponse(String categoryId) {

        RestAssured.baseURI = ConfigLoader.getInstance().getAPIBaseUrl();
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.header(ACCEPT, ACCEPT_HEADERS);
        request.header(ACCEPT_ENCODING, ACCEPT_ENCODING_HEADERS);
        request.header(CONTENT_TYPE, CONTENT_TYPE_HEADERS);
        request.param(CATALOGUE, false);
        logger.info(REQUST_URI + request.log().uri());
        logger.info(REQUEST_HEADERS + request.log().headers());
        logger.info(REQUEST_PARAM + request.log().params());
        return request.get(V_1_CATEGORIES + categoryId + DETAILS_JSON);
    }

    public static Response getCategoryResponseForIncorrectHeaders(String categoryId) {

        RestAssured.baseURI = ConfigLoader.getInstance().getAPIBaseUrl();
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.header(CONTENT_TYPE, INCORRECT_CONTENT_TYPE_HEADERS);
        request.param(CATALOGUE, false);
        logger.info(REQUST_URI + request.log().uri());
        logger.info(REQUEST_HEADERS + request.log().headers());
        logger.info(REQUEST_PARAM + request.log().params());
        return request.get(V_1_CATEGORIES + categoryId + DETAILS_JSON);

    }

    public static Response getCategoryResponseForInvalidParameters(String categoryId) {

        RestAssured.baseURI = ConfigLoader.getInstance().getAPIBaseUrl();
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.param(CATALOGUE, 1234);
        logger.info(REQUST_URI + request.log().uri());
        logger.info(REQUEST_HEADERS + request.log().headers());
        logger.info(REQUEST_PARAM + request.log().params());
        return request.get(V_1_CATEGORIES + categoryId + DETAILS_JSON);
    }

    public static Response getCategoryResponseforACategoryIdThatDoesntExist(String categoryId) {

        RestAssured.baseURI = ConfigLoader.getInstance().getAPIBaseUrl();
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.header(ACCEPT, ACCEPT_HEADERS);
        request.header(ACCEPT_ENCODING, ACCEPT_ENCODING_HEADERS);
        request.param(CATALOGUE, false);
        logger.info(REQUST_URI + request.log().uri());
        logger.info(REQUEST_HEADERS + request.log().headers());
        logger.info(REQUEST_PARAM + request.log().params());
        return request.get(V_1_CATEGORIES + categoryId + DETAILS_JSON);
    }

    public static Response getCategoryResponseForEmptyHeaders(String categoryId) {

        RestAssured.baseURI = ConfigLoader.getInstance().getAPIBaseUrl();
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.header(ACCEPT, "");
        request.header(ACCEPT_ENCODING, "");
        request.header(CONTENT_TYPE, "");
        request.param(CATALOGUE, false);
        logger.info(REQUST_URI + request.log().uri());
        logger.info(REQUEST_HEADERS + request.log().headers());
        logger.info(REQUEST_PARAM + request.log().params());
        return request.get(V_1_CATEGORIES + categoryId + DETAILS_JSON);
    }

}
