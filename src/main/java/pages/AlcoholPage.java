package pages;

import core.WebDriverSettings;
import logging.WebDriverLogs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;


public class AlcoholPage {

    protected Logger log;

    public AlcoholPage() {
        PageFactory.initElements(WebDriverSettings.getDriver(), this);
        log = WebDriverLogs.writeLogs(getClass());
        log.info("** Open Alcohol Page **");
    }

    @FindBy(how = How.XPATH, using = "//h1[@class='portal__heading']")
    private WebElement heading;

    @FindBy(how = How.XPATH, using = "//li[@class='tile-cats__item']/a[@title='Кофе']")
    private WebElement coffeeButton;

    public String verifyAlcoholTitle() {
        log.info("Checking Alcohol Page title");
        String expTitle = heading.getText();
        return expTitle;
    }

    public CoffeePage clickCoffee() {
        log.info("Click on Coffee Page link");
        coffeeButton.click();
        return new CoffeePage();
    }

}
