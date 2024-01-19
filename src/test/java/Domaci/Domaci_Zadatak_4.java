package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Domaci_Zadatak_4 {
    public static void main(String[] args) {
       /* Koristeci Anotacije - Ulogujte se na demoqa(https://demoqa.com/ -> Book Store Application)
       preko cookies-a, dodati dve knjige na svoj nalog, zatim se izlogovati brisanjem cookies-a.
        Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu */

        //sifra J12345m%!
        //usernameJokaM
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 700);");
        List<WebElement > bookApp = driver.findElements(By.className("card-body"));
        bookApp.get(5).click();
//        String username = "JokaM";
//        String password = "J12345m%!";
//        WebElement loginBtn = driver.findElement(By.id("login"));
//        loginBtn.click();
//        WebElement usernameField = driver.findElement(By.id("userName"));
//        WebElement passField = driver.findElement(By.id("password"));
//        usernameField.sendKeys(username);
//        passField.sendKeys(password);
//        WebElement logInBtn2 = driver.findElement(By.id("login"));
//        logInBtn2.click();

        Cookie cookie = new Cookie("panoramaId_expiry","1705775490401");
        Cookie cookie1 = new Cookie("_cc_id","a44b757eb5662180046a67836454381d");
        //Cookie cookie2 = new Cookie("userID","53e3ffb9-7942-44ba-ae14-7c755decc7e5");
        //Cookie cookie3 = new Cookie("userName","JokaM");
        driver.manage().addCookie(cookie);
        driver.manage().addCookie(cookie1);
//        driver.manage().addCookie(cookie2);
//        driver.manage().addCookie(cookie3);

        driver.navigate().refresh();
    }
}
