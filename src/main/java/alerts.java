import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class alerts {

    public static WebDriver driver;

    @Test
    public void alerts_Test() throws InterruptedException {

        //initial config
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");


        //Step 1
        WebElement formMenu = driver.findElement(By.linkText("ANKIETA"));
        formMenu.click();

        //Step 2
        WebElement alertButton = driver.findElement(By.id("alertPrzycisk"));
        alertButton.click();

        Thread.sleep(2000);

        //Step 3
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        //Step 4
        WebElement promptAlertButton = driver.findElement(By.id("promtAlertPrzycisk"));
        promptAlertButton.click();

        Thread.sleep(2000);

        //Step 5
        driver.switchTo().alert().sendKeys("Warszawa");


        Thread.sleep(2000);


        //Step 6
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        //Step 7
        WebElement confimationAlertButton = driver.findElement(By.id("confimationAlertPrzycisk"));
        confimationAlertButton.click();

        Thread.sleep(2000);

        //Step 8
        System.out.println("Komunikat z okna Alert: " +  driver.switchTo().alert().getText());

        //Step 9
        driver.switchTo().alert().dismiss();

        driver.quit();

    }
}