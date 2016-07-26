package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.EmailFormPage;
import pages.GmailEmailPage;
import pages.LoginGmailPage;
import ui.PageTransporter;

import static org.testng.Assert.assertTrue;

/**
 * Created by Miguel Terceros on 7/20/2016.
 */
public class GmailJVM {
    private static PageTransporter pageTransporter;
    private LoginGmailPage loginGmailPage;
    private GmailEmailPage gmailEmailPage;
    private EmailFormPage emailFormPage;

    public GmailJVM(){
        pageTransporter = PageTransporter.getInstance();
    }

    @Given("^I navigate to gmail login page$")
    public void iNavigateToGmailLoginPage(){
        loginGmailPage= pageTransporter.goToLoginGmailJVM();
    }

    @And("^I login on gmail with valid credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iLoginOnGmailWithValidCredentialsAnd(String email, String password){
        gmailEmailPage = loginGmailPage.loginSuccessful(email, password);
    }

    @Then("^I should be on main email page$")
    public void iShouldBeOnMainEmailPage(){
        assertTrue(gmailEmailPage.isMainTabPresent(), "email page is displayed");
    }

    @Given("^I opened to new email form$")
    public void iOpenedToNewEmailForm(){
        emailFormPage = gmailEmailPage.clickRedactarButton();
    }

    @When("^I type new data in from field: \"([^\"]*)\"$")
    public void iTypeNewDataInFromField(String email){
        emailFormPage.setToInput(email);
    }

    @And("^I type new data in subject field: \"([^\"]*)\"$")
    public void iTypeNewDataInSubjectField(String subject){
        emailFormPage.setSubjectInput(subject);
    }

    @And("^I type new data in description field: \"([^\"]*)\"$")
    public void iTypeNewDataInDescriptionField(String description){
        emailFormPage.setDescriptionField(description);
    }

    @And("^I send a bew email$")
    public void iSendABewEmail(){
        gmailEmailPage = emailFormPage.clickSendButton();
    }

    @Then("^I should be see a popup information about the email$")
    public void iShouldBeSeeAPopupInformationAboutTheEmail(){
        assertTrue(gmailEmailPage.isSendEmailPopUpDisplayed(), "information message is displayed");
    }

}
