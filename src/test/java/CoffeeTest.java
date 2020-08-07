import core.WebDriverSettings;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CoffeePage;

public class CoffeeTest extends WebDriverSettings {
    protected CoffeePage coffeePage;

    @BeforeClass
    public void init() {
        WebDriverSettings.getDriver().get(data.getLinkToCoffeePage());
        coffeePage = new CoffeePage();
    }

    @Test
    public void containsOptionTest() {
        coffeePage.clickOnCheckbox(data.getFirstOptionContainsListOfCoffee());
        Assert.assertTrue(coffeePage.checkListOfItems(data.getFirstOptionContainsListOfCoffee()));
    }

    @Test
    public void containsOptionsTest() {
        coffeePage.clickOnCheckbox(data.getSecondOptionContainsListOfCoffee());
        Assert.assertTrue(coffeePage.checkListOfItems(data.getTwoOptionsContainListOfCoffee()));
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
