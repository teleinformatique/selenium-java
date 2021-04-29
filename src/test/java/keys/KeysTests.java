package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.KeyPressPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class KeysTests extends BaseTests {
    @Test
    public void TestBackspace(){
        KeyPressPage keyPressPage = homePage.clickKeyPresses();
        keyPressPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPressPage.getResultText(),"You entered: BACK_SPACE");
    }
}
