package amal2004.selenium.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSL_HTTPS {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		
		ChromeOptions chOptions = new ChromeOptions();
		
		//How to bypass bad SSL certificates 
		chOptions.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(chOptions);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());



	}

}
