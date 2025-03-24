package com.api;

import com.pojo.Category;
import com.pojo.Promotion;
import io.restassured.response.Response;
import org.testng.Assert;
import com.utils.ServiceUtils;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {

    private final String categoryId = "6327";
    private final String categoryName = "Carbon credits";
    private final String promotionName = "Gallery";
    private final String galleryDescription = "Good position in category";

    @Test(description = "This test validates that category id returned is 6327")
    public void validateCategoryId() {

        Response response = ServiceUtils.getCategoryResponse(categoryId);
        Assert.assertEquals(response.getStatusCode(), RESPONSE_CODE_200);
        logger.info(response.prettyPeek());
        Category category = response.as(Category.class);
        Assert.assertEquals(category.getCategoryId(), Integer.parseInt(categoryId));
    }

    @Test(description = "This test validates that category 'name' for category id 6327 is 'Carbon credits'")
    public void validateCategoryName() {

        Response response = ServiceUtils.getCategoryResponse(categoryId);
        Assert.assertEquals(response.getStatusCode(), RESPONSE_CODE_200);
        logger.info(response.prettyPeek());
        Category category = response.as(Category.class);
        Assert.assertEquals(category.getName(), categoryName);
    }

    @Test(description = "This test validates that for category id 6327 'canRelist' is true")
    public void validateCanReList() {

        Response response = ServiceUtils.getCategoryResponse(categoryId);
        Assert.assertEquals(response.getStatusCode(), RESPONSE_CODE_200);
        logger.info(response.prettyPeek());
        Category category = response.as(Category.class);
        Assert.assertTrue(category.canRelist);
    }

    @Test(description = "This test finds the promotion where name is 'Gallery' and validates that it's description is 'Good position in category'")
    public void validateGalleryPromotionsText() {

        Response response = ServiceUtils.getCategoryResponse(categoryId);
        Assert.assertEquals(response.getStatusCode(), RESPONSE_CODE_200);
        logger.info(response.prettyPeek());
        Category category = response.as(Category.class);
        Assert.assertFalse(category.getPromotions().isEmpty());

        boolean isPromotionFound = false;

        for (Promotion promotion : category.getPromotions()) {
            if (promotion.getName().equals(promotionName)) {
                Assert.assertEquals(promotion.getDescription(), galleryDescription);
                isPromotionFound = true;
                break;
            }
        }
        if (!isPromotionFound) {
            Assert.fail();
        }
    }
}
