package BookingComProject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import Resources.BaseHelper;

public class BaseTest extends BaseHelper 
{		
	
	 
	@BeforeTest
    public void testInit() {
        
		driver.manage().window().maximize();     
	}
	
	
    @AfterTest
    public void testTearDown() {
    	
        driver.close();
    }

}