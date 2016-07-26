package pages;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class EmailForm
{
    private Screen screen;
    private String imagesPath = "src/main/resources/images/";

    Pattern formNewEmail = new Pattern(imagesPath + "popupEmail.png");
    Pattern fromField = new Pattern(imagesPath + "from.png");
    Pattern subjectField = new Pattern(imagesPath + "asunto.png");
    Pattern descriptionField = new Pattern(imagesPath + "description.png");
    Pattern sendButton = new Pattern(imagesPath + "send.png");
    Pattern verificationPopup = new Pattern(imagesPath + "verification.png");

    public EmailForm() throws FindFailed {
        screen = new Screen();
        screen.wait(formNewEmail, 5);
    }

    public void setFromField(String email) throws FindFailed {
        screen.type(fromField, email + Key.TAB);
    }

    public void setSubjectField(String subject) throws FindFailed {
        screen.type(subjectField, subject);
    }

    public void setDescriptionField(String description) throws FindFailed {
        screen.type(descriptionField, description);
    }

    public void sendNewEmail(String email, String subject, String description) throws FindFailed {
        setFromField(email);
        setSubjectField(subject);
        setDescriptionField(description);
        screen.click(sendButton);
    }

    public boolean isEmailSending(){
        if(screen.exists(verificationPopup) != null) {
            return true;
        }
        return false;
    }

    public GmailPage sendEmail() throws FindFailed {
        screen.click(sendButton);
        return new GmailPage();
    }
}
