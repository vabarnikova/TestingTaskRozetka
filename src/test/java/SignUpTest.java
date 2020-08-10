import core.WebDriverSettings;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RozetkaPage;
import pages.SignInPage;
import pages.SignUpPage;

@Feature("Sign Up page Tests")
public class SignUpTest extends WebDriverSettings {
    protected RozetkaPage mainPage;
    protected SignInPage signInPage;
    protected SignUpPage signUpPage;

    @BeforeClass
    public void Init() {
        mainPage = new RozetkaPage();
        signInPage = mainPage.openSignIn();
        signUpPage = signInPage.openSignUp();

    }

    @Test(description = "Invalid Login Scenario with empty username")
    public void emptyNameSignUp() {
        signUpPage.inputAuthKeys("", data.getUserEmail(), data.getUserPassword())
                .clickToRegistration();
        String msg = signUpPage.getErrorNameMessage();
        Assert.assertEquals(msg, data.getErrorMsgName(), "-- Failed. Because error message is not " + data.getErrorMsgName() + " -- \n");
    }

    @Test(description = "Invalid Login Scenario with empty email")
    public void emptyEmailSignUp() {
        signUpPage.inputAuthKeys(data.getUserName(), "", data.getUserPassword())
                .clickToRegistration();
        String msg = signUpPage.getErrorEmailMessage();
        Assert.assertEquals(msg, data.getErrorMsgEmail(), "-- Failed. Because error message is not " + data.getErrorMsgEmail() + " -- \n");
    }

    @Test(description = "Invalid Login Scenario with empty password")
    public void emptyPasswordSignUp() {
        signUpPage.inputAuthKeys(data.getUserName(), data.getUserEmail(), "")
                .clickToRegistration();
        String color = signUpPage.getIncorrectPasswdField();
        Assert.assertTrue(color != data.getErrorColor(), "-- Failed. Because input colour is white -- \n");
    }
}
