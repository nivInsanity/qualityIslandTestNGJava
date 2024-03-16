import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class variousExercises {
    public static WebDriver driver;

    @BeforeTest
    public void startBrowser() {

        System.out.println("BeforeTest");

        //initial config
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.selenium-shop.pl/");

    }

    @AfterTest
    public void closeBrowser() {

        System.out.println("AfterTest");
        driver.quit();
    }

    @Test(priority = 2)
    public void verifyMessageAfterDoubleClickButton() {

        WebElement formMenu = driver.findElement(By.linkText("ANKIETA"));
        formMenu.click();

        WebElement doubleClickButton_ShowMessage = driver.findElement(By.xpath("//*[@value='Dwuklik pokaż komunikat']"));
        Actions builder = new Actions(driver);
        builder.doubleClick(doubleClickButton_ShowMessage).perform();

        String expectedMessage ="Doubleclick button was used";
        String actualMessage = driver.findElement(By.id("p-doubleClick")).getText();

        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test(priority = 3)
    public void verifyMessageAfterRightClick() {

        WebElement rightClickButton_ClickRight = driver.findElement(By.id("rightClick"));

        Actions builder = new Actions(driver);
        builder.contextClick(rightClickButton_ClickRight).perform();

        String expectedMessage ="Right button was used";
        String actualMessage = driver.findElement(By.id("rightClickInfo")).getText();

        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test(priority = 4)
    public void verifyMessageSurnameInput() {

        WebElement surnameInput = driver.findElement(By.id("Nazwisk"));
        surnameInput.clear();

        Actions builder = new Actions(driver);
        Action typeInCAPS = builder.keyDown(surnameInput, Keys.SHIFT)
                .sendKeys(surnameInput, "nowak")
                .keyUp(surnameInput, Keys.SHIFT)
                .build();

        typeInCAPS.perform();

        String expectedMessage ="NOWAK";

        Assert.assertEquals(surnameInput.getAttribute("value"), expectedMessage);

    }

}