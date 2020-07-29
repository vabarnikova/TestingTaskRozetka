import core.WebDriverSettings;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AlcoholPage;
import pages.CoffeePage;

import java.util.logging.Logger;

public class AlcoholTest extends WebDriverSettings {
    protected AlcoholPage alcoholPage;
    protected CoffeePage coffeePage;
    protected Logger log;

    @BeforeClass
    public void init() {
        alcoholPage = new AlcoholPage();
        log = logs.writeLogs(getClass());
        log.info("** Open Alcohol Page **");
    }

    @Test
    public void titleCheckingTest() {
        log.info("Checking Alcohol Page title");
        String titleAlcohol = alcoholPage.verifyAlcoholTitle();
        Assert.assertEquals(data.getAlcoholTitle(), titleAlcohol,
                "-- Failed. Actual alcoholTitle isn't equal expected alcoholTitle --");
    }

    @Test
    public void titleCoffeeTest() {
        coffeePage = alcoholPage.clickCoffee();
        log.info("Click on Coffee Page link");
        log.info("** Open Coffee Page **");
        String titleCoffee = coffeePage.checkTitleCoffee();
        log.info("Checking Coffee Page title");
        Assert.assertEquals(titleCoffee, data.getCoffeeTitle(),
                "-- Failed. Actual coffeeTitle isn't equal expected coffeeTitle --");
    }
}

