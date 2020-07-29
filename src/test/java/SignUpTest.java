import core.WebDriverSettings;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SignInPage;
import pages.SignUpPage;

import java.util.logging.Logger;

public class SignUpTest extends WebDriverSettings {
    protected BasePage mainPage;
    protected SignInPage signInPage;
    protected SignUpPage signUpPage;
    protected Logger log;

    @BeforeClass
    public void Init() {
        mainPage = new BasePage();
        signInPage = mainPage.goToSignIn();
        signUpPage = signInPage.goToSignUp();
        log = logs.writeLogs(getClass());
        log.info("** Open SignUp Page **");
    }

    @Test
    public void emptyNameSignUp() {
        log.info("Input empty user name: ");
        signUpPage.inputUserName("");
        log.info("Input user email: " + data.getUserEmail());
        signUpPage.inputUserEmail(data.getUserEmail());
        log.info("Input user password: " + data.getUserPassword());
        signUpPage.inputUserPswd(data.getUserPassword());
        log.info("Click to register");
        signUpPage.clickToRegistration();
        log.info("Checking that registration is incorrect");
        log.info("Checking that error message is correct");
        String msg = signUpPage.getErrorNameMessage();
        Assert.assertEquals(msg, data.getErrorMsgName(), "-- Failed. Because error message is not " + data.getErrorMsgName() + " -- \n");
    }

    @Test
    public void emptyEmailSignUp() {
        log.info("Input user name: " + data.getUserName());
        signUpPage.inputUserName(data.getUserName());
        log.info("Input empty user email: ");
        signUpPage.inputUserEmail("");
        log.info("Input user password: " + data.getUserPassword());
        signUpPage.inputUserPswd(data.getUserPassword());
        log.info("Click to register");
        signUpPage.clickToRegistration();
        log.info("Checking that registration is incorrect");
        log.info("Checking that error message is correct");
        String msg = signUpPage.getErrorEmailMessage();
        Assert.assertEquals(msg, data.getErrorMsgEmail(), "-- Failed. Because error message is not " + data.getErrorMsgEmail() + " -- \n");
    }

    @Test
    public void emptyPasswordSignUp() {
        log.info("Input user name: " + data.getUserName());
        signUpPage.inputUserName(data.getUserName());
        log.info("Input user email: " + data.getUserEmail());
        signUpPage.inputUserEmail(data.getUserEmail());
        log.info("Input empty user password: ");
        signUpPage.inputUserPswd("");
        log.info("Click to register");
        signUpPage.clickToRegistration();
        log.info("Checking that registration is incorrect");
        String color = signUpPage.getIncorrectPasswdField();
        Assert.assertTrue(color != data.getErrorColor(), "-- Failed. Because input colour is white -- \n");
    }
}
