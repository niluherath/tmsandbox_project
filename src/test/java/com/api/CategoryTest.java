package com.api;

import com.pojo.Category;
import com.pojo.Promotion;
import io.restassured.response.Response;
import org.testng.Assert;
import com.utils.ServiceUtils;

import java.util.ArrayList;


public class CategoryTest {

    private final int catId = 6327;
    private final String CATEGORY_ID = "6327";

    @org.testng.annotations.Test(description = "")
    public void validateCategoryId() {

        Response response = ServiceUtils.getCategoryResponse(CATEGORY_ID);
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response.asString());
        Category category = response.as(Category.class);
        Assert.assertEquals(category.getCategoryId(), catId);
    }

    @org.testng.annotations.Test(description = "")
    public void validateCanReList() {

        Response response = ServiceUtils.getCategoryResponse(CATEGORY_ID);
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response.asString());
        Category category = response.as(Category.class);
        Assert.assertEquals(category.canRelist, true);
    }

    @org.testng.annotations.Test(description = "")
    public void validateGalleryPromotionsText() {

        Response response = ServiceUtils.getCategoryResponse(CATEGORY_ID);
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response.asString());
        Category category = response.as(Category.class);
        ArrayList<Promotion> promotions = category.getPromotions();
        Assert.assertEquals("Gallery", promotions.get(1).getName());
        Assert.assertEquals("Good position in category", promotions.get(1).getDescription());
    }
}
