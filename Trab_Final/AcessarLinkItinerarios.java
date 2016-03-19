

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import functions.FunctionClass;
//import static org.apache.commons.lang3.StringUtils.join;

public class AcessarLinkItinerarios {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		//Function that returns Selenium connection driver
		selenium = FunctionClass.startFirefoxURL("http://www2.portoalegre.rs.gov.br/");			
	}

	@Test
	public void testAcessarLinkItinerarios() {
		boolean fin_assert; 
		
		selenium.open("/eptc/default.php?p_secao=158");
		//selenium.click("link=Itinerários e Horários de ônibus");
		selenium.waitForPageToLoad("30000");
		assertEquals("Por Logradouros", selenium.getText("link=Por Logradouros"));		
		assertEquals("Por Bacia e por Linha", selenium.getText("link=Por Bacia e por Linha"));
		assertTrue(selenium.getLocation().matches("^http://www2\\.portoalegre\\.rs\\.gov\\.br/eptc/default\\.php[\\s\\S]p_secao=158$"));		
		
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
