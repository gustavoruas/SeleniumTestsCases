

import com.thoughtworks.selenium.Selenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import functions.FunctionClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;
//import static org.apache.commons.lang3.StringUtils.join;

public class AcessarItinLogradouro {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		//Function that returns Selenium connection driver
		selenium = FunctionClass.startFirefoxURL("http://www2.portoalegre.rs.gov.br/");	
	}

	@Test
	public void testAcessarItinLogradouro() throws Exception {
		selenium.open("/eptc/default.php?p_secao=158");
		selenium.openWindow("http://www.eptc.com.br/EPTC_Itinerarios/Lograd1.asp", "LogWindow");
		selenium.selectWindow("LogWindow");
		selenium.select("name=Logradouro", "LogWindow");
	
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
