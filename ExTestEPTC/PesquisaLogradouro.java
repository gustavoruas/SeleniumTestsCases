
//Exported as JUnit Webdriver Backed

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

public class PesquisaLogradouro {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		//Function that returns Selenium connection driver
		selenium = FunctionClass.startFirefoxURL("http://www2.portoalegre.rs.gov.br/");	
	}

	@Test
	public void testPesquisaLogradouro() throws Exception {
		selenium.open("/eptc/default.php?p_secao=158");
		selenium.openWindow("http://www.eptc.com.br/EPTC_Itinerarios/Lograd1.asp", "LogWindow");
		selenium.select("name=Logradouro", "label=EDVALDO PEREIRA PAIVA , AV");
		selenium.click("css=input.FormatoBotao");
		selenium.waitForPageToLoad("30000");
		assertEquals("F993 - FUTEBOL BEIRA RIO - BAIRRO/CENTRO", selenium.getText("//div[@id='tabs-1']/p/table/tbody/tr[9]/td/font/b"));
		selenium.click("xpath=(//input[@name='Action'])[12]");		
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
