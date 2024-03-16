import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class alertsExercises {

    public static WebDriver driver;

    @Test
    public void alertsTest() throws InterruptedException {

        //initial config
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        WebDriverWait wait = new WebDriverWait(driver,30);

        //Step 1
        driver.get("http://www.selenium-shop.pl/o-nas/");

        //Step 2

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("promtAlertPrzycisk")));
        driver.findElement(By.id("promtAlertPrzycisk")).click();

        //Step 3
        driver.switchTo().alert().sendKeys("QWERTY");
        driver.switchTo().alert().accept();

        //Step 4
        driver.findElement(By.id("confimationAlertPrzycisk")).click();
        System.out.println("Alert content:\n" + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //Step 5
        driver.quit();

    }
}
