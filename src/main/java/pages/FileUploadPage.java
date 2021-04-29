package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class FileUploadPage {
    private WebDriver driver;
    private By fileuploadField = By.id("file-upload");
    private By filesubmitButton = By.id("file-submit");
    private By uploadedfiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickFileSubmitButton(){
        driver.findElement(filesubmitButton).click();
    }

    public void uploadFile(String absolutePath){
        driver.findElement(fileuploadField).sendKeys(absolutePath);
        clickFileSubmitButton();
    }

    public String getUploadedFile(){
        WebElement uploadedFile = driver.findElement(uploadedfiles);
        return uploadedFile.getText();
    }

}
