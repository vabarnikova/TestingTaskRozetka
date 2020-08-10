import core.WebDriverSettings;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CoffeePage;

@Feature("Coffee page Tests")
public class CoffeeTest extends WebDriverSettings {
    protected CoffeePage coffeePage;

    @BeforeClass
    public void init() {
        coffeePage = new CoffeePage();
    }

    @Test(description = "Verify coffee list contains the selected option")
    public void containsOptionTest() {
        coffeePage.clickOnCheckbox(data.getFirstOptionContainsListOfCoffee());
        Assert.assertTrue(coffeePage.checkListOfItems(data.getFirstOptionContainsListOfCoffee()));
    }

    @Test(description = "Verify coffee list contains selected options")
    public void containsOptionsTest() {
        coffeePage.clickOnCheckbox(data.getSecondOptionContainsListOfCoffee());
        Assert.assertTrue(coffeePage.checkListOfItems(data.getTwoOptionsContainListOfCoffee()));
    }

    @Test(description = "Verify basket contains the selected product")
    public void containsProductInBasket() {
        coffeePage.clickOnItem();
        coffeePage.clickOnButtonBuy();
        coffeePage.clickOnButtonBasket();
        Assert.assertTrue(coffeePage.isContainsProducts(),
                "-- Failed. Because basket doesn't contain any products!");
    }

}

