package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AlertPage;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {
    @Test
    public void testAcceptAlert(){
        AlertPage alertPage= homePage.clickJavascriptsAlert();
        alertPage.triggerAlert();
        alertPage.alert_clickToAccept();
        assertEquals(alertPage.getResultText(),"You successfully clicked an alert");
    }

    @Test
    public void testGetTextFromAlert(){
        AlertPage alertPage = homePage.clickJavascriptsAlert();
        alertPage.triggerConfirm();
        String text = alertPage.alert_getText();
        alertPage.alert_clickToAccept();
        assertEquals(text, "I am a JS Confirm","Alert text incorrect");
    }

    @Test
    public void testSetInputInAlert(){

        var alertsPage = homePage.clickJavascriptsAlert();
        alertsPage.triggerPrompt();

        String text = "TAU rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();

        assertEquals(alertsPage.getResultText(), "You entered: " + text, "Results text incorrect");
    }
}
