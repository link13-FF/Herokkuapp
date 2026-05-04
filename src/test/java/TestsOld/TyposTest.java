package TestsOld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TyposTest {
    @Test
    public void checkAddRemoveElement() {
        SoftAssert softAssert = new SoftAssert();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");

        WebDriver driverChrome = new ChromeDriver(options);
        driverChrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driverChrome.get("https://the-internet.herokuapp.com/typos");

        for (int i = 0; i < 3; i++) {
            driverChrome.navigate().refresh();
            String text = driverChrome.findElement(By.xpath("(//p)[2]")).getText();
            softAssert.assertEquals(text, "Sometimes you'll see a typo, other times you won't.");
            System.out.println(text);
        }
        driverChrome.quit();
        softAssert.assertAll();
    }
}
