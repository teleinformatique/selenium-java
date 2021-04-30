package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private WebDriver driver;
    private By contextMenuZone = By.id("hot-spot");
    private Actions action;

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
        this.action = new Actions(driver);
    }

    public void moveToContextMenuZone(){
       // action.moveToElement(driver.findElement(contextMenuZone)).perform();
        action.contextClick(driver.findElement(contextMenuZone)).perform();
    }

    public void rightClick(){
        action.contextClick();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
        driver.switchTo().alert().
    }
}
