import core.WebDriverSettings;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RozetkaPage;

@Feature("Rozetka page Tests")
public class RozetkaTest extends WebDriverSettings {

    protected RozetkaPage mainPage;

    @BeforeClass
    public void Initial() {
        mainPage = new RozetkaPage();
    }

    @Test
    @Description("Verify list of products contains search word")
    public void containsWordTest() {
        mainPage.clickRozetkaSearch(data.getSearchLaptop());
        Assert.assertTrue(mainPage.checkListOfItems(data.getSearchLaptop()));
    }

    @Test
    @Description("Verify list of products contains the selected option")
    public void containsWordOptionTest() {
        mainPage.clickRozetkaSearch(data.getSearchLaptop());
        mainPage.clickOnCheckbox(data.getOneOptionContainsListOfLaptops());
        Assert.assertTrue(mainPage.checkListOfItems(data.getOneOptionContainsListOfLaptops()));
    }

}
