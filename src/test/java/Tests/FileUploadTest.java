package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest() {

        File file = new File("src/main/resources/Untitled-112.png");

        fileUploadPage.open();
        fileUploadPage.uploadFile(file.getAbsolutePath());

        Assert.assertEquals(fileUploadPage.getUploadedFileName(), file.getName());
    }
}
