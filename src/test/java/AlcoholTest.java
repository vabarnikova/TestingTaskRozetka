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
        alcoholPage = new AlcoholPage();
    }

    @Test
    public void titleChekcingTest() {
        alcoholPage = new AlcoholPage();
        String titleAlcohol = alcoholPage.verifyAlcoholTitle();
        Assert.assertEquals(titleAlcohol,data.getAlcoholTitle());

    }

    @Test
    public void titleCoffeeTest() {
        coffeePage = alcoholPage.clickCoffee();
        String titleCoffee = coffeePage.checkTitleCoffee();
        Assert.assertEquals(titleCoffee,data.getCoffeeTitle());
    }
}
