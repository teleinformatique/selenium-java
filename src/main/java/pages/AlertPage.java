package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {
    private final WebDriver driver;
    private By triggerAlertButton = By.xpath("/html/body/div[2]/div/div/ul/li[1]/button");
    private By resultText = By.id("result");
    private By triggerConfirmButton = By.xpath("/html/body/div[2]/div/div/ul/li[2]/button");
    private By triggerPromptButton = By.xpath("/html/body/div[2]/div/div/ul/li[3]/button");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public void triggerAlert(){
        driver.findElement(triggerAlertButton).click();
    }

    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }

    public String getResultText(){
        return driver.findElement(resultText).getText();
    }

    public void triggerConfirm(){
        driver.findElement(triggerConfirmButton).click();
    }

    public void alert_clickToDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    public void triggerPrompt(){
        driver.findElement(triggerPromptButton).click();
    }

    public void alert_setInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }
}
