import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Alcohol;
import pages.CoffeePage;

public class AlcoholTests extends WebDriverSettings {
    protected Alcohol alcohol;
    protected CoffeePage coffeePage;

    @BeforeClass
    public void init() {
        driver.get("https://rozetka.com.ua/alkoholnie-napitki-i-produkty/c4626923/");
        alcohol = new Alcohol(driver);
    }

    @Test
    public void titleChekcingTest() {
        alcohol.verifyTitle("Алкогольные напитки и продукты");
    }

    @Test
    public void titleCoffeeTest() {
        coffeePage = alcohol.clickCoffee();
        coffeePage.checkingTitleCoffee("Кофе");
    }

}