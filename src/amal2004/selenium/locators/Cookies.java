package amal2004.selenium.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		//Window maximize 
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().deleteCookieNamed("cookie name");
		
		// driver.manage().addCookie("cookie name");
		
		// Interview ques. How to redirect to login page for verification when any link clicked
		// 1. driver.manage().deleteCookieNamed("cookie name");
		// 2. click on any link
		// 3. veruify the the url is login
		
		
		
		

	}

}
