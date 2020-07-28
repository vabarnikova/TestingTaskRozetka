import core.WebDriverSettings;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SignInPage;
import pages.SignUpPage;

import java.util.logging.Logger;

public class SignInTest extends WebDriverSettings {
    protected SignInPage signInPage;
    protected SignUpPage signUpPage;
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
    public void incorrectAuthTest() throws InterruptedException {
        signInPage.inputAllKeys(data.getUserEmail(), data.getUserPassword());
        log.info("Input user email: "+data.getUserEmail()+" and user password: "+data.getUserPassword());
        log.info("Checking that authorization is incorrect");
        String color = signInPage.incorrectEmailField();
        Assert.assertTrue(color != data.getErrorColor(), "-- Failed. Because input colour is white -- \n");
    }
    @Test
    public void emptyPasswordTest() throws InterruptedException {
        log.info("Input user email: "+data.getUserEmail()+" and empty user password: "+data.getUserPassword());
        log.info("Checking that authorization is incorrect");
        signInPage.inputAllKeys(data.getUserEmail(), "");
        String color = signInPage.incorrectPasswdField();
        Assert.assertTrue(color != data.getErrorColor(), "-- Failed. Because input colour is white -- \n");
    }

}
