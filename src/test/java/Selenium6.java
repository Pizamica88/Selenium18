import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium6 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wordpress.com/");

        Cookie cookie = new Cookie("wordpress_logged_in","margerkazino%7C1800042579%7CH6zmJsPZopXZDYoY83kFNuzmh4FjdPJLCVW8Xxj469v%7Cb58875e770459aff6ec256fd1d44f4642dcec90b3ed26610265af6686a37f07e");

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        Thread.sleep(4000);

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

    }
}
