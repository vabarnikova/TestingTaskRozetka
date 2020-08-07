package pages;

import core.WebDriverSettings;
import core.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.ElementsUtils;

import java.util.List;

public class SignInPage extends BasePage {

    public SignInPage() {
        PageFactory.initElements(WebDriverSettings.getDriver(), this);
        log.info("** Open SignIn Page **");
    }

    @FindBy(how = How.XPATH, using = "//a[@class='auth-modal__register-link']")
    private WebElement registration;

    @FindBy(how = How.ID, using = "auth_email")
    private WebElement userEmail;

    @FindBy(how = How.ID, using = "auth_pass")
    private WebElement userPassword;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'auth-modal__submit')]")
    private WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//div[@class='auth-modal__captcha']")
    private List<WebElement> captcha;


    public String getAuthorizedUserName(String name) {
        log.info("Checking that authorization is correct");
        String userNameXpath = String.format("//p[@class='header-topline__user-text']/a[text()[contains(.,'%s')]]", name);
        By authorizedUserPage = By.xpath(userNameXpath);
        WebElement webUserName = WebDriverSettings.getDriver().findElement(authorizedUserPage);
        String userName = webUserName.getText();
        return userName;
    }

    public void getCaptcha() {
        if (captcha.size() > 0)
            log.info("Test can fail periodically because of captcha");
    }

    public SignInPage inputAuthKeys(String email, String password) {
        log.info("Input user email: " + email);
        userEmail.clear();
        userEmail.sendKeys(email);
        log.info("Input user password: " + password);
        userPassword.clear();
        userPassword.sendKeys(password);
        log.info("Click to submit data");
        submitButton.click();
        return this;
    }

    public String getIncorrectEmailField() {
        return ElementsUtils.getIncorrectFieldColor(userEmail);
    }

    public String getIncorrectPasswdField() {
        return ElementsUtils.getIncorrectFieldColor(userPassword);
    }

    public SignUpPage openSignUp() {
        WebDriverWaits.waitForPresentEl(registration);
        registration.click();
        return new SignUpPage();
    }

}
