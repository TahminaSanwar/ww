package maventesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pageObject.page_object;

public class WW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\SystemAdmin\\\\Downloads\\\\driver\\\\chromedriver.exe");							
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Navigate to WW Studio Finder page  https://www.weightwatchers.com/us/find-a-workshop/
		driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
		String actual_title = driver.getTitle();
		String expected_title ="Find WW Studios & Meetings Near You | WW USA";
		
		//Assert loaded page title contains “Find WW Studios & Meetings Near You | WW USA”	
		Assert.assertEquals(expected_title,actual_title,"Title Matched");
		
		// Under Find your Workshop, click on In-Person 
		//	driver.findElement(By.xpath("//span[@class='buttonText-3DCCO'][text()='In-Person']")).click();
		page_object.textbox_person(driver).click();
		
		// In the search field, search for meetings for zip code: 10011
		//driver.findElement(By.id("location-search")).clear();
		
		//driver.findElement(By.id("location-search")).sendKeys("10011");
		//driver.findElement(By.id("location-search-cta")).submit();
		page_object.searchbox(driver).sendKeys("10011");
		page_object.searchbox_button(driver).submit();
			
		
		//Print the title of the first result and the distance (located on the right of location title/name)
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='search-results']//a//div//div[@class='heading-3yCF-']//div"));
		System.out.println(elements.get(0).getText());
		List<WebElement> elements1 = driver.findElements(By.xpath("//div[@id='search-results']//a//div//div//span"));
	    System.out.println(elements1.get(0).getText());	
	
	    // Click on the first search result and then verify displayed location name/title matches with the name of the first searched result that was clicked.
	    boolean ww = driver.findElement(By.partialLinkText("WW Studio @ Chelsea")).isDisplayed();
	      if (ww) {
	         System.out.println("Verify displayed location");
	      } else {
	         System.out.println("Location is not Verified");
	      }
	      
	    driver.findElement(By.xpath("//a[normalize-space()='WW Studio @ Chelsea']")).click();
	    
		// Click on Business Hours
	   // driver.findElement(By.xpath("//div[@class='title-3o8Pv']")).click();
	    page_object.Business_hours(driver).click();
	    
	    // Create a method to print all the business hours for that studio
	    List<WebElement> elements2 = driver.findElements(By.className("hoursWrapper-1KHIv show-1db4o"));
		System.out.println(elements2.get(0).getText());
	    
	}

}
