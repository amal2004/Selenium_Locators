package amal2004.selenium.locators;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		
		driver.findElement(By.xpath("//a[contains(text(),'Free Access to')]")).click();
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String>itw = windows.iterator();
		String parentid= itw.next();
		String childId= itw.next();
		driver.switchTo().window(childId);
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String emailid = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(emailid);
		driver.switchTo().window(parentid);
		driver.findElement(By.id("username")).sendKeys(emailid);
		
		
		
		
	}
	
	
	
	

}
