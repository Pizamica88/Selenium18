import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak_7 {
    public static void main(String[] args) {
        //Testirati neuspesan log in

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
        passField.sendKeys("Password1235");
        WebElement btnSubmit = driver.findElement(By.id("submit"));
        btnSubmit.click();


        WebElement failedLogIn = driver.findElement(By.id("error"));
        String failedLogInText = failedLogIn.getText();
        String expectedfailedLogInText = "Your password is invalid!";
        Assert.assertEquals(failedLogInText,expectedfailedLogInText);

        String expectedFLIURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedFLIURL);

        //proveri i za text da li je pogresno username ili password
        //ako isto pise -  test pada sigurnost, ne sme da pise sta je pogresno
    }
}
