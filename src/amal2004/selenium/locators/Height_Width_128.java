package amal2004.selenium.locators;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Height_Width_128 {

	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws IOException {

		String url = "https://rahulshettyacademy.com/angularpractice/";
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(url);

		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		String parentWindow = it.next();
		String childWindow = it.next();

		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com");

		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();
		// Check if the desired index exists before accessing it

		driver.switchTo().window(parentWindow);

		
		// Partiel Screenshot
		
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		
		// Height width 
		
		int height = name.getRect().getDimension().getHeight();
		int width = name.getRect().getDimension().getWidth();
		
		System.out.println(height + " " + width);

	}

}
