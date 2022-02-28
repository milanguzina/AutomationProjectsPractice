package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    @FindBy(id = "username")
    WebElement usernameBox;
    @FindBy(id ="password")
    WebElement passwordBox;
    @FindBy (xpath = "//button[contains(text(),'Sign in')]")
    WebElement signInButton;
    @FindBy(xpath ="//a[@class='nav__logo-link']")
    WebElement homeLogo;

    WebDriver driver;

    public SignInPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getHomeLogo(){
        return homeLogo;
    }
    public void enterCredentials(String username, String password)
    {
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        signInButton.click();
    }

}
