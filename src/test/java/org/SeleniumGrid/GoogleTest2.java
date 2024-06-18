package org.SeleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class GoogleTest2 {
    @Test
    public void HomePageCheck() throws MalformedURLException, URISyntaxException {
//        WebDriverManager.chromedriver().create();
//        WebDriver driver=new ChromeDriver();
//        driver.get("http://www.google.com");
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.WINDOWS);
        desiredCapabilities.setBrowserName("firefox");
//        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//        desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN10);
        WebDriver driver=new RemoteWebDriver(new URI("http://192.168.175.72:4444").toURL(), desiredCapabilities);
        driver.get("http://ww1.rahulshetty.com/");
        System.out.println(driver.getTitle());
        driver.close();
    }
}
