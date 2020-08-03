package pages;

import core.WebDriverSettings;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.logging.Logger;


public class BasePage extends ProductPage {
    private List<String> actualListOfProd;
    private Logger log;

    public BasePage() {
        PageFactory.initElements(WebDriverSettings.getDriver(), this);
        log = Logger.getLogger(CoffeePage.class.getName());
        log.info("** Open Base Page **");
    }

    @FindBy(how = How.NAME, using = "search")
    private WebElement inpSearch;

    @FindBy(how = How.XPATH, using = "//a[@class='goods-tile__heading']/span")
    private List<WebElement> listOfgoods;

    @FindBy(how = How.XPATH, using = "//a[contains(@class, 'header-topline__user-link')]")
    private WebElement userLink;

    @FindBy(how = How.XPATH, using = "//h1[@class='portal__heading']")
    private WebElement heading;

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'menu-categories_type_main')]//a[contains(@href, 'alkoholnie')]")
    private WebElement item;

    public void clickRozetkaSearch(String searchWord) {
        log.info("Pass word " + searchWord + " to search string");
        inpSearch.sendKeys(searchWord);
        log.info("Click ENTER");
        inpSearch.sendKeys(Keys.ENTER);
    }

    public List<String> checkListOfItems() {
        log.info("Checking that list of items contains word");
        actualListOfProd = this.verifyListOfProducts(listOfgoods);
        return actualListOfProd;
    }

    public void clickOnCheckbox(String optionName) {
        this.clickOnPageCheckbox(optionName, "//input[@id='%s']/following-sibling::label");
    }

    public SignInPage goToSignIn() {
        userLink.click();
        return new SignInPage();
    }
}