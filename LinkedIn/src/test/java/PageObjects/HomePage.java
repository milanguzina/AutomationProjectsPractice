package PageObjects;

import Helpers.BaseHelper;
import Helpers.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class HomePage extends BaseHelper {

    @FindBy(css = "a[class='nav__button-secondary']")
    WebElement signInHomePButton;
    @FindBy(xpath = "//a[contains(text(),'Search for a job')]")
    WebElement searchForJobButton;
    @FindBy(xpath = "//body/main[@id='main-content']/section[9]/div[1]/div[1]")
    WebElement footerSection;


    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSignIn() {
        signInHomePButton.click();
        Log.info("Clicked on Home button.");
    }

    public void clickOnSearchForJob() {
        searchForJobButton.click();
        Log.debug("Clicked on Search button.");
    }

    public void scrollToFooterSectionHyperLinks() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", footerSection);

    }

    public void verifyHyperLinkFunctionality() throws IOException {
        List<WebElement> linksList = driver.findElements(By.xpath("//body/main[@id='main-content']/section[9]/div[1]/div[1]"));
        System.out.println(linksList.size());
        for (WebElement link : linksList) {
            String url = link.getAttribute("href");
            String linkName = link.getText();
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();

            int responseCode = conn.getResponseCode();
            Log.info("Response code for "+linkName+" link is: "+responseCode);
            if (responseCode < 400) {
                Log.info(linkName+ " link is functional.");

            } else {
                Log.info(linkName+ " link is broken");
            }
        }
    }
}

