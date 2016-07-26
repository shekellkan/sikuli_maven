package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by Miguel Terceros on 7/20/2016.
 */
public class EmailFormPage extends BasePageObject {

    @FindBy(xpath = "//h2[@class='a3E']/div[@class='a3I']")
    WebElement newEmailLabel;

    @FindBy(xpath = "//div[@id=':a8']")
    WebElement toInput;
    @FindBy(xpath = "//div[@id=':9z']/input[@id=':9y']")
    WebElement subjectInput;
    @FindBy(xpath = "//div[@id=':b8']/div[@id=':b3']")
    WebElement descriptionField;
    @FindBy(xpath = "//div[@id=':7n']/div[@id=':9o']")
    WebElement sendButton;

    /**
     * This method is the constructor
     */
    public EmailFormPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newEmailLabel));
    }

    public EmailFormPage setToInput(String email){
        toInput.click();
        toInput.clear();
        toInput.sendKeys(email);
        return this;
    }

    public EmailFormPage setSubjectInput(String subject){
        subjectInput.click();
        subjectInput.clear();
        subjectInput.sendKeys(subject);
        return this;
    }

    public EmailFormPage setDescriptionField(String description){
        descriptionField.click();
        descriptionField.clear();
        descriptionField.sendKeys(description);
        return this;
    }

    public GmailEmailPage clickSendButton(){
        sendButton.click();
        return new GmailEmailPage();
    }

    public GmailEmailPage sendNewEmailSuccessful(String email, String subject, String description){
        setToInput(email);
        setSubjectInput(subject);
        setDescriptionField(description);
        return clickSendButton();
    }
}
