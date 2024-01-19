import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class Zadatak_4 {
    public static void main(String[] args) {
        /* //Otici na Google
        ////Zatim ukucati "Wikipedia" u polje za pretragu
        ////Odraditi pretragu i otvoriti stranicu
        ////Na stranici Wikipedia pretraziti "Nikola Tesla" */

        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("wikipedia");
//        WebElement searchBoxBtn = driver.findElement(By.name("btnK"));
//        searchBoxBtn.click();
        //treba testirati klik, jer tako se testiraju dva polja
        //ukoliko prva opcija za nalazenje dugmeta ne radi, onda raditi ovu sa listama u slucaju da postoji vise dugmeta
        List<WebElement> searchButton = driver.findElements(By.name("btnK"));
        searchButton.get(0).click();

        WebElement wikiBtn = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        wikiBtn.click();

        WebElement wikiSearch = driver.findElement(By.id("searchInput"));
        wikiSearch.sendKeys("Nikola Tesla");
       // WebElement wikiSearchBtn = driver.findElement(By.cssSelector(".sprite.svg-search-icon"));
       // wikiSearchBtn.click();
        WebElement wikipediaButton = driver.findElement(By.cssSelector("button[type='submit']"));
        wikipediaButton.click();

        /*
        Kako pravite custom CSS selektor:
WebElement element = driver.findElement(By.cssSelector("tag[attribute='value']"));
Ako je ovo u DOM-u
<button class="pure-button pure-button-primary-progressive" type="submit">
<i class="sprite svg-search-icon" data-jsl10n="search-input-button">Search</i>
</button>
Lokator bi bio:
WebElement wikipediaButton = driver.findElement(By.cssSelector("button[type='submit']"));
         */
        //za proveru
        String expectedURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";
        //prvo stavljamo actual pa , pa expected
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
        //String expectedZaPAd =  "https://en.wikipedia.org/wiki/Nikola_Tesla1";
        //Assert.assertNotEquals(driver.getCurrentUrl(),expectedZaPAd);

        WebElement pageTitle = driver.findElement(By.className("mw-page-title-main"));
        String actualPageText = pageTitle.getText();
        //WebElement actualPageText = driver.findElement(By.className("mw-page-title-main")).getText();
        String expectedTitle = "Nikola Tesla";
        Assert.assertEquals(actualPageText,expectedTitle);

        WebElement pageImage = driver.findElement(By.className("infobox-image"));
        Assert.assertTrue(pageImage.isDisplayed());
    }
}
