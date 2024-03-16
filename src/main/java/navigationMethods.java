import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class navigationMethods {

    public static WebDriver driver;

    @Test
    public void nawigacja_Test() throws InterruptedException {

        //initial config
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Navigate to indicated page
        driver.navigate().to("http://www.selenium-shop.pl/");

        //Printing information about the page title and URL
        System.out.println("Tytuł strony: " + driver.getTitle());
        System.out.println("Tytuł strony: " + driver.getCurrentUrl());

        //Go to the subpage: MY ACCOUNT
        WebElement formMenu = driver.findElement(By.linkText("MOJE KONTO"));
        formMenu.click();

        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());

        //simple wait
        Thread.sleep(2000);

        //Go to previous site
        driver.navigate().back();

        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());

        Thread.sleep(2000);

        //Navigate to forward
        driver.navigate().forward();

        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());

        Thread.sleep(2000);

        //Refresh (F5 simulation)
        driver.navigate().refresh();

        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());

        Thread.sleep(2000);

        //Close browser
        driver.quit();
    }
}