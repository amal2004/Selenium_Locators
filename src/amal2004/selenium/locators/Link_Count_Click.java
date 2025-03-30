package amal2004.selenium.locators;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Link_Count_Click {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");

		// Count of the links of the page
		System.out.println(driver.findElements(By.tagName("a")).size());

		// Count of the links only footer of the page

		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		// Count of the links only 1st column footer of the page
		
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		
		// Click on each link in the column and check  if the pages are opening.
		
		for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
			
			//Error occoured because when open first page, its in a different page than original page
			// where we have links on the column. To fix, we press control + click to open in different tabs
			
			// Press control eneter together to open links in tabs
			String clickonLinktoOpen = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinktoOpen);
			
			//Time out because takes time to open 4 tabs
			Thread.sleep(5000);
			
		}
		
		//Used iterator to move to the tabs already opened in tabs and get title
		Set<String> tabTitles= driver.getWindowHandles();
	    Iterator<String> it = tabTitles.iterator();
	    
	    while(it.hasNext()) {
	    	
	    	driver.switchTo().window(it.next());
	    	System.out.println(driver.getTitle());
	    	
	    	
	    }

	}

}
