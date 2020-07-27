package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import parse.DataForTesting;
import parse.ParsingData;

import java.io.IOException;

public class WebDriverSettings {
    protected static WebDriver driver;
    protected ParsingData parsingData;
    protected DataForTesting data;


    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    @Parameters("navigateTo")
    public void setUp(String navigateTo) throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(navigateTo);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        parsingData = new ParsingData();
        data = parsingData.dataParse();
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}