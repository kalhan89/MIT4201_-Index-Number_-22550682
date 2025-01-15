package TestCases;

import Base.BasePage;
import Pages.EbayHomePage;
import Pages.LaptopResult;
import Utils.ErrorScreenShots;
import Utils.ReportingUtility;
import Utils.TestNGUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class EbayTestAddToCart extends TestNGUtils {
    @Test
    public void AddToCart()
    {
    reportingUtility.startTest("Add to Cart Scenario", "Testing the add to cart functionality on eBay");
    BasePage baseSearch = new BasePage(driver);
    EbayHomePage ebayhome = baseSearch.loadUrl("https://www.ebay.com/");
    String  computerType = excelHandler.getCellData(1, 1);
    ebayhome.insertTextToSearchBox(computerType);
    String screenshotPath1 = ErrorScreenShots.takeScreenshot(driver, "Search Laptops");
    reportingUtility.logPass("System successfully searched laptops", screenshotPath1);
    LaptopResult win11 =ebayhome.clickSearchBox();
    win11.clickBox();
    String screenshotPath2 = ErrorScreenShots.takeScreenshot(driver, "Select Windows 11");
    reportingUtility.logPass("System successfully Selected Windows 11", screenshotPath2);
    win11.selectFirstProduct();
    String screenshotPath3 = ErrorScreenShots.takeScreenshot(driver, "Select first product");
    reportingUtility.logPass("System successfully Selected first product", screenshotPath3);
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
    win11.scrollPage(10, 100);
    win11.addToCart();
    excelHandler.setCellData(1, 2, "HP Laptop 14\" HD Intel Core i3-1115G4 8GB 256GB PCIe SSD HD Cam Win 11 S Silver");
    String screenshotPath5 = ErrorScreenShots.takeScreenshot(driver, "addToCart");
    reportingUtility.logPass("System successfully addToCart", screenshotPath5);
    excelHandler.closeWorkbook();
    }



}
