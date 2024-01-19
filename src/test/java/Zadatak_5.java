import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Zadatak_5 {
    public static void main(String[] args) {
        // Testirati log in stranice https://practicetestautomation.com/

        //WebElement element = driver.findElement(By.cssSelector("tag[attribute='value']"));

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
        WebElement practiceLink = driver.findElement(By.id("menu-item-20"));
        practiceLink.click();

       // List<WebElement> testLoginPage = driver.findElements(By.cssSelector(".wp-block-column.is-layout-flow.wp-block-column-is-layout-flow p a"));
        //testLoginPage.get(0).click();
//        WebElement testLoginPage = driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a"));
//        testLoginPage.click();
        WebElement testLoginLink = driver.findElement(By.linkText("Test Login Page"));
        testLoginLink.click();

        WebElement userField = driver.findElement(By.name("username"));
        userField.sendKeys("student");
        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys("Password123");
        WebElement btnSubmit = driver.findElement(By.id("submit"));
        btnSubmit.click();

        //Asertovanje
        WebElement loginPage = driver.findElement(By.className("post-title"));
        String loginPageTitle = loginPage.getText();
        String expectedLoginPageTitle = "Logged In Successfully";
        Assert.assertEquals(loginPageTitle,expectedLoginPageTitle);

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);

        WebElement logOutBtn = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutBtn.isDisplayed());

        //proveri i za text ispod logged in successfully i da li pise koji je user


        ///ZADATAK 6
        //Testiranje Log Out Btn
//        logOutBtn.click();
//        String afterLogOutPageURL = "https://practicetestautomation.com/practice-test-login/";
//        Assert.assertEquals(driver.getCurrentUrl(),afterLogOutPageURL);

//        WebElement headlineAfterLogOut = driver.findElement(By.id("login"));
//        String headlineAfterLogOutText = headlineAfterLogOut.getText();
//        String expectedHeadline = "Test login";
//        Assert.assertEquals(headlineAfterLogOutText,expectedHeadline);

        ///ZADATAK 7
        //Testirati neuspesan log in
//        WebElement userField2 = driver.findElement(By.id("username"));
//        WebElement passField2 = driver.findElement(By.id("password"));
//        WebElement btnSub2 = driver.findElement(By.id("submit"));
//        userField2.sendKeys("student");
//        passField2.sendKeys("jovana");
//        btnSub2.click();
//
//        WebElement failedLogIn = driver.findElement(By.id("error"));
//        String failedLogInText = failedLogIn.getText();
//        String expectedfailedLogInText = "Your password is invalid!";
//        Assert.assertEquals(failedLogInText,expectedfailedLogInText);
//
//        String expectedFLIURL = "https://practicetestautomation.com/practice-test-login/";
//        Assert.assertEquals(driver.getCurrentUrl(),expectedFLIURL);
    }
}
