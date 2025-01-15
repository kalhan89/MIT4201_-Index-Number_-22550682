package Base;

import Pages.EbayHomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public EbayHomePage loadUrl(String url){
        driver.get(url);
        return PageFactory.initElements(driver,EbayHomePage.class); //return new EbayHome(driver);
    }

}
