package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import parse.DataForTesting;
import parse.ParsingData;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    protected static WebDriver driver;
    protected ParsingData parsingData;
    protected DataForTesting data;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    @Step("Open url: {0} ")
    @Parameters("navigateTo")
    public void navigateToPage(String navigateTo) {
        driver.get(navigateTo);
        parsingData = new ParsingData();
        data = parsingData.dataParse();
    }

    @BeforeTest
    public void setDriverDetails(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterTest
    @Step("Quit tests")
    public void tearDown() {
        driver.quit();
    }
}

