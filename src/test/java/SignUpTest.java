import core.WebDriverSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SignInPage;
import pages.SignUpPage;

public class SignUpTest extends WebDriverSettings {
    protected BasePage mainPage;
    protected SignInPage signInPage;
    protected SignUpPage signUpPage;

    @BeforeClass
    public void Init(){
        mainPage = new BasePage();
    }

    @Test
    public void emptyNameSignUp(){
        signInPage = mainPage.goToSignIn();
        signUpPage = signInPage.goToSignUp();
        signUpPage.failRegistration("", data.getUserEmail(), data.getUserPassword());
        signUpPage.errorMessage(data.getErrorMsgName());
    }
}
