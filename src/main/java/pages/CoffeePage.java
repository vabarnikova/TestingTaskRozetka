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

public class CoffeePage {
    protected WebDriver driver;
    private final Wait<WebDriver> waits;

    public CoffeePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        waits = new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
    }
    @FindBy(how = How.XPATH, using = "//h1[@class='catalog-heading']")
    private WebElement titleCoffee;

    @FindBy(how = How.XPATH, using = "//a[@class='goods-tile__heading']")
    private List<WebElement> listOfCoffee;

    @FindBy(how = How.XPATH, using = "//input[@id='Ambassador']/following-sibling::label")
    private WebElement checkboxAmbassador;

    public CoffeePage checkingTitleCoffee(String title) {
        waits.until(ExpectedConditions.visibilityOfAllElements(listOfCoffee));
        String coffeeT = titleCoffee.getText();
        Assert.assertEquals(coffeeT, title);
        return this;
    }

    public void checkingListOfItems(String formatWord) {
        int i = 0;
        List<String> currentResult = new ArrayList<String>();
        List<WebElement> actualResult = listOfCoffee;
        waits.until(ExpectedConditions.visibilityOfAllElements(listOfCoffee));
        for (WebElement listOfFormat : actualResult) {
            currentResult.add(listOfFormat.getText().toLowerCase());
            System.out.println(currentResult);
            System.out.println(currentResult.get(i).contains(formatWord));
            Assert.assertTrue(currentResult.get(i).contains(formatWord));
            i++;
        }
    }

    public CoffeePage searchLineChecking(){
        checkboxAmbassador.click();
        return  this;
    }


}