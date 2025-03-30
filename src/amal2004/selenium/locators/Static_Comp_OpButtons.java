package amal2004.selenium.locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Static_Comp_OpButtons {

	public static void main(String[] args) throws InterruptedException {
		
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			driver.manage().window().maximize();			
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			
			driver.findElement(By.id("divpaxinfo")).click();

			Thread.sleep(2000L);


			/*int i=1;

			while(i<5)

			{

			driver.findElement(By.id("hrefIncAdt")).click();

			i++;

			}*/

			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

			for(int i=1;i<5;i++)

			{

			driver.findElement(By.id("hrefIncAdt")).click();

			}


			driver.findElement(By.id("btnclosepaxoption")).click();

			Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
