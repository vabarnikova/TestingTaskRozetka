package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import logging.WebDriverLogs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import parse.DataForTesting;
import parse.ParsingData;

public class WebDriverSettings {
    protected static WebDriver driver;
    protected ParsingData parsingData;
    protected DataForTesting data;
    protected WebDriverLogs logs;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    @Parameters("navigateTo")
    public void setUp(String navigateTo) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(navigateTo);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        parsingData = new ParsingData();
        data = parsingData.dataParse();
        logs = new WebDriverLogs();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

