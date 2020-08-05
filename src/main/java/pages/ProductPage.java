package pages;

import core.WebDriverSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class ProductPage {
    private Logger log;

    public ProductPage() {
        log = Logger.getLogger(CoffeePage.class.getName());
    }

    public void clickOnPageCheckbox(String optionName, String xPath) {
        log.info("Click on " + optionName + " checkbox");
        String optionXpath = String.format(xPath, optionName);
        By option = By.xpath(optionXpath);
        WebElement checkbox = WebDriverSettings.getDriver().findElement(option);
        if (!checkbox.isSelected())
            checkbox.click();
    }

}
