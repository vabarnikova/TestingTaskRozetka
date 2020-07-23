
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Alcohol;
import pages.RozetkaMainPage;
import pages.SignIn;

public class RozetkaTests extends WebDriverSettings {
    protected RozetkaMainPage mainPage;
    protected SignIn signIn;
    protected Alcohol alcohol;

    @BeforeClass
    public void Initial() {
        driver.get("http://rozetka.com.ua/");
        mainPage = new RozetkaMainPage(driver);
    }

    @Test
    public void SearchTests() {
        mainPage.verifyRozetkaSearch("Ноутбук");
        mainPage.checkingListOfItems("Ноутбук");

    }

    @Test
    public void incorrectAuthTest() {
        signIn = mainPage.goToSignIn();
        signIn.inputAllKeys("smt", "4g4h44ys");
        signIn.incorrectEmailField("#fee8e8");
    }

    @Test
    public void emptyPasswdTest() {
        signIn = mainPage.goToSignIn();
        signIn.inputAllKeys("smt", "");
        signIn.incorrectEmailField("#fee8e8");
    }

    @Test
    public void verifyTitleTest() {
      alcohol =  mainPage.getPageAlcohol();
      alcohol.verifyTitle("Алкогольные напитки и продукты");
    }




}