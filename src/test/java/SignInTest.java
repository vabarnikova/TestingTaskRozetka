import core.WebDriverSettings;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RozetkaPage;
import pages.SignInPage;

@Feature("SignIn page Tests")
public class SignInTest extends WebDriverSettings {
    protected SignInPage signInPage;
    protected RozetkaPage mainPage;

    @BeforeClass
    public void Initial() {
        mainPage = new RozetkaPage();
        signInPage = mainPage.openSignIn();
    }

    @Test(description = "Invalid Login Scenario with empty password")
    public void emptyPasswordTest() {
        signInPage.inputAuthKeys(data.getUserEmail(), "");
        String color = signInPage.getIncorrectPasswdField();
        Assert.assertTrue(color != data.getErrorColor(), "-- Failed. Because input colour is white -- \n");
    }

    @Test(description = "Invalid Login Scenario with empty email")
    public void emptyEmailTest() {
        signInPage.inputAuthKeys("", data.getUserPassword());
        String color = signInPage.getIncorrectEmailField();
        Assert.assertTrue(color != data.getErrorColor(), "-- Failed. Because input colour is white -- \n");
    }

    @Test(description = "Verify authentication was successful")
    public void successfulAuthorization() {
        signInPage.inputAuthKeys(data.getValidUserEmail(), data.getValidUserPassword())
                .formContainsCaptcha();
        String authUserName = signInPage.getAuthorizedUserName(data.getValidAuthUserName());
        Assert.assertEquals(authUserName, data.getValidAuthUserName(), "-- Failed. Because user's name " + authUserName
                + " isn't equal " + data.getValidAuthUserName() + "  -- \n");
    }

}
