import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak_6 {
    public static void main(String[] args) {
        //Testiranje Log Out Btn
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
        WebElement practiceLink = driver.findElement(By.id("menu-item-20"));
        practiceLink.click();

        WebElement testLoginLink = driver.findElement(By.linkText("Test Login Page"));
        testLoginLink.click();

        WebElement userField = driver.findElement(By.name("username"));
        userField.sendKeys("student");
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys("Password123");
        WebElement btnSubmit = driver.findElement(By.id("submit"));
        btnSubmit.click();

        WebElement logOutBtn = driver.findElement(By.linkText("Log out"));
        logOutBtn.click();
        String afterLogOutPageURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(),afterLogOutPageURL);

        Assert.assertNotEquals(driver.getCurrentUrl(),"https://practicetestautomation.com/logged-in-successfully/");

        WebElement btnSub = driver.findElement(By.id("submit"));
        Assert.assertTrue(btnSub.isDisplayed());


    }
}
