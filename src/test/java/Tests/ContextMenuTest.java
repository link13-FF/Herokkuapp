package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest{
    @Test
    public void contextMenuPage() {

        contextMenuPage.open();
        contextMenuPage.rightClick();

        Assert.assertEquals(contextMenuPage.alertText(), "You selected a context menu");
    }
}
