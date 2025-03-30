package amal2004.selenium.locators;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filter_web_table_Streams {

	public static void main(String[] args) {
	
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();

			
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
			
			driver.findElement(By.id("search-field")).sendKeys("Rice");
			
			// Get all elements in 1st column after entering rice. Which should be 1 result
		    List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
			
		    List<WebElement> filterdVegList = veggies.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
			
		    Assert.assertEquals(veggies.size(), filterdVegList.size());
			
	}

}
