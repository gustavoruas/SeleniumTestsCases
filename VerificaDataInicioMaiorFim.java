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

public class VerificaDataInicioMaiorFim {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://adam.goucher.ca/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testVerificaDataInicioMaiorFim() throws Exception {
		selenium.open("/parkcalc/");
		selenium.select("id=Lot", "label=Long-Term Surface Parking");
		selenium.click("css=img[alt=\"Pick a date\"]");
		selenium.waitForPopUp("DateTimePicker", "30000");
		selenium.selectWindow("name=DateTimePicker");
		selenium.click("link=12");
		selenium.selectWindow("null");
		verifyEquals("3/12/2016", selenium.getText("id=EntryDate"));
		selenium.click("xpath=(//img[@alt='Pick a date'])[2]");
		selenium.waitForPopUp("DateTimePicker", "30000");
		selenium.selectWindow("name=DateTimePicker");
		selenium.click("link=6");
		selenium.selectWindow("null");
		verifyFalse(selenium.isTextPresent("id=ExitDate"));
		selenium.click("name=Submit");
		selenium.waitForPageToLoad("30000");
		assertEquals("ERROR! Your Exit Date Or Time Is Before Your Entry Date or Time", selenium.getText("css=b"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
