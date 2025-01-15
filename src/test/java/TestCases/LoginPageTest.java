package TestCases;

import Base.BasePage;
import Pages.EbayHomePage;
import Pages.LoginPage;
import Utils.ErrorScreenShots;
import Utils.ReportingUtility;
import Utils.TestNGUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LoginPageTest extends TestNGUtils {
    private LoginPage LoginTest;

    @Test(dataProvider = "userData")
    public void validateUser(String uname, String password) {
        System.out.printf("User Name : %s and Password : %s \n", uname, password);
        BasePage baseSearch = new BasePage(driver);
        EbayHomePage ebayhome = baseSearch.loadUrl("https://www.ebay.com/");
        LoginTest = ebayhome.clickSingIn();
        reportingUtility.startTest("User Validation", "Testing the add password and login functionality");
        handleCaptcha();
        try {
            // Enter username and click Continue
            LoginTest.userInput(uname);
        } catch (Exception e) {
            System.err.println("Error during username input or CAPTCHA handling: " + e.getMessage());
            handleCaptcha();
        }
        try {
            LoginTest.continueBtn();
            String screenshotPath1 = ErrorScreenShots.takeScreenshot(driver, "Add user name & Press continue button");
            reportingUtility.logPass("System successfully add user name and pressed continue button", screenshotPath1);

        } catch (Exception e) {
            System.err.println("Error during username input or CAPTCHA handling: " + e.getMessage());
            handleCaptcha();
        }
        try {
            LoginTest.userPassword(password);
        } catch (Exception e) {
            System.err.println("Error during password input or CAPTCHA handling: " + e.getMessage());
            handleCaptcha();
        }
        try {
            LoginTest.SignInBtn();
            String screenshotPath2 = ErrorScreenShots.takeScreenshot(driver, "Add password & Pressed Sign In button");
            reportingUtility.logPass("System successfully add user password and Pressed Sign In button", screenshotPath2);

        } catch (Exception e) {
            System.err.println("Error during password input or CAPTCHA handling: " + e.getMessage());
            handleCaptcha();
        }
        // Uncomment if SignOut logic is needed
        // loginTest.SignOut();
    }


    @DataProvider
    public Object[][] userData() {
        //Define new 2D Object array to hold data for testing
        Object[][] data = new Object[][]{
                {"nanayakkara2100@gmail.com", "123456789@kalhan"}
        };
        return data;
    }

    private void handleCaptcha() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            WebElement captcha = wait.until(ExpectedConditions.elementToBeClickable(By.id("captcha_element_id")));
            if ( captcha .isDisplayed()) {
                System.out.println("CAPTCHA detected! Solve it manually and press Enter...");
                new Scanner(System.in).nextLine();
            }
        } catch (TimeoutException e) {
            System.out.println("No CAPTCHA detected. Proceeding...");
        } catch (NoSuchElementException e) {

            System.out.println("CAPTCHA element not present in the DOM. Skipping CAPTCHA handling...");
        } catch (Exception e) {
            System.err.println("Unexpected error during CAPTCHA handling: " + e.getMessage());
        }
    }



}
