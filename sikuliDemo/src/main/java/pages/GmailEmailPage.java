package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created by Miguel Terceros on 7/20/2016.
 */
public class GmailEmailPage extends BasePageObject {

    @FindBy(xpath = "//div[@id=':2w']")
    WebElement mainTab;

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    WebElement redactarButton;

    @FindBy(xpath = "//div[@class='J-J5-Ji']/div[@class='vh']")
    WebElement sendEmailPopUp;

    @FindBy(xpath = "//a[@class='gb_b gb_8a gb_R']/span[@class='gb_3a gbii']")
    WebElement userLogo;
    @FindBy(xpath = "//div/a[@id='gb_71']")
    WebElement logoutButton;


    /**
     * This method is the constructor
     */
    public GmailEmailPage(){
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(mainTab));
    }

    public EmailFormPage clickRedactarButton(){
        redactarButton.click();
        return new EmailFormPage();
    }

    public boolean isMainTabPresent(){
        return mainTab.isDisplayed();
    }

    public boolean isSendEmailPopUpDisplayed(){
        return sendEmailPopUp.isDisplayed();
    }

    public GmailEmailPage clickUserLogo(){
        userLogo.click();
        return this;
    }

    public LoginGmailPage clickLogOutButton(){
        logoutButton.click();
        return new LoginGmailPage();
    }

    public LoginGmailPage logoutSuccessful() {
        clickUserLogo();
        return clickLogOutButton();
    }
}
