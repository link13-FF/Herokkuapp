package TestsOld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddRemoveElementTest {

    @Test
    public void checkAddRemoveElement() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");

        WebDriver driverChrome = new ChromeDriver(options);
        driverChrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driverChrome.get("https://the-internet.herokuapp.com/add_remove_elements/");

        driverChrome.findElement(By.xpath("//button[text()='Add Element']")).click();
        driverChrome.findElement(By.xpath("//button[text()='Add Element']")).click();

        int size = driverChrome.findElements(By.xpath("//button[text()='Delete']")).size();
        Assert.assertEquals(size, 2);

        driverChrome.findElement(By.xpath("//button[text()='Delete']")).click();

        int size1 = driverChrome.findElements(By.xpath("//button[text()='Delete']")).size();
        Assert.assertEquals(size1, 1);

        driverChrome.quit();
    }
}
