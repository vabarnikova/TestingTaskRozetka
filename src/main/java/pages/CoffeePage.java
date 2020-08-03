package pages;

import core.WebDriverSettings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.logging.Logger;

public class CoffeePage extends ProductPage {
    private List<String> actualListOfItems;
    private Logger log;

    public CoffeePage() {
        PageFactory.initElements(WebDriverSettings.getDriver(), this);
        log = Logger.getLogger(CoffeePage.class.getName());
        log.info("** Open Coffee Page **");
    }

    @FindBy(how = How.XPATH, using = "//h1[@class='catalog-heading']")
    private WebElement titleCoffee;

    @FindBy(how = How.XPATH, using = "//a[@class='goods-tile__heading']")
    private List<WebElement> listOfCoffee;

    @FindBy(how = How.XPATH, using = "//a[@class='goods-tile__heading'][1]")
    private WebElement coffeeItem;

    @FindBy(how = How.XPATH, using = "//app-product-buy-btn[@class='product__buy']")
    private WebElement buttonBuy;

    @FindBy(how = How.XPATH, using = "//a[contains(@class,'button_state_active')]")
    private WebElement buttonBasket;

    @FindBy(how = How.XPATH, using = "//div[@class='cart-product']")
    private List<WebElement> productsInBasket;


    public void clickOnCheckbox(String optionName) {
        this.clickOnPageCheckbox(optionName, "//input[@id='%s']/following-sibling::label");
    }

    public void clickOnItem() {
        log.info("Click on coffee product");
        coffeeItem.click();
    }

    public void clickOnButtonBuy() {
        log.info("Click on button \"Купить\"");
        buttonBuy.click();
    }

    public void clickOnButtonBasket() {
        log.info("Click on button \"Корзина\"");
        buttonBasket.click();
    }

    public boolean isContainsProducts() {
        log.info("Checking that basket contains products");
        return productsInBasket.size() > 0;
    }

    public String checkTitleCoffee() {
        log.info("Checking Coffee Page title");
        String expTitle = titleCoffee.getText();
        return expTitle;
    }

    public List<String> checkListOfItems() {
        log.info("Checking that list of coffee contains word");
        actualListOfItems = this.verifyListOfProducts(listOfCoffee);
        return actualListOfItems;
    }
}