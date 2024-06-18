package org.Automation;

import org.TestComponenets.BaseTest;
import org.openqa.selenium.WebElement;
import org.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class submitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";

    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
        ProductCatalogue ProductCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
        List<WebElement> products = ProductCatalogue.getProductList();
        ProductCatalogue.addProductToCart(input.get(productName));
        CartPage cartPage = ProductCatalogue.goToCartPage();

        Boolean match = cartPage.verifyProductDisplay(input.get(productName));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckOut();
        checkoutPage.selectCountry("India");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        System.out.println("ordered placed successfully");
    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void OrderHistorytest() {
        ProductCatalogue ProductCatalogue = landingPage.loginApplication("Manikantha.a@fireflink.com", "Fireflink@123");
        OrderPage orderPage = ProductCatalogue.goToOrdersPage();
        Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
    }

    @DataProvider
    public Object[][] getData() {
        HashMap<String,String> map=new HashMap<>();
        map.put("email","Manikantha.a@fireflink.com");
        map.put("password","Fireflink@123");
        map.put("productName","ZARA COAT 3");
        HashMap<String,String> map1=new HashMap<>();
        map1.put("email","porago7946@lendfash.com");
        map1.put("password","Password@123");
        map1.put("productName","ADIDAS ORIGINAL");
        return new Object[][]{{map}, {map1}};
    }

//    @DataProvider
//    public Object[][] getData(){
//        Object object = new Object[][]{{"Manikantha.a@fireflink.com", "Fireflink@123", "ZARA COAT 3"}, {"porago7946@lendfash.com", "Password@123", "ADIDAS ORIGINAL"}};
//        return object;
//    }
}