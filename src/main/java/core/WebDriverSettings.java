package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import logging.FormatMsg;
import logging.WebDriverLogs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import parse.DataForTesting;
import parse.ParsingData;

import java.io.IOException;
import java.util.logging.*;

public class WebDriverSettings {
    protected static WebDriver driver;
    protected ParsingData parsingData;
    protected DataForTesting data;
    protected WebDriverLogs logs;
    //protected static Logger log;


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
        logs = new WebDriverLogs();
        //log = logs.writeLogs(getClass());
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

