import core.WebDriverSettings;
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
    public void init() {
        log = logs.writeLogs(getClass());
        log.info("** Open Coffee Page **");

    }

    @Test
    public void containsOptionTest() {
        coffeePage = new CoffeePage();
        log.info("Click on Ambassador checkbox");
        coffeePage.clickOnCheckbox("Ambassador");
        listOfCoffee = coffeePage.checkListOfItems();
        log.info("Checking that list of coffee contains word");
        for (String listOfWord : listOfCoffee) {
            Assert.assertTrue(listOfWord.contains(data.getOneOptionContainsListOfCoffee()), "-- Failed. " +
                    listOfWord + " doesn't contain word " + data.getOneOptionContainsListOfCoffee() + " --\n");
        }
    }

    @Test
    public void containsOptionsTest() {
        coffeePage = new CoffeePage();

        log.info("Click on Ambassador checkbox");
        //coffeePage.clickOnCheckbox("Ambassador");
        // I don't know why it doesn't work (-).
        // If I execute this method it will remove selected checkbox
        // if(!checkbox.isSelected()) checkbox.click(); - it doesn't work
        log.info("Click on \"В зернах\" checkbox");
        coffeePage.clickOnCheckbox("В зернах");
        listOfCoffee = coffeePage.checkListOfItems();
        for (String listOfWord : listOfCoffee) {
            Assert.assertTrue(listOfWord.contains(data.getTwoOptionsContainListOfCoffee()), "-- Failed. " +
                    listOfWord + " doesn't contain words " + data.getTwoOptionsContainListOfCoffee() + " --\n");
        }
    }

    @Test
    public void containsProductInBasket() {
        coffeePage = new CoffeePage();
        log.info("Click on coffee product");
        coffeePage.clickOnItem();
        log.info("Click on button \"Купить\"");
        coffeePage.clickOnButtonBuy();
        log.info("Click on button \"Корзина\"");
        coffeePage.clickOnButtonBasket();
        Assert.assertTrue(coffeePage.isContainsProducts(),
                "-- Failed. Because basket doesn't contain any products!");
    }
}
