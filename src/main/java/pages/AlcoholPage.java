package pages;

import core.WebDriverSettings;

import logging.FormatMsg;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class AlcoholPage extends ProductPage{

    public AlcoholPage(){
        PageFactory.initElements(WebDriverSettings.getDriver(), this);
    }

    @FindBy(how = How.XPATH, using = "//h1[@class='portal__heading']")
    private WebElement heading;

    @FindBy(how = How.XPATH, using = "//li[@class='tile-cats__item']/a[@title='Кофе']")
    private WebElement coffeeButton;

    public String verifyAlcoholTitle() {
       String expTitle = this.verifyTitle(heading);
       return expTitle;
    }

    public CoffeePage clickCoffee() {
        coffeeButton.click();
        return new CoffeePage();
    }


}
