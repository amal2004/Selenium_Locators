package amal2004.selenium.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Table_Grids_Page {

	public static void main(String[] args) {

		// selects 4th entire column Xpath //td[4] - - CSS td:nth-child(4)

		// .tableFixHead td:nth-child(3) - select parent table and then column

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		
		// Get the sum of the values of 4th column
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead  td:nth-child(4)"));
		
		int total = 0;
		for (int i = 0; i < values.size(); i++) {
			
		 total = total +	Integer.parseInt(values.get(i).getText());
		 
		}
		
		System.out.println(total);
		
		//driver.findElement(By.cssSelector(".totalAmount")).getText();
		int sum =  Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(total, sum);
		
	}

}
