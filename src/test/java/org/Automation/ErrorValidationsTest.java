package org.Automation;

import org.TestComponenets.BaseTest;
import org.openqa.selenium.WebElement;
import org.pageobjects.CartPage;
import org.pageobjects.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ErrorValidationsTest extends BaseTest {
    @Test(groups = {"Error Handling"})
    public void LoginErrorValidation() {
        landingPage.loginApplication("Manikantha.a@fireflink11.com", "Fireflink@1234");
        Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
    }

    @Test
    public void LoginSuccessValidation() {
        landingPage.loginApplication("porago7946@lendfash.com", "Password@123");
        Assert.assertEquals("Login Successfully",landingPage.getSuccessMessage());
    }

    @Test
    public void ProductErrorValidation() throws IOException, InterruptedException {
        String productName = "ZARA COAT 3";
        ProductCatalogue ProductCatalogue = landingPage.loginApplication("Manikantha.a@fireflink.com", "Fireflink@123");
        List<WebElement> products = ProductCatalogue.getProductList();
        ProductCatalogue.addProductToCart(productName);
        CartPage cartPage = ProductCatalogue.goToCartPage();

        Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);
    }
}
