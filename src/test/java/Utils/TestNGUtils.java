package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNGUtils {
    public WebDriver driver;
    protected ReportingUtility reportingUtility;
    protected ExcelHandler excelHandler;
    private String excelFilePath = "src/test/Excel/TestData.xlsx";
    private String sheetName = "MyData";
    @BeforeSuite
    public void setUpSuite() {
        reportingUtility = new ReportingUtility();
        reportingUtility.setUpReport();
        excelHandler = new ExcelHandler(excelFilePath,sheetName);
    }
    @BeforeMethod
    public void initBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Enable headless mode
        options.addArguments("--window-size=1920x1080");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
   @AfterMethod
    public void closeBrowser(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            String screenshotPath = ErrorScreenShots.takeScreenshot(driver, result.getName());
            reportingUtility.logFail("Test failed: " + result.getName(), screenshotPath);
        }
        driver.quit();

    }
    @AfterSuite
    public void tearDownSuite() {
        reportingUtility.tearDownReport();
    }

}