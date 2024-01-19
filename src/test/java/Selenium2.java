import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.google.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()"); //--obrati paznju na naziv skripte KOMANDA za otvaranje novo taba
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        //indexi liste 0,3,2,1, svaki novi tab on smesta desno od sebe

        driver.switchTo().window(listaTabova.get(1));
        driver.get("http://www.linkedin.com");
        driver.switchTo().window(listaTabova.get(2));
        driver.get("http://www.jobert.com");
        driver.switchTo().window(listaTabova.get(3));
        driver.get("http://www.youtube.com");

        /*
        driver.close();
        driver.switchTo().window(listaTabova.get(2));
        driver.close();
        driver.switchTo().window(listaTabova.get(1));
        driver.close();
        */
        driver.quit();
    }
}
