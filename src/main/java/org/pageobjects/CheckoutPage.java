package org.pageobjects;

import org.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponent {
    WebDriver driver;
    //    String country="India";
    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement country;
    @FindBy(xpath = "(//span[contains(text(),'India')])[2]")
    WebElement selectCountry;
    @FindBy(css = ".action__submit")
    WebElement submit;
    By results = By.cssSelector(".ta-results");

    public void selectCountry(String countryName) {
        Actions action = new Actions(driver);
        action.sendKeys(country, countryName).build().perform();
        waitForElementToAppear(results);
        selectCountry.click();
    }


    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public ConfirmationPage submitOrder() {
        scrollToElement(submit);
        submit.click();
        return new ConfirmationPage(driver);
    }

}
