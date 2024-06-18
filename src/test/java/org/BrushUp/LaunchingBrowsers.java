package org.BrushUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchingBrowsers {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

        WebDriverManager.edgedriver().create();
		WebDriver driver1=new EdgeDriver();
		driver1.manage().window().maximize();
		driver1.get("http://www.google.com");
		driver1.navigate().refresh();
		driver1.navigate().back();
		driver1.navigate().forward();
		driver1.close();



//		driver.manage().window().maximize();
//        driver.close();
        driver.quit();

	}
}
