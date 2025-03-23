package com.api;

import com.pojo.Category;
import com.pojo.Promotion;
import io.restassured.response.Response;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.log4testng.Logger;
import com.utils.ServiceUtils;
import org.testng.annotations.Test;

public class CategoryTest {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CategoryTest.class);
    private final int CAT_ID = 6327;
    private final String CATEGORY_ID = "6327";
    private final String CATEGORY_NAME = "Carbon credits";
    private final String PROMOTION_NAME = "Gallery";
    private final String GALLERY_DESCRIPTION = "Good position in category";
    public static org.testng.log4testng.Logger logger = Logger.getLogger(CategoryTest.class);

    @Test(description = "This test validates that category id returned is 6327")
    public void validateCategoryId() {

        Response response = ServiceUtils.getCategoryResponse(CATEGORY_ID);
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info(response.prettyPeek());
        Category category = response.as(Category.class);
        Assert.assertEquals(category.getCategoryId(), CAT_ID);
    }

    @Test(description = "This test validates that category name for category id 6327 is 'Carbon credits'")
    public void validateCategoryName() {

        Response response = ServiceUtils.getCategoryResponse(CATEGORY_ID);
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info(response.prettyPeek());
        Category category = response.as(Category.class);
        Assert.assertEquals(category.getName(), CATEGORY_NAME);
    }

    @Test(description = "This test validates that for category id 6327 canRelist is true")
    public void validateCanReList() {

        Response response = ServiceUtils.getCategoryResponse(CATEGORY_ID);
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info(response.prettyPeek());
        Category category = response.as(Category.class);
        Assert.assertTrue(category.canRelist);
    }

    @Test(description = "This test finds the promotion where name is 'Gallery' and validates that it's description is 'Good position in category'")
    public void validateGalleryPromotionsText() {

        Response response = ServiceUtils.getCategoryResponse(CATEGORY_ID);
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info(response.prettyPeek());
        Category category = response.as(Category.class);
        Assert.assertTrue(!category.getPromotions().isEmpty());

        boolean isPromotionFound = false;

        for (Promotion promotion : category.getPromotions()) {
            if (promotion.getName().equals(PROMOTION_NAME)) {
                Assert.assertEquals(promotion.getDescription(), GALLERY_DESCRIPTION);
                isPromotionFound = true;
                break;
            }
        }
        if (!isPromotionFound) {
            Assert.fail();
        }
    }
}
