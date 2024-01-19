import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak_8 {
    public static void main(String[] args) throws InterruptedException {
        //Testirati log in na wordpress stranicu

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.wordpress.com");

        WebElement logInBtn = driver.findElement(By.linkText("Log In"));
        logInBtn.click();

        WebElement emailField = driver.findElement(By.id("usernameOrEmail"));
        emailField.sendKeys("margerkazino@gmail.com");
        WebElement continueBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        continueBtn.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement passField = driver.findElement(By.cssSelector("input[type='password']"));
        passField.sendKeys("sifraZaQa");
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitBtn.click();

        //Thread.sleep(5000);
        wait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/margerkazino.wordpress.com"));
        String expectedUrl = "https://wordpress.com/home/margerkazino.wordpress.com";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);

        WebElement title = driver.findElement(By.className("formatted-header__title"));
        String expectedTitle = "My Home";
        Assert.assertEquals(title.getText(),expectedTitle);
    }
}
/*
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak8 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://www.wordpress.com/");

        WebElement logInButton = driver.findElement(By.linkText("Log In"));
        logInButton.click();

        WebElement usernameField = driver.findElement(By.id("usernameOrEmail"));
        String username = "dragoljubqa";
        usernameField.sendKeys(username);

        // button - type - submit
        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Swordfish123!@#");

        continueButton.click();

        //Thread.sleep(3000);
        wait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/dragoljubqa.wordpress.com"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://wordpress.com/home/dragoljubqa.wordpress.com");

        WebElement profileButton = driver.findElement(By.cssSelector(".gravatar.masterbar__item-me-gravatar"));
        profileButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("profile-gravatar__user-display-name"))));

        WebElement usernameTitle = driver.findElement(By.className("profile-gravatar__user-display-name"));
        String usernameText = usernameTitle.getText();

        Assert.assertEquals(usernameText, username);

    }
}
 */
