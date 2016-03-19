package functions;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class FunctionClass {

	private String URL;
	private static Selenium sele_obj;
	
	
	
	//WebDriver Backed
	public static Selenium startFirefoxURL(String url){
		WebDriver drive = new FirefoxDriver();
		sele_obj = new WebDriverBackedSelenium(drive, url);		
		return sele_obj;
	}
	
	
	
}
