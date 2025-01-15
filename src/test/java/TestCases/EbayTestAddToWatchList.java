package TestCases;

import Base.BasePage;
import Pages.EbayHomePage;
import Pages.LaptopResult;
import Utils.ErrorScreenShots;
import Utils.ReportingUtility;
import Utils.TestNGUtils;
import org.testng.annotations.Test;

public class EbayTestAddToWatchList extends TestNGUtils {
    @Test
    public void AddToWatchList(){
        reportingUtility.startTest("Add to Watch List Scenario", "Testing the add to watch list functionality on eBay");
        BasePage baseSearch = new BasePage(driver);
        EbayHomePage ebayhome = baseSearch.loadUrl("https://www.ebay.com/");
        String  computerType = excelHandler.getCellData(1, 1);
        ebayhome.insertTextToSearchBox(computerType);
        String screenshotPath1 = ErrorScreenShots.takeScreenshot(driver, "Search Laptops");
        reportingUtility.logPass("System successfully searched laptops", screenshotPath1);

        LaptopResult win11 =ebayhome.clickSearchBox();

        win11.clickBox();
        String screenshotPath2 = ErrorScreenShots.takeScreenshot(driver, "Select Windows 11");
        reportingUtility.logPass("System successfully Selected Windows 11 laptops", screenshotPath2);

        win11.selectFirstProduct();
        String screenshotPath3 = ErrorScreenShots.takeScreenshot(driver, "Select first product");
        reportingUtility.logPass("System successfully Selected first product", screenshotPath3);

        win11.addToWatchList();
        excelHandler.setCellData(1, 2, "Lenovo X1 Carbon 14\" FHD Core i7 Laptop Computer Windows 11  Selected");
        String screenshotPath4 = ErrorScreenShots.takeScreenshot(driver, "Add to watch list");
        reportingUtility.logPass("System successfully add to watch list", screenshotPath4);

        excelHandler.closeWorkbook();
    }
}
