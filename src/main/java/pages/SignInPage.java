package pages;

import core.WebDriverSettings;
import core.WebDriverWaits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AuthorizationPage {

    public SignInPage() {
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

    public SignInPage inputEmail(String email) {
        userEmail.clear();
        userEmail.sendKeys(email);
        return this;
    }

    public SignInPage inputPassword(String password) {
        userPassword.clear();
        userPassword.sendKeys(password);
        return this;
    }

    public SignInPage clickToSubmit() {
        submitButton.click();
        return this;
    }

    public String getIncorrectEmailField() {
        String incorrectColor = this.getIncorrectFieldColor(userEmail);
        return incorrectColor;
    }

    public String getIncorrectPasswdField() {
        String incorrectColor = this.getIncorrectFieldColor(userPassword);
        return incorrectColor;
    }

    public SignUpPage goToSignUp() {
        WebDriverWaits.waitForPresentEl(registration);
        registration.click();
        return new SignUpPage();
    }
}
