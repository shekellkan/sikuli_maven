package ui.common;
import org.sikuli.script.FindFailed;
import pages.GmailEmailPage;
import pages.GmailPage;
import ui.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import ui.PageTransporter;

/**
 * User: Miguel Terceros
 * Date: 15/04/16
 */
public class CommonMethods {
    private static PageTransporter pageTransporter = PageTransporter.getInstance();

    public static void doubleClick(WebElement webElement) {
        Actions action = new Actions(DriverManager.getInstance().getWebDriver());
        action.doubleClick(webElement);
        action.perform();
    }

    /**
     * this method refresh the page
     * usually used after make changes with the API
     */
    public static void refresh() {
        WebDriver driver = DriverManager.getInstance().getWebDriver();
        driver.navigate().refresh();
    }

    public static void logoutFromEmailPage() {
        GmailEmailPage gmailEmailPage = new GmailEmailPage();
        gmailEmailPage.logoutSuccessful();
    }

    public static void logoutFromEmailSikuliPage() throws FindFailed {
        GmailPage gmailPage = new GmailPage();
        gmailPage.logoutSuccessful();
    }
}