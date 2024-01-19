import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zadatak_11 {
    WebDriver driver;
     WebElement userField;
    WebElement passwordField;
     WebElement button;
    String validUsername, validPassword, invalidUsername, invalidPassword, loggedInURL;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        validUsername = "student";
        invalidUsername = "student1";
        validPassword = "Password123";
        invalidPassword = "password";
        loggedInURL = "https://practicetestautomation.com/logged-in-successfully/";
    }
    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://practicetestautomation.com/ ");
        WebElement practice = driver.findElement(By.id("menu-item-20"));
        practice.click();
        WebElement testLoginPAge = driver.findElement(By.linkText("Test Login Page"));
        testLoginPAge.click();

        userField = driver.findElement(By.id("username"));
        passwordField = driver.findElement(By.id("password"));
        button = driver.findElement(By.id("submit"));
    }
    @Test (priority = 10)
    public void userCanLogIn() {
        userField.clear();
        passwordField.clear();
        userField.sendKeys(validUsername);
        passwordField.sendKeys(validPassword);
        button.click();

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loggedInURL);
        WebElement profileTitle = driver.findElement(By.className("post-title"));
        Assert.assertTrue(profileTitle.isDisplayed());
    }
    @Test(priority = 20)
    public void userCannotLogInWithInvalidUsername() throws InterruptedException {
        userField.clear();
        passwordField.clear();
        userField.sendKeys(invalidUsername);
        passwordField.sendKeys(validPassword);
        button.click();

       // Thread.sleep(1000);
        WebElement error = driver.findElement(By.id("error"));
        String errorMessage = error.getText();

        Assert.assertEquals(errorMessage, "Your username is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);

    }
    @Test(priority = 30)
    public void userCannotLogInWithInvalidPassword() throws InterruptedException {
        userField.clear();
        passwordField.clear();
        userField.sendKeys(validUsername);
        passwordField.sendKeys(invalidPassword);
        button.click();

        //Thread.sleep(1000);
        WebElement error = driver.findElement(By.id("error"));
        String errorMessage = error.getText();

        Assert.assertEquals(errorMessage, "Your password is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);

    }
    @Test(priority = 40)
    public void userCannotLogInWithInvalidUsernameAndPassword() throws InterruptedException {
        userField.clear();
        passwordField.clear();
        userField.sendKeys(invalidUsername);
        passwordField.sendKeys(invalidPassword);
        button.click();

        //Thread.sleep(1000);
        WebElement error = driver.findElement(By.id("error"));
        String errorMessage = error.getText();

        Assert.assertEquals(errorMessage, "Your username is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);

    }
    @Test(priority = 50)
    public void userCannotLogInWithEmptyFields() throws InterruptedException {
        userField.clear();
        passwordField.clear();
        button.click();

        //Thread.sleep(1000);
        WebElement error = driver.findElement(By.id("error"));
        String errorMessage = error.getText();

        Assert.assertEquals(errorMessage, "Your username is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);

    }
    @Test(priority = 60)
    public void userCanLogOut() {
        userField.sendKeys(validUsername);
        passwordField.sendKeys(validPassword);
        button.click();

        WebElement logOutBtn = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutBtn.isDisplayed());
        logOutBtn.click();

        boolean isBtnPresent = false;

        try {
            WebElement logOutBtnAfterLoggingOut = driver.findElement(By.linkText("Log out"));
            isBtnPresent = logOutBtnAfterLoggingOut.isDisplayed();
        }catch (Exception e) {
            System.out.println("Poruka iz konzole"+ e+ "....KRAJ.....");
        }
        Assert.assertFalse(isBtnPresent);
    }
    @AfterClass
    public void tearDown() {
        // driver.quit stavljamo u AfterClass jer zelimo da se zatvori kada se zavrse svi testovi
        // Posto radimo u jednom browseru, kada bismo quit stavili u AfterMethod onda bi nam program pukao
        // nakon sto se prvi test zavrsi
        driver.quit();
    }



}
