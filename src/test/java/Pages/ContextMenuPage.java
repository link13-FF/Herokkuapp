package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContextMenuPage extends BasePage {

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    private final By CONTEXT_WINDOW = By.id("hot-spot");

    public void open() {
        driver.get(BASE_URL + "context_menu");
    }

    public void rightClick() {
        actions.contextClick(driver.findElement(CONTEXT_WINDOW)).perform();
    }

    public String alertText(){
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }


}
