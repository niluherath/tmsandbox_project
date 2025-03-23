package com.api;

import com.utils.ServiceUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class NegativeCategoryTest {

    private final String categoryId = "6327";
    private final String nonExistentCategoryId = "99999999999999999999999999999";
    public static Logger logger = Logger.getLogger(NegativeCategoryTest.class);

    @Test(description = "validates 415 response for incorrect header")
    public void validateResponseForInvalidHeaders() {

        Response response = ServiceUtils.getInvalidCategoryResponseForIncorrectHeaders(categoryId);
        Assert.assertEquals(response.getStatusCode(), 415);
        logger.info(response.prettyPeek());
    }

    @Test(description = "validates 400 response for empty headers")
    public void validateResponseForEmptyHeaders() {

        Response response = ServiceUtils.getInvalidCategoryResponseForEmptyHeaders(categoryId);
        Assert.assertEquals(response.getStatusCode(), 400);
        logger.info(response.prettyPeek());
    }

    @Test(description = "validates 404 response for invalid URI")
    public void validateResponseForInvalidRequestURI() {

        Response response = ServiceUtils.getInvalidCategoryResponseForInvalidURI(categoryId);
        Assert.assertEquals(response.getStatusCode(), 404);
        logger.info(response.prettyPeek());
    }

    @Test(description = "validates 404 response for a request with invalid parameters")
    public void validateResponseForInvalidRequestParameters() {

        Response response = ServiceUtils.getInvalidCategoryResponseForInvalidParameters(categoryId);
        Assert.assertEquals(response.getStatusCode(), 404);
        logger.info(response.prettyPeek());
    }

    @Test(description = "validates 404 response for a category id that doesn't exist")
    public void validateResponseForCategoryIdThatDoesntExist() {

        Response response = ServiceUtils.getCategoryResponseforACategoryIdThatDoesntExist(nonExistentCategoryId);
        Assert.assertEquals(response.getStatusCode(), 404);
        logger.info(response.prettyPeek());
    }


}
