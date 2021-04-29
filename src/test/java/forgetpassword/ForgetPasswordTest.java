package forgetpassword;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ForgetPasswordTest extends BaseTests {

    @Test
    public void testForgetPassword(){
        var forgetPasswordPage = homePage.clickForgetPasswordLink();
        forgetPasswordPage.setEmailField("test@test.com");
        var emailSendPage = forgetPasswordPage.clickFormSubmitButton();

        assertEquals(emailSendPage.getConfirmText(),"Your e-mail's been sent!", "Incorrect message");
    }
}
