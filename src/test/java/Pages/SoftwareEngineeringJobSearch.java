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

public class SoftwareEngineeringJobSearch extends BasePage {
    @FindBy(xpath ="//button[@id='ph-search-backdrop']//i[@class='icon icon-search-icon']")
    public WebElement SearchButton;
    @FindBy(xpath ="//*[@id='typehead']")
    public WebElement JobSearch;
    @FindBy(xpath ="//button[@id='FlexibleWorkstylesAccordion']")
    public WebElement FlexibleWorkstyles;
    @FindBy(xpath ="//span[normalize-space()='Hybrid']")
    public WebElement Hybrid;
    @FindBy(xpath ="//li[@class='jobs-list-item au-target phw-card-block-nd' ]//a[@ph-tevent = 'job_click']")
    public WebElement JobList;
    public SoftwareEngineeringJobSearch(WebDriver driver) {
        super(driver);
    }
    public void searchButton(){
        SearchButton.click();
    }
    public void JobName(String JobName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(JobSearch));
        JobSearch.sendKeys(JobName);
    }
    public void FlexibleWorkStyles(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(FlexibleWorkstyles));
        FlexibleWorkstyles.click();
    }

    public void Hybrid(){
        Hybrid.click();
    }

    public String JobList(){
        return JobList.getText();
    }
    public void NextJob(){
        JobList.click();
    }

    public void scrollPage(int x, int y){
        Actions action = new Actions(driver);
        action.scrollByAmount(x,y).perform();
        //to find the element/ if its 1 0f 1 after search then we can use it

    }

}
