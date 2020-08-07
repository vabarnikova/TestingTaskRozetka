package pages;

import core.WebDriverSettings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class AlcoholPage extends BasePage {

    public AlcoholPage() {
        PageFactory.initElements(WebDriverSettings.getDriver(), this);
        log.info("** Open Alcohol Page **");
    }

    @FindBy(how = How.XPATH, using = "//h1[@class='portal__heading']")
    private WebElement heading;

    @FindBy(how = How.XPATH, using = "//li[@class='tile-cats__item']/a[@title='Кофе']")
    private WebElement coffeeButton;

    public String getAlcoholTitle() {
        log.info("Checking Alcohol Page title");
        return heading.getText();
    }

    public CoffeePage openCoffee() {
        log.info("Click on Coffee Page link");
        coffeeButton.click();
        return new CoffeePage();
    }

}
