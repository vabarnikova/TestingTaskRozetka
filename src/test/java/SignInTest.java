import core.WebDriverSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SignInPage;
import pages.SignUpPage;

public class SignInTest extends WebDriverSettings {
    protected SignInPage signInPage;
    protected SignUpPage signUpPage;
    protected BasePage mainPage;

    @BeforeClass
    public void Initial() {
        mainPage = new BasePage();
        signInPage = mainPage.goToSignIn();
    }
    @Test
    public void incorrectAuthTest() {
        signInPage.inputAllKeys(data.getUserEmail(), data.getUserPassword());
        signInPage.incorrectEmailField(data.getErrorColor());
    }

    @Test
    public void emptyPasswordTest() {
        signInPage.inputAllKeys(data.getUserEmail(), "");
        signInPage.incorrectPasswdField(data.getErrorColor());
    }

}
