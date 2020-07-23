package pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignIn {
    protected WebDriver driver;
    private final Wait<WebDriver> waits;

    public SignIn(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        waits = new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
    }

    @FindBy(how = How.XPATH, using = "//a[@class='auth-modal__register-link']")
    private WebElement registration;

    @FindBy(how = How.ID, using = "auth_email")
    private WebElement userEmail;

    @FindBy(how = How.ID, using = "auth_pass")
    private WebElement userPassword;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'auth-modal__submit')]")
    private WebElement submitButton;

    public SignIn inputEmail(String email){
        userEmail.sendKeys(email);
        return this;
    }

    public SignIn inputPassword(String password){
        userPassword.sendKeys(password);
        return this;
    }

    public SignIn inputAllKeys(String email, String passwd){
        this.inputEmail(email);
        this.inputPassword(passwd);
        return this;
    }

    public void incorrectEmailField(String colorValue){
        String color =  userEmail.getCssValue("background-color");
        String hex = Color.fromString(color).asHex();
        System.out.println(hex);
    }


    public SignUp registrationButton(){
        waits.until(ExpectedConditions.visibilityOf(registration));
        registration.click();
        return new SignUp(driver);
    }
}
