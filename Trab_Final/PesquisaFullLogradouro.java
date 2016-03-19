
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import functions.FunctionClassDriver;

public class PesquisaFullLogradouro {
  private WebDriver driver;  
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  driver = FunctionClassDriver.startFirefoxDriver("http://www.eptc.com.br/EPTC_Itinerarios/Lograd1.asp");
  }

  @Test
  public void testPesquisaFullLogradouro() throws Exception {    
    new Select(driver.findElement(By.name("Logradouro"))).selectByVisibleText("ADELINO FERREIRA JARDIM , AV");
    driver.findElement(By.cssSelector("input.FormatoBotao")).click();
    try {
      assertEquals("6624 - RUBEM BERTA (GREVE NORTRAN) - BAIRRO/CENTRO", driver.findElement(By.xpath("//div[@id='tabs-1']/p/table/tbody/tr[2]/td/font/b")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.name("Action")).click();
    driver.findElement(By.cssSelector("input.formatoBotao")).click();
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
