import core.WebDriverSettings;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RozetkaPage;
import pages.SignInPage;

public class SignInTest extends WebDriverSettings {
    protected SignInPage signInPage;
    protected RozetkaPage mainPage;

    @BeforeClass
    public void Initial() {
        WebDriverSettings.getDriver().get(data.getLinkToRozetkaPage());
        mainPage = new RozetkaPage();
        signInPage = mainPage.openSignIn();
    }

    @Test
    public void emptyPasswordTest() {
        signInPage.inputAuthKeys(data.getUserEmail(), "");
        String color = signInPage.getIncorrectPasswdField();
        Assert.assertTrue(color != data.getErrorColor(), "-- Failed. Because input colour is white -- \n");
    }

    @Test
    public void emptyEmailTest() {
        signInPage.inputAuthKeys("", data.getUserPassword());
        String color = signInPage.getIncorrectEmailField();
        Assert.assertTrue(color != data.getErrorColor(), "-- Failed. Because input colour is white -- \n");
    }

    @Test
    public void successfulAuthorization() {
        signInPage.inputAuthKeys(data.getValidUserEmail(), data.getValidUserPassword());
        signInPage.getCaptcha();
        signInPage.getAuthorizedUserName(data.getValidAuthUserName());
        String authUserName = signInPage.getAuthorizedUserName(data.getValidAuthUserName());
        Assert.assertEquals(authUserName, data.getValidAuthUserName(), "-- Failed. Because user's name " + authUserName
                + " isn't equal " + data.getValidAuthUserName() + "  -- \n");
    }

}
