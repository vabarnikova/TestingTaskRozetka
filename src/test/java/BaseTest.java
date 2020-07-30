import core.WebDriverSettings;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;

import java.util.List;
import java.util.logging.Logger;

public class BaseTest extends WebDriverSettings {
    protected BasePage mainPage;
    private List<String> listOfLaptops;
    protected Logger log;

    @BeforeClass
    public void Initial() {
        mainPage = new BasePage();
        log = logs.writeLogs(getClass());
        log.info("** Open Base Page **");
    }

    @Test
    public void containsWordTest() {
        mainPage.clickRozetkaSearch(data.getSearchLaptop());
        log.info("Pass word " + data.getSearchLaptop() + " to search string");
        listOfLaptops = mainPage.checkListOfItems();
        log.info("Checking that list of " + data.getSearchLaptop() + " contains word");
        for (String listOfWord : listOfLaptops) {
            Assert.assertTrue(listOfWord.contains(data.getSearchLaptop()), "-- Failed. " +
                    listOfWord + " doesn't contain word " + data.getSearchLaptop() + " --\n");
        }
    }

    @Test
    public void containsWordOptionTest() {
        log.info("Pass word " + data.getSearchLaptop() + " to search string");
        mainPage.clickRozetkaSearch(data.getSearchLaptop());
        log.info("Click on checkbox: " + data.getOneOptionContainsListOfLaptops());
        mainPage.clickOnCheckbox(data.getOneOptionContainsListOfLaptops());
        listOfLaptops = mainPage.checkListOfItems();
        for (String listOfWord : listOfLaptops) {
            Assert.assertTrue(listOfWord.contains(data.getOneOptionContainsListOfLaptops().toLowerCase()), "-- Failed. " +
                    listOfWord + " doesn't contain word " + data.getOneOptionContainsListOfLaptops().toLowerCase() + " --\n");
        }
    }

}
