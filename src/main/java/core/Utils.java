package core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> getListOfProducts(List<WebElement> listOfEl) {
        List<String> currentResult = new ArrayList<String>();
        List<WebElement> actualResult = listOfEl;
        WebDriverWaits.waitForPresentEl(listOfEl);
        for (WebElement listOfFormat : actualResult) {
            currentResult.add(listOfFormat.getText().toLowerCase());
        }
        return currentResult;
    }

    public static String getIncorrectFieldColor(WebElement field) {
        String color = field.getCssValue("background-color");
        String hex = Color.fromString(color).asHex();
        return hex;
    }

}
