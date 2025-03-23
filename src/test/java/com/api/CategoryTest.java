package com.api;

import com.pojo.Category;
import com.pojo.Promotion;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.log4testng.Logger;
import com.utils.ServiceUtils;
import org.testng.annotations.Test;

public class CategoryTest {

    private final int cat_Id = 6327;
    private final String category_Id = "6327";
    private final String category_Name = "Carbon credits";
    private final String promotion_Name = "Gallery";
    private final String gallery_description = "Good position in category";
    public static org.testng.log4testng.Logger logger = Logger.getLogger(CategoryTest.class);

    @Test(description = "This test validates that category id returned is 6327")
    public void validateCategoryId() {

        Response response = ServiceUtils.getCategoryResponse(category_Id);
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info(response.prettyPeek());
        Category category = response.as(Category.class);
        Assert.assertEquals(category.getCategoryId(), cat_Id);
    }

    @Test(description = "This test validates that category name for category id 6327 is 'Carbon credits'")
    public void validateCategoryName() {

        Response response = ServiceUtils.getCategoryResponse(category_Id);
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info(response.prettyPeek());
        Category category = response.as(Category.class);
        Assert.assertEquals(category.getName(), category_Name);
    }

    @Test(description = "This test validates that for category id 6327 canRelist is true")
    public void validateCanReList() {

        Response response = ServiceUtils.getCategoryResponse(category_Id);
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info(response.prettyPeek());
        Category category = response.as(Category.class);
        Assert.assertTrue(category.canRelist);
    }

    @Test(description = "This test finds the promotion where name is 'Gallery' and validates that it's description is 'Good position in category'")
    public void validateGalleryPromotionsText() {

        Response response = ServiceUtils.getCategoryResponse(category_Id);
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info(response.prettyPeek());
        Category category = response.as(Category.class);
        Assert.assertTrue(!category.getPromotions().isEmpty());

        boolean isPromotionFound = false;

        for (Promotion promotion : category.getPromotions()) {
            if (promotion.getName().equals(promotion_Name)) {
                Assert.assertEquals(promotion.getDescription(), gallery_description);
                isPromotionFound = true;
                break;
            }
        }
        if (!isPromotionFound) {
            Assert.fail();
        }
    }
}
