package org.Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageobjects.LandingPage;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
        public static void main(String[] args) throws InterruptedException {
                String productName="ZARA COAT 3";
                WebDriverManager.chromedriver().setup();
                WebDriver driver= new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                driver.get("https://rahulshettyacademy.com/client");
                LandingPage landingPage=new LandingPage(driver);
                driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("Manikantha.a@fireflink.com");
                driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Fireflink@123");
                driver.findElement(By.xpath("//input[@id='login']")).click();
                WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
                List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
//                for (WebElement e:products) {
//                        System.out.println("start");
//                        if(e.findElement(By.tagName("b")).getText().contains("productName")) {
//                                System.out.println(e.toString());
//                                driver.findElement(By.xpath("//div[@class='container']//div[1]//div[1]//div[1]//button[2]")).click();
//                                boolean display = driver.findElement(By.xpath("//div[@aria-label='Product Added To CartPage']")).isDisplayed();
//                                System.out.println(display);
//                        }
//                }
                WebElement prod = products.stream().filter(product ->
                        product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
                driver.findElement(By.xpath("//b[text()='ZARA COAT 3']/..//..//button[text()=' Add To Cart']")).click();

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
                wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
                driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

                List<WebElement> Cart = driver.findElements(By.cssSelector(".infoWrap"));
                Boolean match = Cart.stream().anyMatch(item -> item.findElement(By.tagName("h3")).getText().equals(productName));
                Assert.assertTrue(match);
                driver.findElement(By.xpath("//button[text()='Checkout']")).click();

                Actions action=new Actions(driver);
                action.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

                driver.findElement(By.xpath("(//span[contains(text(),'India')])[2]")).click();
                WebElement ele = driver.findElement(By.cssSelector(".action__submit"));
                action.scrollToElement(ele).build().perform();
                ele.click();
                String confirmMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary"))).getText();
                Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
                System.out.println("ordered placed successfully");
                driver.close();
        }
}
