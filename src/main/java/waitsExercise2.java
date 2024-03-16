import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class waitsExercise2 {

    public static WebDriver driver;

    @Test
    public static void test() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        //Step 1
        driver.get("http://www.selenium-shop.pl/");

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,30);

        //Step 2
        String siteTitle = driver.getTitle();

        Assert.assertEquals(siteTitle, "Selenium Shop Automatyzacja Testów");

        //Step 3
        WebElement seeAllProducts = driver.findElement(By.linkText("SEE ALL PRODUCTS"));

        wait.until(ExpectedConditions.visibilityOf(seeAllProducts)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Koszulka Arsenal London')]"))).click();

        //Steps 4,5
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //button[@name='add-to-cart']"))).click();

        //Step 6
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("woocommerce-message")));

        //Step 7
        driver.close();

    }
}
