package TestsOld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckboxesTest {
    @Test
    public void checkAddRemoveElement() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        WebDriver driverChrome = new ChromeDriver(options);
        driverChrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driverChrome.get("https://the-internet.herokuapp.com/checkboxes");

        boolean isCheck = driverChrome.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        Assert.assertFalse(isCheck);

        driverChrome.findElements(By.cssSelector("[type=checkbox]")).get(0).click();

        isCheck = driverChrome.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        Assert.assertTrue(isCheck);

        boolean isCheck2 = driverChrome.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        Assert.assertTrue(isCheck2);

        driverChrome.findElements(By.cssSelector("[type=checkbox]")).get(1).click();

        isCheck2 = driverChrome.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        Assert.assertFalse(isCheck2);

        driverChrome.quit();
    }
}