package pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

<<<<<<< HEAD:src/main/java/pages/AlcoholPage.java
public class AlcoholPage extends ProductPage{
=======
public class AlcoholPage {
>>>>>>> b142ebfe5ebf35140818791f67f870122ff83f7d:src/main/java/pages/Alcohol.java
    protected WebDriver driver;
    private final Wait<WebDriver> waits;

    public AlcoholPage(WebDriver driver) {
<<<<<<< HEAD:src/main/java/pages/AlcoholPage.java
        super(driver);
=======
        PageFactory.initElements(driver, this);
>>>>>>> b142ebfe5ebf35140818791f67f870122ff83f7d:src/main/java/pages/Alcohol.java
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        waits = new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
    }

    @FindBy(how = How.XPATH, using = "//h1[@class='portal__heading']")
    private WebElement heading;

    @FindBy(how = How.XPATH, using = "//li[@class='tile-cats__item']/a[@title='Кофе']")
    private WebElement coffeeButton;

<<<<<<< HEAD:src/main/java/pages/AlcoholPage.java
    public void verifyAlcoholTitle(String title) {
        this.verifyTitle(title, heading);
=======



    public AlcoholPage verifyTitle(String title) {
        waits.until(ExpectedConditions.visibilityOf(heading));
        String headT = heading.getText();
        System.out.println(headT);
      //  Assert.assertEquals(title, headT);
        return this;
>>>>>>> b142ebfe5ebf35140818791f67f870122ff83f7d:src/main/java/pages/Alcohol.java
    }

    public CoffeePage clickCoffee() {
        coffeeButton.click();
        return new CoffeePage(driver);
    }


}
