package pages;

import core.WebDriverSettings;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public abstract class BasePage {
    protected Logger log;

    public BasePage() {
        log = Logger.getLogger(CoffeePage.class.getName());
    }

    @Step("Click on checkbox: {0}")
    public void clickOnPageCheckbox(String optionName, String xPath) {
        log.info("Click on " + optionName + " checkbox");
        String optionXpath = String.format(xPath, optionName);
        By option = By.xpath(optionXpath);
        WebElement checkbox = WebDriverSettings.getDriver().findElement(option);
        if (!checkbox.isSelected())
            checkbox.click();
    }

}
