package pages;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/**
 * Created by Miguel Terceros on 7/18/2016.
 */

public class GmailPage {
    Screen screen;
    String imagesPath = "src/main/resources/images/";

    Pattern googleLogo = new Pattern(imagesPath + "google.png");
    Pattern emaildField = new Pattern(imagesPath + "email.png");
    Pattern nextButton = new Pattern(imagesPath + "next.png");

    Pattern notCheckbox = new Pattern(imagesPath + "not.png");
    Pattern passwordField = new Pattern(imagesPath + "password.png");
    Pattern loginButton = new Pattern(imagesPath + "login.png");

    Pattern mainPage = new Pattern(imagesPath + "main.png");
    Pattern newEmailButton = new Pattern(imagesPath + "newEmail.png");

    Pattern userLogoButton = new Pattern(imagesPath + "userLogo.png");
    Pattern logoutPopup = new Pattern(imagesPath + "logoutpopup.png");
    Pattern logoutButton = new Pattern(imagesPath + "logout.png");

    public GmailPage() throws FindFailed {
        screen = new Screen();
//        screen.wait(googleLogo);
    }

    public void setEmailField(String email) throws FindFailed {
        screen.type(emaildField, email);
        screen.click(nextButton);
    }

    public void setPasswordField(String password) throws FindFailed {
        screen.click(notCheckbox);
        screen.type(passwordField, password);
    }

    public void loginSuccessful(String email, String password) throws FindFailed {
        setEmailField(email);
        setPasswordField(password);
        screen.click(loginButton);
        screen.wait(mainPage, 10);
    }

    public boolean isMainPage() {
        if(screen.exists(mainPage) != null) {
            System.out.println(screen.exists(mainPage));
            return true;
        }
        return false;
    }

    public EmailForm clickNewEmailButton() throws FindFailed {
        screen.click(newEmailButton);
        return new EmailForm();
    }

    public void logoutSuccessful() throws FindFailed {
        screen.click(userLogoButton);
        screen.wait(logoutPopup);
        screen.click(logoutButton);
        screen.wait(googleLogo, 5);
    }

    public GmailEmailPage loginSuccessfulJVM(String email, String password) throws FindFailed {
        setEmailField(email);
        setPasswordField(password);
        screen.click(loginButton);
        screen.wait(mainPage, 10);
        return new GmailEmailPage();
    }
}
