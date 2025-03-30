package amal2004.selenium.locators;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindowTab {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		
		
		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> itw = windows.iterator();
		String parentid = itw.next();
		Thread.sleep(50000);
		String childId = itw.next();
		Thread.sleep(50000);
		String angu = itw.next();
		
		
		driver.switchTo().window(childId);
	    driver.get("https://rahulshettyacademy.com/");
	    
	    Thread.sleep(50000);
	    driver.switchTo().window(angu);
	    driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		
	}

}
