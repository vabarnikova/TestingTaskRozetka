package pages;

import core.WebDriverSettings;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.ElementsUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class RozetkaPage extends BasePage {

    private static final String MENU_CATEGORY_XPATH_PATTERN = "//ul[contains(@class,'type_main')]/li/a[contains(text(), '%s')]";
    private static final String MENU_SUBCATEGORY_XPATH_PATTERN = "//a[contains(@class,'menu__link') and (text()=' %s ')]";
    public static final String MENU_CATEGORY_AND_SUBCATEGORY_XPATH_PATTERN = "//a[(text()='%s')]//parent::li//div//li/a";

    @FindBy(how = How.CSS, using = "ul.menu-categories_type_main>li>a")
    private List<WebElement> categories;

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

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'menu-outer')]/button")
    private WebElement catalog;

    public RozetkaPage() {
        PageFactory.initElements(WebDriverSettings.getDriver(), this);
        log.info("** Open Base Page **");
    }

    public void selectionCategory(String menuCategory) {
        By menuCategoryXpath = By.xpath(String.format(MENU_CATEGORY_XPATH_PATTERN, menuCategory));
        Actions actions = new Actions(WebDriverSettings.getDriver());
        actions
                .moveToElement(WebDriverSettings.getDriver().findElement(menuCategoryXpath))
                .build()
                .perform();
    }

    public void selectSubcategory(String menuSubcategory) {
        By menuSubcategoryXpath = By.xpath(String.format(MENU_SUBCATEGORY_XPATH_PATTERN, menuSubcategory));
        WebDriverSettings.getDriver().findElement(menuSubcategoryXpath).click();
    }


    public boolean isWebsiteContainsCategory(String... word) {
        return categories
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList(word));
    }

    public boolean isCategoryContainsSubcategory(String menuCategory, String... menuSubcategory) {
        selectionCategory(menuCategory);
        By categoriesXpath = By.xpath(String.format(MENU_CATEGORY_AND_SUBCATEGORY_XPATH_PATTERN, menuCategory));
        List<WebElement> subcategoriesBelongToCategory = WebDriverSettings.getDriver().findElements(categoriesXpath);
        return subcategoriesBelongToCategory
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList(menuSubcategory));
    }


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