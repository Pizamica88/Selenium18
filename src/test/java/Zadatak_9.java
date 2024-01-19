import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Zadatak_9 {
    public static void main(String[] args) throws InterruptedException {
        /*Zadatak 9
https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2
Testirati dodavanje knjige u korpu i da li se knjiga obrise kada obrisete kolacice*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");
        Thread.sleep(10000);

        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        addToCart.click();

        Thread.sleep(3000);
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        List<WebElement> cart= driver.findElements(By.id("nav-cart-count"));
        int expected = 1;
        Assert.assertEquals(cart.size(),expected);

        WebElement text = driver.findElement(By.cssSelector(".a-size-medium-plus,a-color-base.sw-atc-text.a-text-bold"));
        String expectedText = "Added to Cart";
        Assert.assertEquals(text.getText(),expectedText);


    }
}
