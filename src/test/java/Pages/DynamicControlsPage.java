package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicControlsPage extends BasePage {

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    private final By REMOVE_BUTTON = By.xpath("//button[text()='Remove']");
    private final By MESSAGE = By.id("message");
    private final By CHECKBOX = By.id("checkbox");
    private final By INPUT = By.xpath("//input[@type='text']");
    private final By ENABLE_BUTTON = By.xpath("//button[text()='Enable']");

    public void open() {
        driver.get(BASE_URL + "dynamic_controls");
    }
    public void clickRemove() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    public void clickEnable() {
        driver.findElement(ENABLE_BUTTON).click();
    }

    public String waitForMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE)).getText();
    }

    public boolean isCheckboxPresent() {
        return !driver.findElements(CHECKBOX).isEmpty();
    }

    public boolean isInputEnabled() {
        return driver.findElement(INPUT).isEnabled();
    }
}