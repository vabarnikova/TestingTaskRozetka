package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.List;


public class RozetkaMainPage {

    protected WebDriver driver;
    private final Wait<WebDriver> waits;

    public RozetkaMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        waits = new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
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

    public Alcohol getPageAlcohol() {
        item.click();
        return new Alcohol(driver);
    }



    public RozetkaMainPage verifyRozetkaSearch(String searchWord) {
        inpSearch.click();
        inpSearch.sendKeys(searchWord);
        inpSearch.sendKeys(Keys.ENTER);
        return this;
    }

    public RozetkaMainPage checkingListOfItems(String formatWord) {
        int i = 0;
        List<String> currentResult = new ArrayList<String>();
        List<WebElement> actualResult = listOfgoods;
        waits.until(ExpectedConditions.visibilityOfAllElements(listOfgoods));
        for (WebElement listOfFormat : actualResult) {
            currentResult.add(listOfFormat.getText());
            System.out.println(currentResult);
            Assert.assertTrue(currentResult.get(i).contains(formatWord));
            i++;
        }
        return this;
    }

    public SignIn goToSignIn() {
        userLink.click();
        return new SignIn(driver);
    }
}