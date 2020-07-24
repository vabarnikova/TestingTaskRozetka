import core.WebDriverSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CoffeePage;

public class CoffeeTest extends WebDriverSettings {
    protected CoffeePage coffeePage;

    @BeforeClass
    public void init(){
        coffeePage = new CoffeePage(driver);
        driver.get("https://rozetka.com.ua/koffee/c4625011/");
    }

    @Test
    public void containsWordTests(){
        coffeePage.searchLineChecking();
        coffeePage.checkingListOfItems("ambassador");
    }
}
