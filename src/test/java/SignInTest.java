import core.WebDriverSettings;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SignInPage;

public class SignInTest extends WebDriverSettings {
    protected SignInPage signInPage;
    protected BasePage mainPage;

    @BeforeClass
    public void Initial() {
        mainPage = new BasePage();
        signInPage = mainPage.goToSignIn();
    }

    @Test
    public void emptyPasswordTest() {
        signInPage.inputPassword("");
        signInPage.inputEmail(data.getUserEmail());
        signInPage.clickToSubmit();
        String color = signInPage.getIncorrectPasswdField();
        Assert.assertTrue(color != data.getErrorColor(), "-- Failed. Because input colour is white -- \n");
    }

    @Test
    public void emptyEmailTest() {
        signInPage.inputEmail("");
        signInPage.inputPassword(data.getUserPassword());
        signInPage.clickToSubmit();
        String color = signInPage.getIncorrectEmailField();
        Assert.assertTrue(color != data.getErrorColor(), "-- Failed. Because input colour is white -- \n");
    }

    @Test(description = "test fails periodically")
    public void successfulAuthorization() {
        signInPage.inputEmail(data.getValidUserEmail());
        signInPage.inputPassword(data.getValidUserPassword());
        signInPage.clickToSubmit();
        signInPage.getAuthorizedUserName(data.getValidAuthUserName());
        String authUserName = signInPage.getAuthorizedUserName(data.getValidAuthUserName());
        Assert.assertEquals(authUserName, data.getValidAuthUserName(), "-- Failed. Because user's name " + authUserName
                + " isn't equal " + data.getValidAuthUserName() + "  -- \n");
    }
}
