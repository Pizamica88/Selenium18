package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Domaci_Zadatak_2 {
    public static void main(String[] args) throws InterruptedException {
        //https://demoqa.com/text-box napisati test case za dati text box

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");

        WebElement nameField = driver.findElement(By.id("userName"));
        String inputedName = "Jovana Markovic";
        nameField.sendKeys(inputedName);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        String inputedEmail = "margerkazino@gmail.com";
        emailField.sendKeys(inputedEmail);

        String inputedCurrAddress = "Jbr The Walk,Dubai" ;
        WebElement addressField = driver.findElement(By.id("currentAddress"));
        addressField.sendKeys(inputedCurrAddress);

        WebElement perAddressField = driver.findElement(By.id("permanentAddress"));
        String inputedPerAddress = "Nis";
        perAddressField.sendKeys(inputedPerAddress);

        //ovo sam ubacila jer og google ads nisam mogla da pridjem button-u
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        WebElement subBtn = driver.findElement(By.id("submit"));
        subBtn.click();

        WebElement outputedName = driver.findElement(By.id("name"));
        Assert.assertEquals(outputedName.getText(),"Name:"+inputedName);

        WebElement outputedEmail = driver.findElement(By.id("email"));
        Assert.assertEquals(outputedEmail.getText(),"Email:"+inputedEmail);

        List<WebElement> outputedCurrAddress = driver.findElements(By.id("currentAddress"));
        Assert.assertEquals(outputedCurrAddress.get(0).getText()+outputedCurrAddress.get(1).getText(),"Current Address :"+inputedCurrAddress);

        List<WebElement> outputedPerAddress = driver.findElements(By.id("permanentAddress"));
        Assert.assertEquals(outputedPerAddress.get(0).getText()+outputedPerAddress.get(1).getText(),"Permananet Address :"+inputedPerAddress);



    }
}
