package org.pageobjects;

import org.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement userEmail;
    @FindBy(xpath = "//input[@id='userPassword']")
    WebElement userPassword;
    @FindBy(xpath = "//input[@id='login']")
    WebElement login;

    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;

    @FindBy(css="[class*='toast-success']")
    WebElement successMessage;
    public ProductCatalogue loginApplication(String email, String password){
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        login.click();
        ProductCatalogue ProductCatalogue = new ProductCatalogue(driver);
        return ProductCatalogue;
    }

    public String getErrorMessage(){
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    public String getSuccessMessage() {
        waitForWebElementToAppear(successMessage);
        return successMessage.getText();
    }
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }

}
