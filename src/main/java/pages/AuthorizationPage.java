package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.logging.Logger;

public class AuthorizationPage {
    private Logger log;

    public AuthorizationPage(){
        log = Logger.getLogger(CoffeePage.class.getName());
    }

    public String getIncorrectFieldColor(WebElement field) {
        log.info("Checking that authorization is incorrect ");
        String color = field.getCssValue("background-color");
        String hex = Color.fromString(color).asHex();
        return hex;
    }

}
