import core.WebDriverSettings;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;

import java.util.List;

public class BaseTest extends WebDriverSettings {

    protected BasePage mainPage;
    private List<String> listOfLaptops;

    @BeforeClass
    public void Initial() {
        mainPage = new BasePage();
    }

    @Test
    public void containsWordTest() {
        mainPage.clickRozetkaSearch(data.getSearchLaptop());
        listOfLaptops = mainPage.checkListOfItems();
        for (String listOfWord : listOfLaptops) {
            Assert.assertTrue(listOfWord.contains(data.getSearchLaptop()), "-- Failed. " +
                    listOfWord + " doesn't contain word " + data.getSearchLaptop() + " --\n");
        }
    }

    @Test
    public void containsWordOptionTest() {
        mainPage.clickRozetkaSearch(data.getSearchLaptop());
        mainPage.clickOnCheckbox(data.getOneOptionContainsListOfLaptops());
        listOfLaptops = mainPage.checkListOfItems();
        for (String listOfWord : listOfLaptops) {
            Assert.assertTrue(listOfWord.contains(data.getOneOptionContainsListOfLaptops().toLowerCase()), "-- Failed. " +
                    listOfWord + " doesn't contain word " + data.getOneOptionContainsListOfLaptops().toLowerCase() + " --\n");
        }
    }

}
