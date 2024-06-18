package org.pageobjects;

import org.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;
    @FindBy(css = ".infoWrap")
    List<WebElement> cartProducts;
    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkoutEle;
    By searchItem = By.tagName("h3");

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean verifyProductDisplay(String productName) {
        Boolean match = cartProducts.stream().anyMatch(product -> product.findElement(searchItem).getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckoutPage goToCheckOut() {
        checkoutEle.click();
        CheckoutPage checkoutPage=new CheckoutPage(driver);
        return checkoutPage;
    }


}
