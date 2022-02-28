package BookingComProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import PageObjects.BookingComSignInPage;


public class PositiveLoginTest extends BaseTest{
   
	BookingComSignInPage bcsip = new BookingComSignInPage(driver);
	
    
   
    @Test(dataProvider = "getData")
    
    public void bookingComPositiveLoginTest(String url,String username, CharSequence[] password) throws InterruptedException {
            getUrl(url);
            bcsip.userLogin(username,password);
            WebElement profileOptionsButton = driver.findElement(By.id("profile-menu-trigger--title"));
            Assert.assertTrue( profileOptionsButton.getText().contains("Guzina Zavrsni"),"Profile options button is not displayed.");
            WebElement profileAvatarPicture = driver.findElement(By.className("bui-avatar-block"));
            Assert.assertTrue( profileAvatarPicture.isDisplayed(),"Profile avatar picture is not displayed.");

    }
    
    @DataProvider
    
    public Object[][] getData(){
    Object[][] data = new Object[1][3];

    data[0][0] = "https://www.booking.com";
    data[0][1] = "guzina.zavrsni@gmail.com";
    data[0][2] = "guzinazavrsni123";
   
    return data;
    } 
}
