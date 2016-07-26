package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.sikuli.script.FindFailed;
import pages.EmailForm;
import pages.GmailPage;
import ui.PageTransporter;
import static org.testng.Assert.assertTrue;


/**
 * Created by Miguel Terceros on 7/18/2016.
 */
public class GmailSteps {
    private static PageTransporter pageTransporter;
    private GmailPage gmailPage;
    private EmailForm emailForm;

    public GmailSteps(){
        pageTransporter = PageTransporter.getInstance();
    }

    /************************** GIVEN ***************************/
    @Given("^I navigate to gmail page$")
    public void iNavigateToGmailPage() throws FindFailed {
        gmailPage = pageTransporter.goToLoginGmail();
    }

    @Given("^I enable to new email form$")
    public void iEnableToNewEmailForm() throws FindFailed {
        emailForm = gmailPage.clickNewEmailButton();
    }

    /************************** WHEN ***************************/
    @When("^I enter new data in from field: \"([^\"]*)\"$")
    public void iEnterNewDataInFromField(String email) throws FindFailed {
        emailForm.setFromField(email);
    }


    /************************** THEN ***************************/
    @Then("^I should be on main gmail page$")
    public void iShouldBeOnMainGmailPage() throws FindFailed {
        assertTrue(gmailPage.isMainPage(), "Main Page of gmail");
    }

    @Then("^I should be see a popup information$")
    public void iShouldBeSeeAPopupInformation() throws FindFailed {
        assertTrue(emailForm.isEmailSending(), "the email is sending");
    }


    /************************** AND ***************************/
    @And("^I login on gmail with the credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iLoginOnGmailWithTheCredentialsAnd(String userName, String password) throws FindFailed {
        gmailPage.loginSuccessful(userName, password);
    }

    @And("^I enter new data in subject field: \"([^\"]*)\"$")
    public void iEnterNewDataInSubjectField(String subject) throws FindFailed {
        emailForm.setSubjectField(subject);
    }

    @And("^I enter new data in description field: \"([^\"]*)\"$")
    public void iEnterNewDataInDescriptionField(String description) throws FindFailed {
        emailForm.setDescriptionField(description);
    }

    @And("^I send the email$")
    public void iSendTheEmail() throws FindFailed {
        gmailPage = emailForm.sendEmail();
    }

}
