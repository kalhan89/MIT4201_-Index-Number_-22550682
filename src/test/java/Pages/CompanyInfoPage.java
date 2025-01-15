package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompanyInfoPage extends BasePage {

    @FindBy(xpath = "//a[@class='button-flat solid animated cta-arrow']")
    public WebElement learnMore;

    public CompanyInfoPage(WebDriver driver) {
        super(driver);
    }

    public void learnMore(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(learnMore));
        learnMore.click();
    }

    public void scrollPage(int x, int y){
        Actions action = new Actions(driver);
        action.scrollByAmount(x,y).perform();
        //to find the element/ if its 1 0f 1 after search then we can use it

    }

}
