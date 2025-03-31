package amal2004.selenium.locators;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://spicejet.com"); // URL in the browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'one way')]")).click();

		driver.findElement(By.xpath("//div[contains(text(),'From')][1]")).click();

		driver.findElement(By.xpath("//div[contains(text(),'DEL')]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //div[contains(text(),'MAA')]"))
				.click();

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))

		{

			System.out.println("its disabled");

			Assert.assertTrue(true);

		}

		else

		{

			Assert.assertTrue(false);

		}

		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		driver.findElement(By.id("divpaxinfo")).click();

		Thread.sleep(2000L);

		for (int i = 1; i < 5; i++)

		{

			driver.findElement(By.id("hrefIncAdt")).click();

		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();

		driver.findElement(By.cssSelector("input[value='Search']")).click();

		// driver.findElement(By.xpath("//input[@value='Search']")).click();

		// driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();

	}

}
