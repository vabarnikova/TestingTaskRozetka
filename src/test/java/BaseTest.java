import core.WebDriverSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AlcoholPage;
import pages.BasePage;
import pages.SignInPage;

public class BaseTest extends WebDriverSettings {
    protected BasePage mainPage;
    protected SignInPage signInPage;

    @BeforeClass
    public void Initial() {
        mainPage = new BasePage();
    }

    @Test
    public void SearchTests() {
        mainPage.clickRozetkaSearch(data.getSearchLaptop());
        mainPage.checkListOfItems(data.getSearchLaptop());

    }

    @Test
    public void incorrectAuthTest() {
        signInPage = mainPage.goToSignIn();
        signInPage.inputAllKeys(data.getUserEmail(), data.getUserPassword());
        signInPage.incorrectEmailField(data.getErrorColor());
    }

}
