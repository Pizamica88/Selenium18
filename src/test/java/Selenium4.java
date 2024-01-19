import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.Keys.ENTER;

public class Selenium4 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        //za drugi browser
       // WebDriverManager.safaridriver()//firefoxdriver()//edgedriver()
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

//        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea")).sendKeys("facebook");
//        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea")).sendKeys(ENTER);
//        driver.navigate().back();
//        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea")).sendKeys("wikipedia");
//        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea")).sendKeys(ENTER);

        WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea"));
        searchBox.sendKeys("ITBootcamp");
        searchBox.sendKeys(ENTER);
        driver.navigate().back();
        searchBox.sendKeys("Wikipedia");
        searchBox.sendKeys(ENTER);

        //LOKATORI - SELEKTORI
        //1. ID - Prvi po hijerarhiji, u idealnoj situaciji je jedinstven(ne mora biti jedinstven - greska developera)
        //najstabilniki
        WebElement searchBoxID = driver.findElement(By.id("APjFqb"));
        //2. Name
        WebElement searchBoxName = driver.findElement(By.name("q"));
        //3. Class - dobar za testiranje vise stvari odjenom (checkBox obicno lista divova)
        WebElement searchBoxClass = driver.findElement(By.className("glFyf"));
        //4. CSS selector
        WebElement searcBoxCSS = driver.findElement(By.cssSelector("textarea[type='search']"));
        // sledeci primer koristimo samo u slucajevima kada postoji razmak unutar klase
       // WebElement searcBoxCSS1 = driver.findElement(By.className("search box google"));
        //WebElement fakeCSS = driver.findElement(By.cssSelector("search.box.google"));
        //5. Relative Xpath - konkretan element u divu
        WebElement searchBoxRelativeXPath = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        //6. Absolute Xpath - otvara sve redom divove, nije sigurno//ok je koristiti na brzinu u pocetku, ali posle treba promeniti lokator
        //        WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea"));
    }
}
