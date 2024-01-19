import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.Keys.ENTER;

public class Selenium3 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com/");

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea"))
                .sendKeys("ITBootcamp");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea")).sendKeys(ENTER);

        driver.findElement(By.xpath("/html/body/div[5]/div/div[10]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/div/span/a/h3")).click();

        /*
        Flaky testovi su oni testovi koji po svom kodu nisu stabilni. Odnosno desi se da nekada prodju,
        a nekada ne prodju testovi i onda ako dobijete informaciju da je neki test pao ne mozete da znate
        da li je zaista zbog buga ili do testa
         */


    }
}
