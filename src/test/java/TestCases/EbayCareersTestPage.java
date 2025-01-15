package TestCases;

import Base.BasePage;
import Pages.EbayHomePage;
import Pages.LaptopResult;
import Pages.SoftwareEngineeringJobSearch;
import Utils.ErrorScreenShots;
import Utils.ReportingUtility;
import Utils.TestNGUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class EbayCareersTestPage extends TestNGUtils {

    @Test
    public void CareersTest()
    {
    reportingUtility.startTest("Adding a job description to the careers page", "Testing the job search functionality on eBay.");
    BasePage baseSearch = new BasePage(driver);
    EbayHomePage ebayhome = baseSearch.loadUrl("https://www.ebay.com/");
    ebayhome.scrollPage(1,1500);
    SoftwareEngineeringJobSearch job =ebayhome.CareersTestPage();
    String screenshotPath2 = ErrorScreenShots.takeScreenshot(driver, "Accessed the Careers page");
    reportingUtility.logPass("Successfully Accessed the Careers page and scrolled down", screenshotPath2);
    ebayhome.scrollPage(1,100);
    job.JobName("Software Engineering");
    String screenshotPath4 = ErrorScreenShots.takeScreenshot(driver, "Search the job as Software Engineering");
    reportingUtility.logPass("Successfully Searched the job as Software Engineering", screenshotPath4);
    job.searchButton();
    job.FlexibleWorkStyles();
    String screenshotPath5 = ErrorScreenShots.takeScreenshot(driver, "Clicked FlexibleWorkStyles");
    reportingUtility.logPass("Successfully Clicked the FlexibleWorkStyles ", screenshotPath5);
    job.scrollPage(1,100);
    job.Hybrid();
    String screenshotPath6 = ErrorScreenShots.takeScreenshot(driver, "Clicked Hybrid method");
    reportingUtility.logPass("Successfully Clicked the Hybrid method ", screenshotPath6);
    excelHandler.setCellData(2, 2, job.JobList());
    excelHandler.closeWorkbook();

    }


}
