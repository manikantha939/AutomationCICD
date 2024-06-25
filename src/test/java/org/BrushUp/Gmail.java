package org.BrushUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail {
    public static void main(String[] args) {
        String word="hello hi bye";
        char []c=word.toCharArray();
        for (int i=word.length()-1;i>=0;i--){
            System.out.print(c[i]);
        }
//        WebDriverManager.chromedriver().create();
//        WebDriver driver=new ChromeDriver();
//
//        driver.get("https://mail.google.com/mail/u/0/#inbox");
//        driver.findElement(By.id("identifierId")).sendKeys("manikanthaambig66@gmail.com");
//        driver.findElement(By.xpath("//span[text()='Next']")).click();
//        driver.close();
    }
}
