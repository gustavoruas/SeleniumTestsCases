package Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CalculoRecisaoPage {

	private WebDriver pdriver;
	
	public CalculoRecisaoPage(WebDriver driver){
		pdriver = driver;
	}
	
	public WebElement mapearElemento(String id) {
		WebElement element = pdriver.findElement(By.id(id));
		
		return(element);
	}
	
	public void setInputCampo(String id, String valor){
		WebElement element = pdriver.findElement(By.id(id));		
		element.clear();
		element.sendKeys(valor);
		
	}
	
	public String getInputCampo(String id, String valor){
		return (pdriver.findElement(By.id(id)).getText());
		
	}
	
	public void setDropDownValue(String id, String valor){
		
		WebElement element = pdriver.findElement(By.id(id));
		
		Select dropdown = new Select(element);
		
		dropdown.selectByVisibleText(valor);
		
	}
	
	public void clickButton(String str){		
		pdriver.findElement(By.xpath("//input[@value='"+str+"'][@type='submit']")).click();
	}
	
	public String getResultadoFinal(){
		
		String resultado;
		
		resultado = pdriver.findElement(By.xpath("//td[@class='c CellNumeric ColumnResult']")).getText();
		
		resultado = resultado.replaceAll("[R$ ]", "");
		resultado = resultado.replaceAll("[.]", "");
		resultado = resultado.replaceAll("[,]",".");
		
		return resultado;
		
	}
	
	public boolean formDataError(){
		
		try{
			if(!pdriver.findElements(By.xpath("//div[@class='validation-summary-errors']")).isEmpty()){
				return true;
			}else{
				return false;
			}
		}catch(NoSuchElementException e){
			return false;
		}	
		
	}
}
