package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        parsingData = new ParsingData();
        data = parsingData.dataParse();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

