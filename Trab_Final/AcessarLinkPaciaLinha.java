

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import functions.FunctionClassDriver;

public class AcessarLinkPaciaLinha {
  private WebDriver driver;  
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = FunctionClassDriver.startFirefoxDriver("http://www2.portoalegre.rs.gov.br/eptc/default.php?p_secao=158");
    
  }

  @Test
  public void testAcessarLinkPaciaLinha() throws Exception {
    //Sets first parent window
	String parentHandle = driver.getWindowHandle() ;
    
    driver.findElement(By.linkText("Por Bacia e por Linha")).click();
    
    System.out.println(driver.getCurrentUrl());
    
    //focus in new opened window.
    for(String winHandle : driver.getWindowHandles()){
    	
    	if(winHandle != parentHandle){
    	   driver.switchTo().window(winHandle);
    	}
    	
    }
    
    try {
      assertEquals("http://www.eptc.com.br/EPTC_Itinerarios/linha.asp", driver.getCurrentUrl());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
