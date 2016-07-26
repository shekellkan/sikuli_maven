package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by Miguel Terceros on 7/20/2016.
 */
public class LoginGmailPage extends BasePageObject {


    @FindBy(xpath = "//div[@class='logo logo-w']")
    WebElement googleLogo;

    @FindBy(xpath = "//input[@id='Email']")
    @CacheLookup
    WebElement emailInput;

    @FindBy(xpath = "//input[@id='next']")
    WebElement nextButton;

    @FindBy(xpath = "//p[@id='profile-name']")
    WebElement emailNameLabel;

    @FindBy(xpath = "//input[@id='Passwd']")
    @CacheLookup
    WebElement passwordInput;

    @FindBy(xpath = "//input[@id='signIn']")
    WebElement signinButton;

    /**
     * This method is the constructor
     */
    public LoginGmailPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(googleLogo));
    }

    public LoginGmailPage setEmailInput(String email){
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public LoginGmailPage clickNextButton(){
        nextButton.click();
        return  this;
    }

    public LoginGmailPage setPasswordInput(String password){
        wait.until(ExpectedConditions.visibilityOf(emailNameLabel));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public GmailEmailPage clickSignInButton(){
        signinButton.click();
        return new GmailEmailPage();
    }

    public GmailEmailPage loginSuccessful(String email, String password){
        setEmailInput(email);
        clickNextButton();
        setPasswordInput(password);
        return clickSignInButton();
    }


}
