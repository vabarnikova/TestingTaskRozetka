
import core.WebDriverSettings;
import logging.FormatMsg;
import logging.WebDriverLogs;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AlcoholPage;
import pages.CoffeePage;

import java.util.logging.*;

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
    public void titleChekcingTest() {
        log.info("Checking Alcohol Page title");
        String titleAlcohol = alcoholPage.verifyAlcoholTitle();
        Assert.assertEquals(data.getAlcoholTitle(),titleAlcohol,
                "-- Failed. Actual alcoholTitle not equal expected alcoholTitle --");
    }

    @Test
    public void titleCoffeeTest() {
        coffeePage = alcoholPage.clickCoffee();
        log.info("Click on Coffee Page link");
        log.info("** Open Coffee Page **");
        String titleCoffee = coffeePage.checkTitleCoffee();
        log.info("Checking Coffee Page title");
        Assert.assertEquals(titleCoffee,data.getCoffeeTitle(),
                "-- Failed. Actual coffeeTitle not equal expected coffeeTitle --");
    }
}

