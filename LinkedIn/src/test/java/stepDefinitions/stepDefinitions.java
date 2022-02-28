package stepDefinitions;

import Helpers.Log;
import PageObjects.FindJobsPage;
import PageObjects.HomePage;
import PageObjects.ProfileHomePage;
import PageObjects.SignInPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

public class stepDefinitions  {

    WebDriver driver;

    @Before

    public void before() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MicaiCora\\AutomationProjects\\LinkedIn\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }

    @Given("^Navigated to Home Page (.+)$")
    public void navigated_to_home_page(String url) {
        driver.get(url);
        Log.info("navigated");
    }

    @And("^Clicks on Home Page logo$")
    public void clicks_on_home_page_logo() {
        SignInPage sip = new SignInPage(driver);
        sip.getHomeLogo().click();
    }

    @And("^Clicks on Sign in button to navigate to Sign in Page$")
    public void clicks_on_sign_in_button_to_navigate_to_sign_in_page() {
        HomePage hp = new HomePage(driver);
        hp.clickOnSignIn();
    }

    @And("^Clicks on Search for job button$")
    public void clicks_on_Search_for_job_button() {
        HomePage hp = new HomePage(driver);
        hp.clickOnSearchForJob();
    }

    @When("^User enters job criteria (.+) in search jobs box$")
    public void user_enters_job_criteria_in_search_jobs_box(String jobCriteria) {
        FindJobsPage fjp = new FindJobsPage(driver);
        fjp.enterSearchJobCriteria(jobCriteria);
    }

    @When("Scrolled down to footer hyper links section")
    public void scrolled_down_to_footer_hyper_links_section() {
        HomePage hp = new HomePage(driver);
        hp.scrollToFooterSectionHyperLinks();
    }

    @When("^User logs in with username (.+) and password (.+)$")
    public void user_logs_in_with_username_and_password(String username, String password) {
        SignInPage sip = new SignInPage(driver);
        sip.enterCredentials(username, password);
    }

    @And("^Chooses job result (.+) from dropdown list$")
    public void chooses_job_result_from_dropdownList(String jobResult) {
        FindJobsPage fjp = new FindJobsPage(driver);
        fjp.chooseDropdownOption(jobResult);
    }

    @Then("^Search results are populated$")
    public void search_results_are_populated() {
        FindJobsPage fjp = new FindJobsPage(driver);
        List<WebElement> jobsList = driver.findElements(By.className("job-search-card"));
        System.out.println("Job list size is: " + jobsList.size());
        System.out.println("Number of jobs in the result information line is: " + fjp.getJobCount());
    }

    @Then("^Verify Hyper link functionality with response code$")
    public void verify_hyper_link_functionality_with_response_code() throws IOException {
        HomePage hp = new HomePage(driver);
        hp.verifyHyperLinkFunctionality();
    }

    @Then("^Verify that user is logged in$")
    public void verify_that_user_is_logged_in() {
        ProfileHomePage php = new ProfileHomePage(driver);
        Assert.assertTrue("Profile status box is not displayed",php.getProfileSidebar().isDisplayed());
    }

    @Then("^Verify that user is not logged in$")
    public void verify_that_user_is_not_logged_in() {
        Assert.assertTrue( "Error message is not presented",driver.findElement(By.id("error-for-password")).isDisplayed());
    }

    @And("^Verify correct search results$")
    public void verify_correct_search_results() {
        FindJobsPage fjp = new FindJobsPage(driver);
        Assert.assertTrue("Search results info are not visible",fjp.searchResultsInfo.isDisplayed());
    }

    @After

    public void after() {
        driver.close();
        driver.quit();
    }

}
