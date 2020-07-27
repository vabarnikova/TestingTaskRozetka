package core;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebDriverWaits {

    private Wait<WebDriver> waits;

    public void waitForPresentEl(WebElement element){
        waits = new WebDriverWait(WebDriverSettings.getDriver(), 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
        waits.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPresentListOfEl(List<WebElement> element){
        waits = new WebDriverWait(WebDriverSettings.getDriver(), 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
        waits.until(ExpectedConditions.visibilityOfAllElements(element));
    }

}
