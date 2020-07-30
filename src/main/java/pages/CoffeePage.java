package pages;

import core.WebDriverSettings;
import core.WebDriverWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CoffeePage extends ProductPage {
    private List<String> actualListOfItems;
    private Actions actions;

    public CoffeePage() {
        PageFactory.initElements(WebDriverSettings.getDriver(), this);
        actions = new Actions(WebDriverSettings.getDriver());
    }

    @FindBy(how = How.XPATH, using = "//h1[@class='catalog-heading']")
    private WebElement titleCoffee;

    @FindBy(how = How.XPATH, using = "//a[@class='goods-tile__heading']")
    private List<WebElement> listOfCoffee;

    @FindBy(how = How.XPATH, using = "//a[@class='goods-tile__heading'][1]")
    private WebElement coffeeItem;

    @FindBy(how = How.XPATH, using = "//app-product-buy-btn[@class='product__buy']")
    private WebElement buttonBuy;

    @FindBy(how = How.XPATH, using = "//div[@class='js-rz-cart']/div")
    private WebElement buttonBasket;

    @FindBy(how = How.XPATH, using = "//p[@class='header-cart__bottom']/a")
    private WebElement goToBasket;

    @FindBy(how = How.XPATH, using = "//div[@class='cart-product']")
    private List<WebElement> productsInBasket;


    public void clickOnCheckbox(String optionName) {
        this.clickOnPageCheckbox(optionName, "//input[@id='%s']/following-sibling::label");
    }

    public void clickOnItem() {
        WebDriverWaits.waitForPresentEl(coffeeItem);
        coffeeItem.click();
    }

    public void clickOnButtonBuy() {
        WebDriverWaits.waitForPresentEl(buttonBuy);
        buttonBuy.click();
    }

    public void clickOnButtonBasket() {
        actions.moveToElement(buttonBasket).build().perform();
        WebDriverWaits.waitForPresentEl(goToBasket);
        goToBasket.click();
    }

    public boolean isContainsProducts() {
        WebDriverWaits.waitForPresentEl(productsInBasket);
        return productsInBasket.size() > 0;
    }

    public String checkTitleCoffee() {
        String expTitle = this.verifyTitle(titleCoffee);
        return expTitle;
    }

    public List<String> checkListOfItems() {
        actualListOfItems = this.verifyListOfProducts(listOfCoffee);
        return actualListOfItems;
    }

}