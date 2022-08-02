package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class page_object {

	
		static WebElement element =null;
		// TODO Auto-generated method stub
		public static WebElement textbox_person (WebDriver driver)
		{
			element = driver.findElement(By.xpath("//span[@class='buttonText-3DCCO'][text()='In-Person']"));  
			return element;
		}
		
		public static WebElement searchbox (WebDriver driver)
		{
			element = driver.findElement(By.id("location-search"));
			return element;
			
		}
		public static WebElement searchbox_button (WebDriver driver)
		{
			element = driver.findElement(By.id("location-search-cta"));
			return element;
			
		}
		
		public static WebElement Business_hours (WebDriver driver)
		{
			 element = driver.findElement(By.xpath("//div[@class='title-3o8Pv']"));
			return element;
			
		}
		
				

}



