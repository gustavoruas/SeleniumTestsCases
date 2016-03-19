package functions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FunctionClassDriver {

	  private static WebDriver driver;
	  private String baseUrl;
	  
	  public static WebDriver startFirefoxDriver(String url){		  
		  driver = new FirefoxDriver();		 
		  driver.get(url);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		  return driver;	  
		  
	  }
	
}
