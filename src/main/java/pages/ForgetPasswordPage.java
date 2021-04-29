package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPasswordPage {
    private WebDriver driver;
    private By emailField = By.id("email");
    private By formSubmitButton = By.id("form_submit");

    ForgetPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public EmailSendPage clickFormSubmitButton(){
        driver.findElement(formSubmitButton).click();
        return new EmailSendPage(driver);
    }
}
