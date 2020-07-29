import core.WebDriverSettings;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SignInPage;

import java.util.logging.Logger;

public class SignInTest extends WebDriverSettings {
    protected SignInPage signInPage;
    protected BasePage mainPage;
    protected Logger log;

    @BeforeClass
    public void Initial() {
        mainPage = new BasePage();
        signInPage = mainPage.goToSignIn();
        log = logs.writeLogs(getClass());
        log.info("** Open SignIn Page **");
    }

    @Test
    public void emptyPasswordTest() {
        log.info("Input empty user password: ");
        signInPage.inputPassword("");
        log.info("Input user email: " + data.getUserEmail());
        signInPage.inputEmail(data.getUserEmail());
        log.info("Click to submit data");
        signInPage.clickToSubmit();
        log.info("Checking that authorization is incorrect ");
        String color = signInPage.getIncorrectPasswdField();
        Assert.assertTrue(color != data.getErrorColor(), "-- Failed. Because input colour is white -- \n");
    }

    @Test
    public void emptyEmailTest() {
        log.info("Input user email: " + data.getUserEmail());
        signInPage.inputEmail("");
        log.info("Input user password: " + data.getUserPassword());
        signInPage.inputPassword(data.getUserPassword());
        log.info("Click to submit data");
        signInPage.clickToSubmit();
        log.info("Checking that authorization is incorrect");
        String color = signInPage.getIncorrectEmailField();
        Assert.assertTrue(color != data.getErrorColor(), "-- Failed. Because input colour is white -- \n");
    }

}
