package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

    @FindBy(how = How.NAME, using = "//a[@class='goods-tile__heading']/span")
    private List<WebElement> listOfgoods;

    @FindBy(how = How.NAME, using = "//a[contains(@class, 'header-topline__user-link')]")
    private WebElement userLink;


    /////////////////////////// smth strange
    @FindBy(how = How.NAME, using = "//li[@class='menu-categories__item'][13]")
    private WebElement item;
    ///////////////////////////
    public Alcohol getPageAlcohol(){
        item.click();
        return new Alcohol(driver);
    }


    public void verifyRozetkaSearch(String searchWord){
        inpSearch.click();
        inpSearch.sendKeys(searchWord);
        inpSearch.sendKeys(Keys.ENTER);
    }


    public void checkingList(String formatName) {
        List<String> currentResult = new ArrayList<String>();
        waits.until(ExpectedConditions.visibilityOfAllElements(listOfgoods));
        List<WebElement> actualResult = listOfgoods;
        for (WebElement listOfFormat : actualResult) {
            currentResult.add(listOfFormat.getText());
            Assert.assertTrue(currentResult.contains(formatName));
        }
    }

    public SignIn goTo(){
        userLink.click();
        return new SignIn(driver);
    }
}
