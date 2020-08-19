package utils;

import core.WebDriverWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.List;

public class ElementsUtils {

    private ElementsUtils(){}

    public static boolean getListOfProducts(List<WebElement> listOfEl, String word) {
        WebDriverWaits.waitForPresentEl(listOfEl);
        return listOfEl.stream().allMatch(el -> el.getText().toLowerCase().contains(word.toLowerCase()));
    }


    public static String getIncorrectFieldColor(WebElement field) {
        return Color.fromString(field.getCssValue("background-color")).asHex();
    }

}
