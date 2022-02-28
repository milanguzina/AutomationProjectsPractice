package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FindJobsPage {

    public
    @FindBy (xpath = "//header/nav[1]/section[1]")
    WebElement jobsNavBar;
    public
    @FindBy (css = "div[class='results-context-header'] span[class='results-context-header__query-search']")
    WebElement searchResultsInfo;
    public
    @FindBy (xpath = "//header/nav[1]/section[1]/section[2]/form[1]/section[1]/input[1]")
    WebElement searchJobsBar;

    @FindBy (css = "span[class='results-context-header__job-count']")
    WebElement jobCount;


    WebDriver driver;

    public FindJobsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterSearchJobCriteria(String job)
    {
        searchJobsBar.sendKeys(job);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("li[class='typeahead-input__dropdown-item'] span[class='typeahead-input__dropdown-text']")));
    }
    public void chooseDropdownOption(String chosenJobString) {
        System.out.println("Chosen job: "+chosenJobString);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='typeahead-input__dropdown-item'] span[class='typeahead-input__dropdown-text']"));
        System.out.println("Number of options in the dropdown menu: "+options.size());
        for (WebElement chosenJob : options) {
            if (chosenJob.getText().contains(chosenJobString)) {
                chosenJob.click();
                break;
            }
        }
        }

    public String getJobCount(){
        String jobCountText = jobCount.getText();
        return  jobCountText;
    }
}
