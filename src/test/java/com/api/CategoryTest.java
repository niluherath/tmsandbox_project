package com.api;

import com.pojo.Category;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class CategoryTest {

    private final String ACCEPT = "accept";
    private final String ACCEPT_ENCODING = "accept-encoding";
    private final String ACCEPT_LANGUAGE = "accept-language";
    private final String ACCESS_CONTROL_REQUEST_HEADERS = "access-control-request-headers";
    private final String ACCEPT_HEADERS = "*/*";
    private final String ACCEPT_ENCODING_HEADERS = "gzip, deflate, br";
    private final String ACCEPT_LANGUAGE_HEADERS = "en-US,en;q=0.9";
    private final String ACCESS_CONTROL_REQUEST_HEADERS_VALUES = "authorization,newrelic,x-trademe-uniqueclientid";
    private final String CATEGORY_ID = "6327";
    private final int catId = 6327;

    @org.testng.annotations.Test(description = "")
    public void getCategoryInfoTest() {

        RestAssured.baseURI = "https://api.tmsandbox.co.nz";
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.header(ACCEPT, ACCEPT_HEADERS);
        request.header(ACCEPT_ENCODING, ACCEPT_ENCODING_HEADERS);
        request.header(ACCEPT_LANGUAGE, ACCEPT_LANGUAGE_HEADERS);
        request.header(ACCESS_CONTROL_REQUEST_HEADERS, ACCESS_CONTROL_REQUEST_HEADERS_VALUES);
        request.param("catalogue", false);
        Response response = request.get("v1/Categories/" + CATEGORY_ID + "/Details.json");
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response.asString());
        Category category = response.as(Category.class);
        Assert.assertEquals(category.getCategoryId(), catId);


    }
}
