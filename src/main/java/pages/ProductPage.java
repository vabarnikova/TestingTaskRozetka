package pages;

import core.WebDriverWaits;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends WebDriverWaits {

    public void verifyTitle(String expTitle, WebElement actTitle) {
        waitForPresentEl(actTitle);
        String coffeeT = actTitle.getText();
        Assert.assertEquals(coffeeT, expTitle);
    }

    public void verifyListOfProducts(String searchWord, List<WebElement> listOfEl ){
        int i = 0;
        List<String> currentResult = new ArrayList<String>();
        List<WebElement> actualResult = listOfEl;
        waitForPresentListOfEl(listOfEl);
        for (WebElement listOfFormat : actualResult) {
            currentResult.add(listOfFormat.getText().toLowerCase());
            System.out.println(currentResult);
            System.out.println(currentResult.get(i).contains(searchWord));
            Assert.assertTrue(currentResult.get(i).contains(searchWord));
            i++;
        }
    }
}
