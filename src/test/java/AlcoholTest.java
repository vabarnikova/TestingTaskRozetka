import core.WebDriverSettings;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AlcoholPage;
import pages.CoffeePage;

@Feature("Alcohol page Tests")
public class AlcoholTest extends WebDriverSettings {
    protected AlcoholPage alcoholPage;
    protected CoffeePage coffeePage;

    @BeforeClass
    public void init() {
        alcoholPage = new AlcoholPage();
    }

    @Test
    @Description("Alcohol page title verification")
    public void checkingAlcoholTitleTest() {
        Assert.assertEquals(data.getAlcoholTitle(), alcoholPage.getAlcoholTitle(),
                "-- Failed. Actual alcoholTitle isn't equal expected alcoholTitle --");
    }

    @Test
    @Description("Coffee page title verification")
    public void checkingCoffeeTitleTest() {
        coffeePage = alcoholPage.openCoffee();
        Assert.assertEquals(coffeePage.getTitleCoffee(), data.getCoffeeTitle(),
                "-- Failed. Actual coffeeTitle isn't equal expected coffeeTitle --");
    }
}

