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
    public void Init(){

        mainPage = new BasePage();
        log = logs.writeLogs(getClass());
        log.info("** Open SignUp Page **");
    }

    @Test
    public void emptyNameSignUp(){
        signInPage = mainPage.goToSignIn();
        signUpPage = signInPage.goToSignUp();
        log.info("Input empty user name, user email: "+data.getUserEmail()+" and user password: "+data.getUserPassword());
        log.info("Checking that registration is incorrect");
        signUpPage.failRegistration("", data.getUserEmail(), data.getUserPassword());
        log.info("Checking that error message is correct");
        String msg = signUpPage.errorMessage();
        Assert.assertEquals(msg,data.getErrorMsgName(), "-- Failed. Because error message is not "+data.getErrorMsgName()+ " -- \n");
    }
}
