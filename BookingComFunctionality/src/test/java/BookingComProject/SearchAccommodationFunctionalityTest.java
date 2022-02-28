package BookingComProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.BookingComHomePage;
import PageObjects.BookingComResultsPage;


public class SearchAccommodationFunctionalityTest extends BaseTest{

	    BookingComHomePage bchp = new BookingComHomePage(driver);
	    BookingComResultsPage bcrp = new BookingComResultsPage(driver);
	  
	  @Test (dataProvider = "getData")

	    public void searchAvailableAccommodationTest(String url, String town) {
	        getUrl(url);
		    bchp.accommodationSearch(town);
	        Assert.assertTrue(bcrp.searchInfoBox.isDisplayed(),"SearchInfo box is not  presented.");
	        Assert.assertTrue( bcrp.searchInfoBoxCheckIn.getText().contains(("Monday, April 5, 2021")),"Dates of reservation do not match.");
	        Assert.assertTrue( bcrp.searchInfoBoxCheckOut.getText().contains(("Thursday, April 8, 2021")),"Dates of reservation do not match.");

	        List<WebElement> accommodationList = driver.findElements(By.className("sr_item_new"));
	        for (WebElement accomm : accommodationList) {
	             Assert.assertTrue(accomm.findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[1]/div[2]/div[1]/div[1]/div[2]/a")).getText().contains("Berlin City Center"),"Search destination is not valid");
	             Assert.assertTrue(accomm.findElement(By.className("bui-price-display__label")).getText().contains("4 adults, 1 child"),"Number of people reservations is not valid");
	             Assert.assertTrue(accomm.findElement(By.xpath("//span[contains(text(),'See availability')]")).isDisplayed(),"'See availability' button is not presented.");
	        }
	    }

		@DataProvider

	    public Object[][] getData(){
		  Object[][] data = new Object[1][2];

		  data[0][0] = "https://www.booking.com";
		  data[0][1] = "Berlin";
		  return data;
		}
	  
}
