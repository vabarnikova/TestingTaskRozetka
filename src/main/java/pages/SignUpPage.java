package pages;

import core.WebDriverSettings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class SignUpPage extends AuthorizationPage {

    private String incorrectColor;

    public SignUpPage() {
        PageFactory.initElements(WebDriverSettings.getDriver(), this);
    }

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='name']")
    private WebElement userName;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='username']")
    private WebElement userEmail;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='password']")
    private WebElement userPassword;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'auth-modal__submit')]")
    private WebElement registration;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='name']//following-sibling::form-error/p")
    private WebElement errorMsgName;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='username']//following-sibling::form-error/p")
    private WebElement errorMsgEmail;


    public SignUpPage inputUserName(String name) {
        userName.clear();
        userName.sendKeys(name);
        return this;
    }

    public SignUpPage inputUserEmail(String email) {
        userEmail.clear();
        userEmail.sendKeys(email);
        return this;
    }

    public SignUpPage inputUserPswd(String pswd) {
        userPassword.clear();
        userPassword.sendKeys(pswd);
        return this;
    }

    public SignUpPage clickToRegistration() {
        registration.click();
        return this;
    }

    public String getIncorrectPasswdField() {
        return incorrectColor = this.getIncorrectFieldColor(userPassword);
    }

    public String getErrorNameMessage() {
        String msg = errorMsgName.getText();
        return msg;
    }

    public String getErrorEmailMessage() {
        String msg = errorMsgEmail.getText();
        return msg;
    }

}
