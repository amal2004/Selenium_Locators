/*
 * Running the tests in cross browser and how to inspect objects in Edge &
 * Firefox
 * 
 * Identify locators using Siblings with Xpath traverse - example
 * 
 * How to Traverse from child element to parent element with xpath - Example
 * 
 * Automate Browser navigations and window properties with Selenium Webdriver
 */

package amal2004.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {
	// Sibling - Child to parent traverse
	//header/div/button[1]/following-sibling::button[1]
		
	
	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		
		// Sibling - Child to parent traverse
		
		//header/div/button[1]/following-sibling::button[1]
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//move from header to button 1(Practice) and from there, count 2 (Sign Up)
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[2]")).getText());
		
		//move from header to button 1(Practice) > then move to parent of button 1 which is div > then move to button 3 again -sign up
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[3]")).getText());


	}

	
	
	

}
