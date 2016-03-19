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

public class AcessarLinkItinerarios {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://www2.portoalegre.rs.gov.br/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testAcessarLinkItinerarios() throws Exception {
		selenium.open("/eptc/");
		selenium.click("link=Itinerários e Horários de ônibus");
		selenium.waitForPageToLoad("30000");
		verifyEquals("Por Logradouros", selenium.getText("link=Por Logradouros"));
		verifyEquals("Por Bacia e por Linha", selenium.getText("link=Por Bacia e por Linha"));
		assertTrue(selenium.getLocation().matches("^http://www2\\.portoalegre\\.rs\\.gov\\.br/eptc/default\\.php[\\s\\S]p_secao=158$"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
