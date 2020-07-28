package pages;

import core.WebDriverSettings;
import core.WebDriverWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends WebDriverWaits{

    public SignInPage(){
        PageFactory.initElements(WebDriverSettings.getDriver(), this);
    }

    @FindBy(how = How.XPATH, using = "//a[@class='auth-modal__register-link']")
    private WebElement registration;

    @FindBy(how = How.ID, using = "auth_email")
    private WebElement userEmail;

    @FindBy(how = How.ID, using = "auth_pass")
    private WebElement userPassword;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'auth-modal__submit')]")
    private WebElement submitButton;

    public SignInPage inputEmail(String email){
        userEmail.sendKeys(email);
        return this;
    }

    public SignInPage inputPassword(String password){
        userPassword.sendKeys(password);
        return this;
    }

    public SignInPage inputAllKeys(String email, String passwd){
        this.inputEmail(email);
        this.inputPassword(passwd);
        return this;
    }

    public void incorrectEmailField(String colorValue){
        String color =  userEmail.getCssValue("background-color");
        String hex = Color.fromString(color).asHex();
    }

    public void incorrectPasswdField(String colorValue){
        String color =  userPassword.getCssValue("background-color");
        String hex = Color.fromString(color).asHex();
    }

    public SignUpPage goToSignUp(){
        this.waitForPresentEl(registration);
        registration.click();
        return new SignUpPage();
    }
}
