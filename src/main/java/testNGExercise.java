import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGExercise {

    public static WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        System.out.println("Before Test");

        //initial config

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.selenium-shop.pl/");
        driver.findElement(By.linkText("KOSZULKA WEST HAM UNITED")).click();
    }

    @AfterTest
    public void closeBrowser() {
        System.out.println("After test");

        driver.quit();
    }

    @Test(priority = 1)
    public void firstTest() {


        Assert.assertEquals(driver.getTitle(), "Koszulka West Ham United – Selenium Shop Automatyzacja Testów");
    }

    @Test(priority = 2)
    public void secondTest() {

        WebElement productName = driver.findElement(By.xpath("//h1"));

        Assert.assertEquals(productName.getText(), "KOSZULKA WEST HAM UNITED");
    }

    @Test(priority = 3)
    public void thirdTest() {

        WebElement productPrice = driver.findElement(By.xpath("//*[@class=\"woocommerce-Price-amount amount\"]"));

        Assert.assertEquals(productPrice.getText(), "90,00 ZŁ");
    }

    @Test(priority = 4)
    public void fourthTest() {

        WebElement quantity = driver.findElement(By.xpath("//*[@title=\"Szt.\"]"));

        Assert.assertEquals(quantity.getAttribute("value"), "1");
    }

}
