package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest{

    @Test
    public void FramesTest() {

        framesPage.open();
        framesPage.openIframe();

        Assert.assertEquals(framesPage.getTextFromIframe(), "Your content goes here.");
    }
}
