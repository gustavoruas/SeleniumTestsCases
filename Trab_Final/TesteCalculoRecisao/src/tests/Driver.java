package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	private static WebDriver drive;
	private static String urlBase = "http://www.calculador.com.br";
	
	public static WebDriver createDrive(String url){
		
		if(drive == null){
			drive = new FirefoxDriver();
			drive.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		}
		
		drive.get(urlBase + url);
		
		return drive;
	}
	
	

}
