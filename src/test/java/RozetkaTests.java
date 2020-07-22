import org.testng.annotations.Test;
import pages.RozetkaMainPage;

public class RozetkaTests extends WebDriverSettings{
    protected RozetkaMainPage mainPage;
    @Test
    public void firstTest(){
        mainPage = new RozetkaMainPage(driver);
        mainPage.verifyRozetkaSearch("ноутбук");
        mainPage.checkingList("ноутбук");
    }

}
