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
        alcoholPage = new AlcoholPage();
    }

    @Test
    public void titleChekcingTest() {
        alcoholPage = new AlcoholPage();
        System.out.println(data.getAlcoholTitle());
      //  alcoholPage.verifyAlcoholTitle(data.getAlcoholTitle());
    }

//    @Test
//    public void titleCoffeeTest() {
//        coffeePage = alcoholPage.clickCoffee();
//        coffeePage.checkTitleCoffee(data.getCoffeeTitle());
//    }
}
