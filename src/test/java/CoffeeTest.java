import core.WebDriverSettings;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CoffeePage;

import java.util.List;

public class CoffeeTest extends WebDriverSettings {
    protected CoffeePage coffeePage;
    private List<String> listOfCoffee;

    @Test
    public void containsWordTests(){
        coffeePage = new CoffeePage();
        coffeePage.searchLineChecking();
        listOfCoffee = coffeePage.checkListOfItems();
        for(String listOfWord : listOfCoffee){
            Assert.assertTrue(listOfWord.contains(data.getWordContainsListOfCoffee()));
        }
    }
}
