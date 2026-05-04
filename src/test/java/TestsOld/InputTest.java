package TestsOld;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class InputTest {
    @Test
    public void checkAddRemoveElement() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        WebDriver driverChrome = new ChromeDriver(options);
        driverChrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driverChrome.get("https://the-internet.herokuapp.com/inputs");

        driverChrome.findElement(By.tagName("input")).sendKeys("1234");
        Assert.assertEquals(driverChrome.findElement(By.tagName("input")).getAttribute("value"), "1234");
        System.out.println("Поле ввода содержит: " + driverChrome.findElement(By.tagName("input")).getAttribute("value"));

        driverChrome.findElement(By.tagName("input")).sendKeys("FF");
        Assert.assertEquals(driverChrome.findElement(By.tagName("input")).getAttribute("value"), "1234");
        System.out.println("Поле ввода содержит: " + driverChrome.findElement(By.tagName("input")).getAttribute("value"));

        driverChrome.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(driverChrome.findElement(By.tagName("input")).getAttribute("value"), "1233");
        System.out.println("Поле ввода содержит: " + driverChrome.findElement(By.tagName("input")).getAttribute("value"));

        driverChrome.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP, Keys.ARROW_UP);
        Assert.assertEquals(driverChrome.findElement(By.tagName("input")).getAttribute("value"), "1235");
        System.out.println("Поле ввода содержит: " + driverChrome.findElement(By.tagName("input")).getAttribute("value"));

        driverChrome.findElement(By.tagName("input")).clear();
        Assert.assertEquals(driverChrome.findElement(By.tagName("input")).getAttribute("value"), "");
        System.out.println("Поле ввода содержит: " + driverChrome.findElement(By.tagName("input")).getAttribute("value"));

        driverChrome.quit();
    }
}