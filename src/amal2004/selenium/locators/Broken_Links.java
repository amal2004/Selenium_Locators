package amal2004.selenium.locators;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Broken_Links {

	public static void main(String[] args) throws MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		
		for (WebElement webElement : links) {
			String url = webElement.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			
			System.out.println(respCode);
			
			if (respCode>403) {
				System.out.println("The link with text: " + webElement.getText()+ " is broken with code " + respCode);
				Assert.assertTrue(false);
				
				
			}
		}


		/*
		 * Broken URL
		 * 
		 * Step 1: Get all URL for the links using Selenium Step 2:Use Java methods to
		 * call URLs and get status code Step 3:If status code >400 then its broken ursl
		 * Below for single link
		 */

		// a[href*='soapui'] - here soapui is the full or part of url
		/*
		 * String url =
		 * driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute(
		 * "href");
		 * 
		 * HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		 * conn.setRequestMethod("HEAD"); conn.connect(); int respCode =
		 * conn.getResponseCode();
		 */
		//System.out.println(respCode);
		

	}

}
