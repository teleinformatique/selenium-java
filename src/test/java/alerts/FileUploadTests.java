package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testUploadFile() {
        FileUploadPage fileUploadPage = homePage.clickFileUploadLink();
        fileUploadPage.uploadFile("/Users/mac/Projects/selenium-java/resources/chromedriver");

        assertEquals(fileUploadPage.getUploadedFile(), "chromedriver", "Uploaded file incorrec");
    }
}
