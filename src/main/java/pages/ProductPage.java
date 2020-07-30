package pages;

import core.WebDriverSettings;
import core.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {
    private String coffeeT;

    public String verifyTitle(WebElement actTitle) {
        WebDriverWaits.waitForPresentEl(actTitle);
        return coffeeT = actTitle.getText();
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
        String optionXpath = String.format(xPath, optionName);
        By option = By.xpath(optionXpath);
        WebDriverWaits.waitForPresentEl(option);
        WebElement checkbox = WebDriverSettings.getDriver().findElement(option);
        if (!checkbox.isSelected())
            checkbox.click();
    }

}
