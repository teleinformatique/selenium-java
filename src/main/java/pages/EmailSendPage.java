package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSendPage {
    private WebDriver driver;
    private By confirmText = By.id("content");

    EmailSendPage(WebDriver driver){
        this.driver = driver;
    }

    public String getConfirmText(){
        return driver.findElement(confirmText).getText();
    }
}