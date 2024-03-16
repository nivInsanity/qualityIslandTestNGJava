import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class popularElementsExercises {

    public static WebDriver driver;

    public static void takeScreenShot(int testNumber) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("src/main/resources/" + testNumber+ "_screenshot.png"));

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }

    @Test
    public static void Exercise1() {

        //initial config
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        Actions builder = new Actions(driver);

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,30);

        //Step 1
        driver.get("http://www.selenium-shop.pl/o-nas/");

        //Step 2
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value=\"Dwuklik pokaż komunikat\"]")));
        WebElement doubleClickShowMessage =  driver.findElement(By.xpath("//*[@value=\"Dwuklik pokaż komunikat\"]"));

        builder.doubleClick(doubleClickShowMessage).perform();

        //Step 3
        WebElement doubleclickMessage = driver.findElement(By.id("p-doubleClick"));
        Assert.assertNotNull(doubleclickMessage);

        //Step 4
        WebElement clickRightButton =  driver.findElement(By.xpath("//*[@value=\"Kliknij RIGHT\"]"));

        builder.contextClick(clickRightButton).perform();

        //Step 5
        WebElement rightClickMessage = driver.findElement(By.id("rightClickInfo"));
        Assert.assertNotNull(rightClickMessage);

        //Step 6
        WebElement nameField = driver.findElement(By.id("Imię"));

        Action textShift = builder.keyDown(nameField, Keys.SHIFT).sendKeys("bartek").build();

        textShift.perform();

        //Step 7
        Assert.assertEquals(nameField.getAttribute("value"),"BARTEK");

        driver.quit();
    }

    @Test
    public static void Exercise2() {

        //initial config
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        Actions builder = new Actions(driver);

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,30);

        //Step 1
        driver.get("http://www.selenium-shop.pl/moje-konto/");

        //Step 2
        try {
            driver.findElement(By.xpath("//*[@name=\"register\"]")).click();
        }

        catch (NoSuchElementException e) {
            System.out.println("There is no button'ZAREJESTRUJ SIĘ'! Refresh site!.");
        }

        catch (ElementNotVisibleException e) {
            System.out.println("Button 'ZAREJESTRUJ SIĘ' not visible, refresh site!.");
        }

        catch (ElementNotInteractableException e) {
            System.out.println("You can't click 'ZAREJESTRUJ SIĘ', refresh site!.");
        }

        driver.quit();

    }

    @Test
    public static void specialExercise() {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        Actions builder = new Actions(driver);

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,5);

        driver.get("http://www.selenium-shop.pl/o-nas/");

        // 1 script
        //driver.switchTo().alert().accept();
        // 2 script
        //driver.findElement(By.id("ASD"));
        // 3 script
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ZXC")));
        // For 4th script I have no idea how to throw out 5 errors...
        // 5 script
        //driver.findElement(By.id("rightClickInfo")).click();

        driver.quit();
    }

    @Test
    public static void specialExercise2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        Actions builder = new Actions(driver);

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,5);

        //Step 1
        driver.get("http://www.selenium-shop.pl/");

        //Step 2
        String tytul = driver.getTitle();

        Assert.assertEquals(tytul, "Selenium Shop Automatyzacja Testów");

        //Step 3

        Thread.sleep(1000);

        takeScreenShot(3);

        //Step 4
        driver.findElement(By.linkText("SKLEP")).click();

        //Step 5
        Assert.assertEquals(driver.getTitle(), "Produkty – Selenium Shop Automatyzacja Testów");

        //Step 6
        Thread.sleep(1000);
        takeScreenShot(4);

        //Step 7

        driver.findElement(By.linkText("KOSZYK")).click();

        //Step 8

        Assert.assertEquals(driver.getTitle(), "Koszyk – Selenium Shop Automatyzacja Testów");

        //Step 9

        Thread.sleep(1000);
        takeScreenShot(5);

        driver.quit();
    }

}
