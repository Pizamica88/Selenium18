import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak_10 {
    public static void main(String[] args) throws InterruptedException {
        //Otici na stranicu https://imgflip.com/memegenerator
//Uploadovati sliku od koje treba napraviti mim
//Mim mora biti vezan za IT, QA ili kurs
//Sliku rucno skinuti i ubaciti na Slack thread poruku
//Autor mima sa najvise lajkova dobija pivo na druzenju
//
//Napomena: Izazov zadatka je kod lokatora, assertove ne treba dodavati i ne treba raditi sa anotacijama

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://imgflip.com/memegenerator");

        String imageLocation = "C:\\Users\\PC\\OneDrive\\Desktop\\gandalf.jpg";
        WebElement buttonUpload = driver.findElement(By.id("mm-show-upload"));
        buttonUpload.click();
        Thread.sleep(3000);
        WebElement btnUpload = driver.findElement(By.id("mm-upload-file"));
        btnUpload.sendKeys(imageLocation);
        WebElement btn = driver.findElement(By.id("mm-upload-btn"));
        btn.click();

        Thread.sleep(3000);
        List<WebElement> textField = driver.findElements(By.cssSelector(".mm-text-wrap .mm-text"));

        WebElement topBox = textField.get(0);
        WebElement bottomBox = textField.get(1);
        topBox.sendKeys("You shall not pass!");
        bottomBox.sendKeys("wait.until ( Gandalf is gone );");
        WebElement generateBtn = driver.findElement(By.cssSelector(".mm-generate.b.but"));
        generateBtn.click();

        //Save image
       /* WebElement meme = driver.findElement(By.id("done-img"));
        wdwait.until(ExpectedConditions.attributeContains(meme, "src", "imgflip.com"));
        String link = meme.getAttribute("src");
        URL imageURL = new URL(link);
        BufferedImage saveImage = ImageIO.read(imageURL);
        ImageIO.write(saveImage, "png", new File("C:\\Users\\drago\\Desktop\\meme.png"));
        */
    }
}
