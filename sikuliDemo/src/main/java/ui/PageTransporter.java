package ui;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import pages.GmailPage;
import pages.LoginGmailPage;

public class PageTransporter {
    private static WebDriver driver;
    private static PageTransporter instance;
    private PageTransporter()
    {
        driver = DriverManager.getInstance().getWebDriver();
    }

    public static PageTransporter getInstance()
    {
        if(instance==null)
        {
            instance = new PageTransporter();
        }
        return instance;
    }

    private static void goToURL(String url) {
        driver.navigate().to(url);
    }

    public GmailPage goToLoginGmail() throws FindFailed {
        goToURL("http://gmail.com");
        return new GmailPage();
    }

    public LoginGmailPage goToLoginGmailJVM() {
        goToURL("http://gmail.com");
        return new LoginGmailPage();
    }
}
