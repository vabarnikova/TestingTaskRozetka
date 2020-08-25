package pages;

import core.WebDriverSettings;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.ElementsUtils;


public class SignUpPage extends BasePage {

    public SignUpPage() {
        PageFactory.initElements(WebDriverSettings.getDriver(), this);
        log.info("** Open SignUp Page **");
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

    @Step("Login step with name: {0}, email: {1}, password: {2}")
    public SignUpPage inputAuthKeys(String name, String email, String password) {
        log.info("Input empty user name: " + name);
        userName.clear();
        userName.sendKeys(name);
        log.info("Input user email: " + email);
        userEmail.clear();
        userEmail.sendKeys(email);
        log.info("Input user password: " + password);
        userPassword.clear();
        userPassword.sendKeys(password);
        log.info("Click to register");
        registration.click();
        return this;
    }

    @Step("Click on registration button")
    public void clickToRegistration() {
        log.info("Click to register");
        registration.click();
    }

    @Step("Get incorrect color of password field")
    public String getIncorrectPasswdField() {
        return ElementsUtils.getIncorrectFieldColor(userPassword);
    }

    @Step("Get error username message")
    public String getErrorNameMessage() {
        log.info("Checking that error message is correct");
        return errorMsgName.getText();
    }

    @Step("Get error email message")
    public String getErrorEmailMessage() {
        return errorMsgEmail.getText();
    }

}
