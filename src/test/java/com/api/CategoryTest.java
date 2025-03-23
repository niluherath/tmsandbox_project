package com.api;

import com.pojo.Category;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.ServiceUtils;


public class CategoryTest {

    private final int catId = 6327;

    @org.testng.annotations.Test(description = "")
    public void getCategoryInfoTest() {

        Response response = ServiceUtils.getCategoryResponse(catId);
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response.asString());
        Category category = response.as(Category.class);
        Assert.assertEquals(category.getCategoryId(), catId);
    }
}
