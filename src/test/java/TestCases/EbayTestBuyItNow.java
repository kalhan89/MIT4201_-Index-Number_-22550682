package TestCases;

import Base.BasePage;
import Pages.EbayHomePage;
import Pages.LaptopResult;
import Utils.ErrorScreenShots;
import Utils.ReportingUtility;
import Utils.TestNGUtils;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EbayTestBuyItNow extends TestNGUtils{
    private  LaptopResult win11;
    private  EbayHomePage ebayhome;
    @Test
    public void BuyItNow(){
        reportingUtility.startTest("Buy It Now Scenario", "Testing the Buy It Now functionality on eBay");
        BasePage baseSearch = new BasePage(driver);
        ebayhome = baseSearch.loadUrl("https://www.ebay.com/");
        String  computerType = excelHandler.getCellData(1, 1);
        ebayhome.insertTextToSearchBox(computerType);

        String screenshotPath1 = ErrorScreenShots.takeScreenshot(driver, "Search Laptops");
        reportingUtility.logPass("System successfully searched laptops", screenshotPath1);

        win11 = ebayhome.clickSearchBox();
        String screenshotPath2 = ErrorScreenShots.takeScreenshot(driver, "clickSearchBox");
        reportingUtility.logPass("System successfully click the SearchBox", screenshotPath2);
        win11.clickBox();
        String screenshotPath3 = ErrorScreenShots.takeScreenshot(driver, "selectFirstProduct");
        reportingUtility.logPass("System successfully selectFirstProduct", screenshotPath3);
        win11.selectFirstProduct();
        excelHandler.setCellData(1, 2, "Lenovo X1 Carbon 14\" FHD Core i7 Laptop Computer Windows 11  Selected");
        double actualValue = win11.assertPrice();
        double expectedPrice = 285;
        try {
            String screenshotPath4 = ErrorScreenShots.takeScreenshot(driver, "Price Comparison");
            Assert.assertTrue(actualValue <= expectedPrice, "Price exceeds expected value! Actual: $" + actualValue + ", Expected: $" + expectedPrice);
            reportingUtility.logPass("Price is within the expected range", screenshotPath4);
        } catch (AssertionError e) {
            String screenshotPath4 = ErrorScreenShots.takeScreenshot(driver, "Price Comparison Failed");
            reportingUtility.logFail("Price comparison failed: " + e.getMessage(), screenshotPath4);
            throw e;
        }
        win11.scrollPage(10, 150);
        win11.buyItNow();
        String screenshotPath5 = ErrorScreenShots.takeScreenshot(driver, "Buy It Now");
        reportingUtility.logPass("Successfully clicked Buy It Now", screenshotPath5);

        excelHandler.closeWorkbook();
    }

    }

