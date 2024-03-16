import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

    public static WebDriver driver;

    @Test
    public static void test() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("http://www.selenium-shop.pl/");

        driver.manage().window().maximize();

        System.out.println("Title: " + driver.getTitle());

        Assert.assertEquals(driver.getTitle(), "Selenium Shop Automatyzacja Testów");

        driver.close();
    }

}
