import core.WebDriverSettings;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RozetkaPage;

public class RozetkaTest extends WebDriverSettings {

    protected RozetkaPage mainPage;

    @BeforeClass
    public void Initial() {
        WebDriverSettings.getDriver().get(data.getLinkToRozetkaPage());
        mainPage = new RozetkaPage();
    }

    @Test
    public void containsWordTest() {
        mainPage.clickRozetkaSearch(data.getSearchLaptop());
        Assert.assertTrue(mainPage.checkListOfItems(data.getSearchLaptop()));
    }

    @Test
    public void containsWordOptionTest() {
        mainPage.clickRozetkaSearch(data.getSearchLaptop());
        mainPage.clickOnCheckbox(data.getOneOptionContainsListOfLaptops());
        Assert.assertTrue(mainPage.checkListOfItems(data.getOneOptionContainsListOfLaptops()));
    }

}
