package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@id='userid']")
    public WebElement UserIdInput;
    @FindBy(xpath = "//input[@id=\"pass\"]")
    public WebElement Password;
    @FindBy(xpath = "//*[@id=\"signin-continue-btn\"]")
    public WebElement continueBtn;
    @FindBy(xpath = "//*[@id=\"sgnBt\"]")
    public WebElement SignInBtn;
    @FindBy(xpath = "//*[@id=\"gh-ug\"]")
    public WebElement SignOut;
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void userInput(String UserName){
        UserIdInput.sendKeys(UserName);
    }
    public void userPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(Password));
        Password.sendKeys(password);
    }
    public void SignInBtn(){
        SignInBtn.click();
    }
    public void continueBtn(){
        continueBtn.click();
    }
    public void SignOut(){
        SignOut.click();
    }
    public void showCaptchaAlert() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('CAPTCHA detected! Solve it manually and press Enter...')");

        try {
            Thread.sleep(5000); // Give the user 5 seconds to dismiss the alert
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
