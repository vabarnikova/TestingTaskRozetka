package pages;

import core.WebDriverSettings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.ElementsUtils;

import java.util.List;

public class CoffeePage extends BasePage {
    private List<String> actualListOfItems;

    public CoffeePage() {
        PageFactory.initElements(WebDriverSettings.getDriver(), this);
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

    public String getTitleCoffee() {
        log.info("Checking Coffee Page title");
        return titleCoffee.getText();
    }

    public boolean checkListOfItems(String word) {
        log.info("Checking that list of coffee contains word");
        return ElementsUtils.getListOfProducts(listOfCoffee, word);
    }
}