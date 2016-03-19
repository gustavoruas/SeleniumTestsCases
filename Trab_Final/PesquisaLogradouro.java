package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class PesquisaLogradouro {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://www2.portoalegre.rs.gov.br/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPesquisaLogradouro() throws Exception {
		selenium.open("/eptc/default.php?p_secao=158");
		selenium.openWindow("http://www.eptc.com.br/EPTC_Itinerarios/Lograd1.asp", "LogWindow");
		selenium.select("name=Logradouro", "label=EDVALDO PEREIRA PAIVA , AV");
		selenium.click("css=input.FormatoBotao");
		selenium.waitForPageToLoad("30000");
		verifyEquals("F993 - FUTEBOL BEIRA RIO - BAIRRO/CENTRO", selenium.getText("//div[@id='tabs-1']/p/table/tbody/tr[9]/td/font/b"));
		selenium.click("xpath=(//input[@name='Action'])[12]");
		// selenium.();
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
