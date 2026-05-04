package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest{

    @Test
    public void checkDynamicControls() {

        dynamicControlsPage.open();
        dynamicControlsPage.clickRemove();

        Assert.assertEquals(dynamicControlsPage.waitForMessage(), "It's gone!");
        Assert.assertFalse(dynamicControlsPage.isCheckboxPresent());
        Assert.assertFalse(dynamicControlsPage.isInputEnabled());

        dynamicControlsPage.clickEnable();

        Assert.assertEquals(dynamicControlsPage.waitForMessage(),"It's enabled!");
        Assert.assertTrue(dynamicControlsPage.isInputEnabled());
    }
}
