package Pages;

import Base.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class LaptopResult extends BasePage {
    @FindBy(xpath = "//span[text()='Windows 11 Home']")
    public WebElement windowsCheckBox;
    @FindBy(xpath = "//*[@id=\"item1b110d9021\"]/div/div[2]/a/div/span")
    WebElement firstProduct;
    @FindBy(xpath = "//*[@id=\"mainContent\"]/div[1]/div[3]/div/div/div[1]/span")
    WebElement itemPrice;
    @FindBy(id = "atcBtn_btn_1") // Add to Cart button
    WebElement addToCartButton;
    @FindBy(id = "watchBtn_btn_1") // Proceed to checkout button
    WebElement addToWatchList;
    @FindBy(id = "binBtn_btn_1") // Proceed to Buy It Now
    WebElement buyItNow;
    @FindBy(id = "Testing wrong element") // Proceed to Buy It Now
    WebElement Ideal_wrongElement;
    public LaptopResult(WebDriver driver) {
        super(driver);
    }
    public void clickBox(){
        windowsCheckBox.click();
    }
    public void selectFirstProduct() {
        String mainWindowHandle = driver.getWindowHandle();
        firstProduct.click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
    public double assertPrice (){
        String priceText = itemPrice.getText();
        System.out.println("Price of the first item: " + priceText);
        double actualPrice = Double.parseDouble(priceText.replace("US", "").replace("$", "").replace(",", ""));
        System.out.println("Parsed Price: " + actualPrice);
        return actualPrice;
    }
    public void buyItNow() {
        buyItNow.click();
    }
    public void addToCart() {
        addToCartButton.click();
    }
    public void addToWatchList() {
        addToWatchList.click();
    }
    public void Test_wrongElement() {
        Ideal_wrongElement.click();
    }
    public void scrollPage(int x, int y){
        Actions action = new Actions(driver);
        action.scrollByAmount(x,y).perform();
    }

}
