
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import functions.FunctionClassDriver;

public class AbrirTabelaHorario {
  private WebDriver driver;  
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	driver = FunctionClassDriver.startFirefoxDriver("http://www.eptc.com.br/EPTC_Itinerarios/linha.asp");    
  }

  @Test
  public void testAbrirTabelaHorarioT4() throws Exception {    
    String parentHandle = driver.getWindowHandle();
	  
	driver.findElement(By.xpath("//div[@id='principal']/div[2]/table/tbody/tr/td/table/tbody/tr/td[4]/a/font")).click();
    driver.findElement(By.xpath("(//input[@name='Tipo'])[2]")).click();
    new Select(driver.findElement(By.name("Linha"))).selectByVisibleText("T4 - TRANSVERSAL 4");
    driver.findElement(By.cssSelector("input.FormatoBotao")).click();
    
    //focus in new opened window.
    for(String winHandle : driver.getWindowHandles()){    	
    	if(winHandle != parentHandle){
    	   driver.switchTo().window(winHandle);
    	}    	
    }
    
    assertEquals("T4 - TRANSVERSAL 4", driver.findElement(By.xpath("//div[@id='principal']/div[2]/table/tbody/tr/td/div[2]/font/b")).getText());
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
