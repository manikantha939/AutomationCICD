package org.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageobjects.CartPage;
import org.pageobjects.OrderPage;

import java.time.Duration;

public class AbstractComponent {
    WebDriver driver;
    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement cartHeader;

    @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
    WebElement orderHeader;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public void waitForWebElementToAppear(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
        Thread.sleep(1000);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.invisibilityOf(ele));
    }

    public CartPage goToCartPage() {
        cartHeader.click();
        CartPage cartPage =new CartPage(driver);
        return cartPage;
    }

    public OrderPage goToOrdersPage() {
        orderHeader.click();
        OrderPage orderPage =new OrderPage(driver);
        return orderPage;
    }

    public void scrollToElement(WebElement ele){
        Actions action=new Actions(driver);
        action.scrollToElement(ele).build().perform();
    }
}