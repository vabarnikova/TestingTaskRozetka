import core.WebDriverSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CoffeePage;

public class CoffeeTest extends WebDriverSettings {
    protected CoffeePage coffeePage;

    @Test
    public void containsWordTests(){
        coffeePage = new CoffeePage(driver);
        coffeePage.searchLineChecking();
<<<<<<< HEAD:src/test/java/CoffeeTest.java
        coffeePage.checkListOfItems("ambassador");
=======
        coffeePage.checkingListOfItems("ambassador");
>>>>>>> b142ebfe5ebf35140818791f67f870122ff83f7d:src/test/java/CoffeePageTests.java
    }
}
