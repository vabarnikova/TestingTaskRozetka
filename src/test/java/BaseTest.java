import core.WebDriverSettings;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AlcoholPage;
import pages.BasePage;
import pages.SignInPage;

import java.util.List;

public class BaseTest extends WebDriverSettings {
    protected BasePage mainPage;
    protected SignInPage signInPage;
    private List<String> listOfLaptops;

    @BeforeClass
    public void Initial() {
        mainPage = new BasePage();
    }

    @Test
    public void SearchTests() {
        mainPage.clickRozetkaSearch(data.getSearchLaptop());
        listOfLaptops = mainPage.checkListOfItems();
        for (String listOfWord : listOfLaptops){
            Assert.assertTrue(listOfWord.contains(data.getSearchLaptop()));
        }
    }

    @Test
    public void incorrectAuthTest() {
        signInPage = mainPage.goToSignIn();
        signInPage.inputAllKeys(data.getUserEmail(), data.getUserPassword());
        signInPage.incorrectEmailField(data.getErrorColor());
    }

}
