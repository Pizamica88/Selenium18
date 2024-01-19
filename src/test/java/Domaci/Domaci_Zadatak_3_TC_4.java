package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Domaci_Zadatak_3_TC_4 {
    public static void main(String[] args) {

        //Test Case 4
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
        WebElement practiceLink = driver.findElement(By.id("menu-item-20"));
        practiceLink.click();

        WebElement testLoginLink = driver.findElement(By.linkText("Test Login Page"));
        testLoginLink.click();

        WebElement userField = driver.findElement(By.name("username"));
        String validUsername = "student";
        userField.sendKeys(validUsername);

        String emptyPassword = "";
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys(emptyPassword);

        WebElement btnSubmit = driver.findElement(By.id("submit"));
        btnSubmit.click();

        WebElement failedLogin = driver.findElement(By.id("error"));
        String failedLoginText = failedLogin.getText();
        Assert.assertEquals(failedLoginText,"Your password is invalid!");
    }
}
