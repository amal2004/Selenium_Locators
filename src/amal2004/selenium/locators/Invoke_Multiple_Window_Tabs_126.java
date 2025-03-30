package amal2004.selenium.locators;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Invoke_Multiple_Window_Tabs_126 {

	static WebDriverWait wait;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/");

		// Open new tab

		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();

		String parentWinid = it.next();

		String childwindow = it.next();

		String angu = it.next();
		
		

		driver.switchTo().window(childwindow);

		Thread.sleep(5000);
		driver.get("https://courses.rahulshettyacademy.com/courses");

		// Wait for elements to be present

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='course-listing-title']")));

		// Get the list of elements

		java.util.List<WebElement> courses = driver.findElements(By.cssSelector("[class='course-listing-title']"));

		// Check if the desired index exists before accessing it

		int index = 0; // Change to any index you want to test

		String courseName = "";

		if (courses.size() > index) {

			courseName = courses.get(index).getText();

			driver.switchTo().window(angu);
			Thread.sleep(5000);
			driver.get("https://rahulshettyacademy.com/angularpractice/");

			driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);

		} else {

			System.out.println("Index " + index + " is out of bounds. Available elements: " + courses.size());

		}

	}

}
