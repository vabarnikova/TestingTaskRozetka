import core.WebDriverSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AlcoholPage;
import pages.CoffeePage;

public class AlcoholTest extends WebDriverSettings {
    protected AlcoholPage alcoholPage;
    protected CoffeePage coffeePage;

    @BeforeClass
    public void init() {
        alcoholPage = new AlcoholPage(driver);
    }

    @Test
    public void titleChekcingTest() {
        alcoholPage.verifyAlcoholTitle("Алкогольные напитки и продукты");
    }

    @Test
    public void titleCoffeeTest() {
        coffeePage = alcoholPage.clickCoffee();
        coffeePage.checkTitleCoffee("Кофе");
    }
}
