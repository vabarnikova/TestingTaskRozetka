package pages;

import core.WebDriverWaits;
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
        WebDriverWaits.waitForPresentListOfEl(listOfEl);
        for (WebElement listOfFormat : actualResult) {
            currentResult.add(listOfFormat.getText().toLowerCase());
        }
        return currentResult;
    }
}
