package amal2004.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.kohls.com");
		
		
		  Actions act = new Actions(driver);
		  
		   WebElement move = driver.findElement(By.cssSelector("span[id='nav-link-accountList-nav-line-1']"));		  
		   act.moveToElement(move).build().perform();
		  
		  
		  // Move to text box and enter hello in caps
		  act.moveToElement(driver.findElement(By.xpath("//input[@id='search']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		 
		
		  
	

	}

}
