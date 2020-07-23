import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RozetkaMainPage;
import pages.SignIn;
import pages.SignUp;

public class SignInTests extends WebDriverSettings {
    protected SignIn signIn;
    protected SignUp signUp;
    protected RozetkaMainPage mainPage;

    @BeforeClass
    public void init(){
        driver.get("http://rozetka.com.ua/");
        mainPage = new RozetkaMainPage(driver);
        signIn = mainPage.goToSignIn();
    }

    @Test
    public void emptyNameSignUp(){
        signUp = signIn.registrationButton();
        signUp.failRegistration("", "v.abashdajs@gmail.com", "u6h4fks");
        signUp.errorMessage("Введите свое имя на кириллице");
    }

}