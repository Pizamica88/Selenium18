package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Domaci_Zadatak_3_TC_1 {
    public static void main(String[] args) {
        //Napisati 5 negativnih log-in test case-eva za dati sajt : https://practicetestautomation.com/

        //Test Case 1
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
        WebElement practiceLink = driver.findElement(By.id("menu-item-20"));
        practiceLink.click();

        WebElement testLoginLink = driver.findElement(By.linkText("Test Login Page"));
        testLoginLink.click();

        WebElement userField = driver.findElement(By.name("username"));
        String invalidUsername = "Jovana";
        String validPassword = "password123";
        userField.sendKeys(invalidUsername);
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys(validPassword);
        WebElement btnSubmit = driver.findElement(By.id("submit"));
        btnSubmit.click();

        WebElement failedLogin = driver.findElement(By.id("error"));
        String failedLoginText = failedLogin.getText();
        Assert.assertEquals(failedLoginText,"Your username is invalid!");
    }
}
