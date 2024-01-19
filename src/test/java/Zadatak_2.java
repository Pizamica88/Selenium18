import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak_2 {
    public static void main(String[] args) {
        //Otvoriti browser i jos 5 tabova
//Na svakom tabu otvoriti URL po zelji
//Zatvoriti sve tabove osim onog gde je otvoren Google

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.linkedin.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.open()");
//        js.executeScript("window.open()");
//        js.executeScript("window.open()");
//        js.executeScript("window.open()");
//        js.executeScript("window.open()");
        for (int i=0;i<5;i++) {
            js.executeScript("window.open()");
        }

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(listaTabova.get(1));
        driver.get("http://www.facebook.com/");
        driver.switchTo().window(listaTabova.get(2));
        driver.get("http://www.google.com/");
        driver.switchTo().window(listaTabova.get(3));
        driver.get("http://www.itbootcamp.rs/");
        driver.switchTo().window(listaTabova.get(4));
        driver.get("http://www.infostud.com/");
        driver.switchTo().window(listaTabova.get(5));
        driver.get("http://www.youtube.com/");

//        driver.close();
//        driver.switchTo().window(listaTabova.get(0));
//        driver.close();
//        driver.switchTo().window(listaTabova.get(1));
//        driver.close();
//        driver.switchTo().window(listaTabova.get(3));
//        driver.close();
//        driver.switchTo().window(listaTabova.get(4));
//        driver.close();

        for (int i =0;i< listaTabova.size();i++) {
            driver.switchTo().window(listaTabova.get(i));
            if (!driver.getCurrentUrl().equals("https://www.google.com/")) {
                driver.close();
            }
        }
                System.out.println(driver.getCurrentUrl());
    }
}
