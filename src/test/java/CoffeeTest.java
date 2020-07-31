import core.WebDriverSettings;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CoffeePage;

import java.util.List;

public class CoffeeTest extends WebDriverSettings {
    protected CoffeePage coffeePage;
    private List<String> listOfCoffee;

    @BeforeClass
    public void init() {
        coffeePage = new CoffeePage();
    }

    @Test
    public void containsOptionTest() {
        coffeePage.clickOnCheckbox(data.getOneOptionContainsListOfCoffee());
        listOfCoffee = coffeePage.checkListOfItems();
        for (String listOfWord : listOfCoffee) {
            Assert.assertTrue(listOfWord.contains(data.getOneOptionContainsListOfCoffee().toLowerCase()), "-- Failed. " +
                    listOfWord + " doesn't contain word " + data.getOneOptionContainsListOfCoffee().toLowerCase() + " --\n");
        }
    }

    @Test
    public void containsOptionsTest() {
        coffeePage.clickOnCheckbox("В зернах");
        listOfCoffee = coffeePage.checkListOfItems();
        for (String listOfWord : listOfCoffee) {
            Assert.assertTrue(listOfWord.contains(data.getTwoOptionsContainListOfCoffee()), "-- Failed. " +
                    listOfWord + " doesn't contain words " + data.getTwoOptionsContainListOfCoffee() + " --\n");
        }
    }

    @Test
    public void containsProductInBasket() {
        coffeePage.clickOnItem();
        coffeePage.clickOnButtonBuy();
        coffeePage.clickOnButtonBasket();
        Assert.assertTrue(coffeePage.isContainsProducts(),
                "-- Failed. Because basket doesn't contain any products!");
    }
}
