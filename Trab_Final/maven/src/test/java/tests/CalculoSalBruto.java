package tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import Pages.CalculoRecisaoPage;

public class CalculoSalBruto {

	private WebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private CalculoRecisaoPage pagina;
    
	//Fabrizio Gustavo Ruas Brusca
	
	@Before
	public void setUp() throws Exception {
		driver = Driver.createDrive("/calculo/salario-bruto");
		pagina = new CalculoRecisaoPage(driver);	
	}
	
	@Test
	public void testeTabelaResutadosExiste() throws Exception {			
		pagina.setInputCampo("Entrada_SalarioLiquido", "2000,00");
		pagina.setInputCampo("Entrada_NumDependentes", "0");		
		pagina.setInputCampo("Entrada_OutrosDescontos", "50");
		
		pagina.clickButton("Calcular");
		
		//double quantidade = Double.parseDouble(pagina.getResultadoFinal());
		//DecimalFormat formato = new DecimalFormat("#,###.00");
		
		if(pagina.getResultadoFinal() != null){
			
		}else{
			throw new Exception();
		}
		
	}
	
	
	
	@After
	public void tearDown() throws Exception {
		// driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	
}
