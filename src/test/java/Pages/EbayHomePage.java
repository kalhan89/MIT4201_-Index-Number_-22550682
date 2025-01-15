package Pages;

import Base.BasePage;
import TestCases.EbayCareersTestPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class EbayHomePage extends BasePage {
    private String visibleText;
    @FindBy(xpath ="//input[@id='gh-ac']")
    public WebElement searchBox;
    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement SignIn;
    @FindBy(xpath ="//select[@id='gh-cat']")
    public WebElement dropDownBox;
    @FindBy(xpath = "//*[@id=\"gh-search-btn\"]")
    public WebElement searchButton;
    @FindBy(xpath = "//a[normalize-space()='Sign in']")
    public WebElement SignInBtn;
    @FindBy(xpath = "//a[normalize-space()='Company info']")
    public WebElement tocompanyInfo;
    @FindBy(xpath ="//a[text()='Careers']")
    public WebElement CareersPage;

    public EbayHomePage(WebDriver driver) {
        super(driver);
    }
    public void insertTextToSearchBox(String searchText){
        searchBox.sendKeys(searchText);
    }
    public LaptopResult clickSearchBox(){
        searchButton.click();
        return PageFactory.initElements(driver,LaptopResult.class);
    }
    public LoginPage clickSingIn(){
        SignInBtn.click();
        return PageFactory.initElements(driver,LoginPage.class);
    }
    public CompanyInfoPage ClickCompanyInfo(){
        tocompanyInfo.click();
        return PageFactory.initElements(driver, CompanyInfoPage.class);
    }
    public SoftwareEngineeringJobSearch CareersTestPage(){
        CareersPage.click();
        return PageFactory.initElements(driver, SoftwareEngineeringJobSearch.class);
    }
    public void scrollPage(int x, int y){
        Actions action = new Actions(driver);
        action.scrollByAmount(x,y).perform();

    }

}
