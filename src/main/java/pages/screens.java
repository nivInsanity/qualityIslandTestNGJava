package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class screens {

    public static WebDriver driver;



    @BeforeTest
    public void startBrowser() {
        System.out.println("BeforeTest");

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://www.selenium-shop.pl/");

        driver.manage().window().maximize();

    }

    @AfterTest
    public void closeBrowser() {
        System.out.println("AfterTest");
        driver.quit();
    }


    public void takeScreenShot(int testNumber) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("src/main/resources/" + testNumber+ "_screenshot.png"));

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }

    //Step 1
    @Test (priority = 1)
    public void verifyValueNameInput() {
        System.out.println("Test 2");
        WebElement formMenu = driver.findElement(By.linkText("ANKIETA"));
        formMenu.click();

        WebElement nameInput = driver.findElement(By.id("Imię"));
        nameInput.clear();
        nameInput.sendKeys("Adam");

        Assert.assertEquals(nameInput.getAttribute("value"), "Adam", "A different value than expected was entered in the field. " +
                "We expected the value 'Adam' and the actual value is:" + nameInput.getAttribute("value"));

        takeScreenShot(1);

    }

    //Krok 2
    @Test(priority = 2)
    public void verifyValueNazwiskoInput() {
        System.out.println("Test 2");
        WebElement surnameInput = driver.findElement(By.id("Nazwisk"));
        surnameInput.clear();
        surnameInput.sendKeys("Nowak");

        Assert.assertEquals(surnameInput.getAttribute("value"), "Nowak");

        takeScreenShot(2);
    }
}