package pages;

import core.WebDriverSettings;
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

public class CoffeePage extends ProductPage{
    private List<String> actualListOfItems;

    public CoffeePage(){
        PageFactory.initElements(WebDriverSettings.getDriver(), this);
    }

    @FindBy(how = How.XPATH, using = "//h1[@class='catalog-heading']")
    private WebElement titleCoffee;

    @FindBy(how = How.XPATH, using = "//a[@class='goods-tile__heading']")
    private List<WebElement> listOfCoffee;

    @FindBy(how = How.XPATH, using = "//input[@id='Ambassador']/following-sibling::label")
    private WebElement checkboxAmbassador;

    public String checkTitleCoffee() {
       String expTitle = this.verifyTitle(titleCoffee);
       return expTitle;
    }

    public List<String> checkListOfItems() {
       actualListOfItems = this.verifyListOfProducts(listOfCoffee);
       return actualListOfItems;
    }

    public CoffeePage searchLineChecking(){
        checkboxAmbassador.click();
        return this;
    }


}