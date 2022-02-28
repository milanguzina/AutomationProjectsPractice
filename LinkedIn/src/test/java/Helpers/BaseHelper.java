package Helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class BaseHelper {

//  public static  WebDriver driver = new ChromeDriver();
//  public Properties prop;
//
//
////  public WebDriver initializeDriver () throws IOException {
//      prop = new Properties();
//      FileInputStream fis = new FileInputStream("C:\\Users\\MicaiCora\\AutomationProjects\\LinkedIn\\src\\test\\java\\resources\\data.properties");
//
//      prop.load(fis);
//      String browserName = prop.getProperty("browser");
//     Log.info("Browser: " +browserName);
//
//      if(browserName.contains("chrome"))
//      {
//          System.setProperty("webdriver.chrome.driver","C:\\Users\\MicaiCora\\AutomationProjects\\LinkedIn\\chromedriver.exe");
//          ChromeOptions options = new ChromeOptions();
//          if(browserName.contains("headless"))
//          options.addArguments("headless");
//          driver= new ChromeDriver(options);
//      }
//      else if (browserName.equals("firefox"))
//      {
//          driver= new FirefoxDriver();
//      }
//      else if (browserName.equals("IE"))
//      {
//          driver= new InternetExplorerDriver();
//      }
//
//      return driver;
//  }

  public void  getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
      TakesScreenshot ts = (TakesScreenshot)driver;
      File source = ts.getScreenshotAs(OutputType.FILE);
      String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
      FileUtils.copyFile(source,new File(destinationFile));
  }

  public static int stringToInt(String string){
      return Integer.parseInt(string.trim());
  }

}
