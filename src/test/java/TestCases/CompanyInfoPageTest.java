package TestCases;

import Base.BasePage;
import Pages.CompanyInfoPage;
import Pages.EbayHomePage;
import Pages.LaptopResult;
import Utils.ErrorScreenShots;
import Utils.ReportingUtility;
import Utils.TestNGUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompanyInfoPageTest extends TestNGUtils {

   @Test
    public void companyInfo()  {
        reportingUtility.startTest("Company Information", "Testing the Company Information Page on eBay");
        BasePage baseSearch = new BasePage(driver);
        EbayHomePage ebayhome = baseSearch.loadUrl("https://www.ebay.com/");
        String screenshotPath1 = ErrorScreenShots.takeScreenshot(driver, "Address the home page");
        reportingUtility.logPass("System successfully Address the home page", screenshotPath1);

        ebayhome.scrollPage(1,2000);
        String screenshotPath2 = ErrorScreenShots.takeScreenshot(driver, "Scroll down the page");
        reportingUtility.logPass("System successfully Scroll down the Home page", screenshotPath2);

        CompanyInfoPage infoPage =  ebayhome.ClickCompanyInfo();
        infoPage.scrollPage(1,4500);

        infoPage.learnMore();
        String screenshotPath5 = ErrorScreenShots.takeScreenshot(driver, "clicked learnMore");
        reportingUtility.logPass("System successfully load the info page and clicked learnMore", screenshotPath5);

    }

}
