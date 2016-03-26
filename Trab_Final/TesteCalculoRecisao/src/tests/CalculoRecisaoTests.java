package tests;
import static org.junit.Assert.*;

import java.text.DecimalFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import Pages.CalculoRecisaoPage;

public class CalculoRecisaoTests {
	private WebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private CalculoRecisaoPage pagina;
    
	//Fabrizio Gustavo Ruas Brusca
	
	@Before
	public void setUp() throws Exception {
		driver = Driver.createDrive("/calculo/rescisao-clt");
		pagina = new CalculoRecisaoPage(driver);	
	}
    
	
	@Test
	public void testeTabelaResutadosExiste() throws Exception {			
		pagina.setInputCampo("Entrada_UltimoSalario", "2000,00");
		pagina.setInputCampo("Entrada_DataInicioTrabalho", "01/01/2010");		
		pagina.setInputCampo("Entrada_DataFimTrabalho", "10/10/2016");
		pagina.setDropDownValue("Entrada_Motivo", "Término de contrato de experiência");
		pagina.clickButton("Calcular");
		
		//double quantidade = Double.parseDouble(pagina.getResultadoFinal());
		//DecimalFormat formato = new DecimalFormat("#,###.00");
		
		if(pagina.getResultadoFinal() != null){
			
		}else{
			throw new Exception();
		}
		
	}
	
	@Test
	public void testeValorTOtalMaiorZero() throws Exception{
		pagina.setInputCampo("Entrada_UltimoSalario", "2000,00");
		pagina.setInputCampo("Entrada_DataInicioTrabalho", "01/01/2010");		
		pagina.setInputCampo("Entrada_DataFimTrabalho", "10/10/2016");
		pagina.setDropDownValue("Entrada_Motivo", "Término de contrato de experiência");
		pagina.clickButton("Calcular");
		
		double quantidade = Double.parseDouble(pagina.getResultadoFinal());
		
		assertNotEquals(quantidade, 0);		
	}
	
	@Test
	public void testeDataInicioMaiorFim() throws Exception{
		pagina.setInputCampo("Entrada_UltimoSalario", "2000,00");
		pagina.setInputCampo("Entrada_DataInicioTrabalho", "01/01/2005");		
		pagina.setInputCampo("Entrada_DataFimTrabalho", "10/10/2011");
		pagina.setDropDownValue("Entrada_Motivo", "Término de contrato de experiência");
		pagina.clickButton("Calcular");
		
		assertTrue(pagina.formDataError());
	}
	
	
	@Test
	public void AvisoPrevioIndenizado() throws Exception{
		pagina.setInputCampo("Entrada_UltimoSalario", "8000,00");
		pagina.setInputCampo("Entrada_DataInicioTrabalho", "01/01/2005");		
		pagina.setInputCampo("Entrada_DataFimTrabalho", "10/10/2015");
		pagina.setDropDownValue("Entrada_Motivo", "Pedido de demissão");
		
		pagina.setDropDownValue("Entrada_TipoAvisoPrevio", "Indenizado");
		pagina.clickButton("Calcular");
		
		double valor = Double.parseDouble(pagina.getResultadoFinal());
		
		assertEquals(7120.53, valor, 0.01);
		
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
