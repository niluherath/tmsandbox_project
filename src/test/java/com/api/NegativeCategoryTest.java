package com.api;

import com.utils.ServiceUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeCategoryTest extends BaseTest {

    private final String categoryId = "6327";
    private final String nonExistentCategoryId = "99999999999999999999999999999";

    @Test(description = "validates 404 response for a category id that doesn't exist")
    public void validateResponseForCategoryIdThatDoesntExist() {

        Response response = ServiceUtils.getCategoryResponseforACategoryIdThatDoesntExist(nonExistentCategoryId);
        Assert.assertEquals(response.getStatusCode(), RESPONSE_CODE_404);
        LOGGER.info(response.prettyPeek());
    }

    @Test(description = "validates 415 response for incorrect header")
    public void validateResponseForIncorrectHeader() {

        Response response = ServiceUtils.getCategoryResponseForIncorrectHeaders(categoryId);
        Assert.assertEquals(response.getStatusCode(), RESPONSE_CODE_415);
        LOGGER.info(response.prettyPeek());
    }

    @Test(description = "validates 400 response for empty headers")
    public void validateResponseForEmptyHeaders() {

        Response response = ServiceUtils.getCategoryResponseForEmptyHeaders(categoryId);
        Assert.assertEquals(response.getStatusCode(), RESPONSE_CODE_400);
        LOGGER.info(response.prettyPeek());
    }

    @Test(description = "validates 404 response for a request with invalid parameters")
    public void validateResponseForInvalidRequestParameters() {

        Response response = ServiceUtils.getCategoryResponseForInvalidParameters(categoryId);
        Assert.assertEquals(response.getStatusCode(), RESPONSE_CODE_404);
        LOGGER.info(response.prettyPeek());
    }

}
