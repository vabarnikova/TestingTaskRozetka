import core.WebDriverSettings;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RozetkaPage;
import pages.SignInPage;
import pages.SignUpPage;

public class SignUpTest extends WebDriverSettings {
    protected RozetkaPage mainPage;
    protected SignInPage signInPage;
    protected SignUpPage signUpPage;

    @BeforeClass
    public void Init() {
        mainPage = new RozetkaPage();
        signInPage = mainPage.goToSignIn();
        signUpPage = signInPage.goToSignUp();

    }

    @Test
    public void emptyNameSignUp() {
        signUpPage.inputAuthKeys("", data.getUserEmail(), data.getUserPassword());
        signUpPage.clickToRegistration();
        String msg = signUpPage.getErrorNameMessage();
        Assert.assertEquals(msg, data.getErrorMsgName(), "-- Failed. Because error message is not " + data.getErrorMsgName() + " -- \n");
    }

    @Test
    public void emptyEmailSignUp() {
        signUpPage.inputAuthKeys(data.getUserName(), "", data.getUserPassword());
        signUpPage.clickToRegistration();
        String msg = signUpPage.getErrorEmailMessage();
        Assert.assertEquals(msg, data.getErrorMsgEmail(), "-- Failed. Because error message is not " + data.getErrorMsgEmail() + " -- \n");
    }

    @Test
    public void emptyPasswordSignUp() {
        signUpPage.inputAuthKeys(data.getUserName(), data.getUserEmail(), "");
        signUpPage.clickToRegistration();
        String color = signUpPage.getIncorrectPasswdField();
        Assert.assertTrue(color != data.getErrorColor(), "-- Failed. Because input colour is white -- \n");
    }
}
