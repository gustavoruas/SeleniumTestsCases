package Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculoDecTerPage extends CalculoRecisaoPage{
	
	private WebDriver pdriver;
	
	public CalculoDecTerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean validaErroForm(){
		try{
			if(!pdriver.findElements(By.xpath("//div[@class='alert-danger alert']")).isEmpty()){
				return true;
			}else{
				return false;
			}
		}catch(NoSuchElementException e){
			return false;
		}	
	}

}
