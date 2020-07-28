import core.WebDriverSettings;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CoffeePage;

import java.util.List;
import java.util.logging.Logger;

public class CoffeeTest extends WebDriverSettings {
    protected CoffeePage coffeePage;
    private List<String> listOfCoffee;
    protected Logger log;

    @BeforeClass
    public void init(){
        log = logs.writeLogs(getClass());
        log.info("** Open Coffee Page **");
    }

    @Test
    public void containsWordTests(){
        coffeePage = new CoffeePage();
        log.info("Click on Ambassador checkbox");
        coffeePage.searchLineChecking();
        listOfCoffee = coffeePage.checkListOfItems();
        log.info("Checking that list of coffee contains word");
        for(String listOfWord : listOfCoffee){
            Assert.assertTrue(listOfWord.contains(data.getWordContainsListOfCoffee()),"-- Failed. "+
                    listOfWord + " doesn't contain word " + data.getWordContainsListOfCoffee()+" --\n");
        }

    }
}
