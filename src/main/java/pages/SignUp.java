package pages;

import org.testng.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignUp {
    protected WebDriver driver;
    private final Wait<WebDriver> waits;

    public SignUp(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        waits = new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
    }

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='name']")
    private WebElement userName;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='username']")
    private WebElement userEmail;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='password']")
    private WebElement userPassword;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'auth-modal__submit')]")
    private WebElement registration;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'auth-modal__register-link')]")
    private WebElement alreadyRegistered;

    @FindBy(how = How.XPATH, using = "//p[@class='validation-message']")
    private WebElement errorName;



    public SignIn alredyRegisteredButton(){
        alreadyRegistered.click();
        return new SignIn(driver);
    }

    public SignUp inputUserName(String name){
        userName.sendKeys(name);
        return this;
    }
    public SignUp inputUserEmail(String email){
        userEmail.sendKeys(email);
        return this;
    }
    public SignUp inputUserPswd(String pswd){
        userPassword.sendKeys(pswd);
        return this;
    }

    public SignUp failRegistration(String name, String email, String password){
        this.inputUserName(name);
        this.inputUserEmail(email);
        this.inputUserPswd(password);
        registration.click();
        return this;
    }

    public SignUp errorMessage(String error){
        String msg = errorName.getText();
        System.out.println(msg);
        Assert.assertEquals(msg, error);
        return this;
    }


}
