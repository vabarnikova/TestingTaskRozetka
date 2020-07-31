package pages;

import core.WebDriverSettings;
import core.WebDriverWaits;
import logging.WebDriverLogs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductPage {
    private Logger log;

    public ProductPage(){
        log = WebDriverLogs.writeLogs(getClass());
    }

    public List<String> verifyListOfProducts(List<WebElement> listOfEl) {
        List<String> currentResult = new ArrayList<String>();
        List<WebElement> actualResult = listOfEl;
        WebDriverWaits.waitForPresentEl(listOfEl);
        for (WebElement listOfFormat : actualResult) {
            currentResult.add(listOfFormat.getText().toLowerCase());
        }
        return currentResult;
    }

    public void clickOnPageCheckbox(String optionName, String xPath) {
        log.info("Click on "+optionName +" checkbox");
        String optionXpath = String.format(xPath, optionName);
        By option = By.xpath(optionXpath);
        WebElement checkbox = WebDriverSettings.getDriver().findElement(option);
        if (!checkbox.isSelected())
            checkbox.click();
    }

}
