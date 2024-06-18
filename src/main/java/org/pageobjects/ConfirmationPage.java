package org.pageobjects;

import org.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends AbstractComponent {
    WebDriver driver;
    @FindBy(css=".hero-primary")
    WebElement confirmationMessage;
    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    public String getConfirmationMessage(){
        return confirmationMessage.getText();


    }
}
