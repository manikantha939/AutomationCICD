package org.BrushUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
	public static void main(String[] args) {
//		WebDriverManager.chromedriver().create();
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://bstackdemo.com/");
        driver.get("https://www.amazon.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int brokenLink = 0;
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			brokenLink = verifyLink(url);

		}
		System.out.println(brokenLink);
        driver.quit();
	}

	private static int verifyLink(String url) {
		int count=0;
		try {
			URL link=new URL(url);
			HttpURLConnection httpURLConnection= (HttpURLConnection) link.openConnection();
            httpURLConnection.connect();

			if(httpURLConnection.getResponseCode()==200){
				System.out.println(link+" - "+httpURLConnection.getResponseMessage()+ " valid link");
			}else {
				System.out.println(link+" - "+httpURLConnection.getResponseMessage()+ " is a broken link");
                count++;
			}
		}catch (Exception e){
			System.out.println(e+" is a broken link");
            count++;
		}
		return count;
	}
}
