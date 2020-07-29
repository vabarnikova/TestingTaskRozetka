package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class AuthorizationPage {

    public String getIncorrectFieldColor(WebElement field) {
        String color = field.getCssValue("background-color");
        String hex = Color.fromString(color).asHex();
        return hex;
    }

}
