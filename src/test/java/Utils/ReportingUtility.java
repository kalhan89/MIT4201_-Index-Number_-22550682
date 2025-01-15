package Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportingUtility {
   private static ExtentReports extent;
   private static ExtentSparkReporter sparkReporter;
   private static ExtentTest test;
   private String reportFileName;

    @BeforeSuite
    public void setUpReport(){
        // Create a unique file name for the Extent Report
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        reportFileName = "ExtentReport_" + timestamp + ".html"; // Default report name
        // Set up ExtentSparkReporter
        sparkReporter = new ExtentSparkReporter("./reports/" + reportFileName);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }
    public void startTest(String testName,String testDescription) {
        test = extent.createTest(testName,testDescription);
    }
    public void logPass(String message, String screenshotPath) {
        test.pass(message).addScreenCaptureFromPath(screenshotPath);
    }
    public void logFail(String message, String screenshotPath) {
        test.fail(message).addScreenCaptureFromPath(screenshotPath);
    }

    public ExtentTest getTest() {
        return test;
    }
   @AfterSuite
    public void tearDownReport() {
        if (extent != null) {
            extent.flush();
        }

    }
}
