package org.pageobjects;

import org.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderPage extends AbstractComponent {
    WebDriver driver;
    @FindBy(css="tr td:nth-child(3)")
    List<WebElement> productNames;

    By searchItem = By.tagName("td");
    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public Boolean verifyOrderDisplay(String productName) {
        Boolean match = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        return match;
    }

}