package pages;

import core.WebDriverSettings;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.ElementsUtils;

import java.util.List;


public class RozetkaPage extends BasePage {

    public RozetkaPage() {
        PageFactory.initElements(WebDriverSettings.getDriver(), this);
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

    @Step("Click on search and input searchWord: {0}")
    public void clickRozetkaSearch(String searchWord) {
        log.info("Pass word " + searchWord + " to search string");
        inpSearch.clear();
        inpSearch.sendKeys(searchWord);
        log.info("Click ENTER");
        inpSearch.sendKeys(Keys.ENTER);
    }

    @Step("Checking that list of items contains word: {0}")
    public boolean checkListOfItems(String word) {
        log.info("Checking that list of items contains word");
        return ElementsUtils.getListOfProducts(listOfgoods, word);
    }

    public void clickOnCheckbox(String optionName) {
        this.clickOnPageCheckbox(optionName, "//input[@id='%s']/following-sibling::label");
    }

    @Step("Open Login page")
    public SignInPage openSignIn() {
        userLink.click();
        return new SignInPage();
    }
}