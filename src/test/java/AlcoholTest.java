import core.WebDriverSettings;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AlcoholPage;
import pages.CoffeePage;

public class AlcoholTest extends WebDriverSettings {
    protected AlcoholPage alcoholPage;
    protected CoffeePage coffeePage;

    @BeforeClass
    public void init() {
        WebDriverSettings.getDriver().get(data.getLinkToAlcoholPage());
        alcoholPage = new AlcoholPage();
    }

    @Test
    public void titleCheckingTest() {
        String titleAlcohol = alcoholPage.getAlcoholTitle();
        Assert.assertEquals(data.getAlcoholTitle(), titleAlcohol,
                "-- Failed. Actual alcoholTitle isn't equal expected alcoholTitle --");
    }

    @Test
    public void titleCoffeeTest() {
        coffeePage = alcoholPage.openCoffee();
        String titleCoffee = coffeePage.getTitleCoffee();
        Assert.assertEquals(titleCoffee, data.getCoffeeTitle(),
                "-- Failed. Actual coffeeTitle isn't equal expected coffeeTitle --");
    }
}

