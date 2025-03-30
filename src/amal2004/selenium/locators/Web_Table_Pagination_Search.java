package amal2004.selenium.locators;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Web_Table_Pagination_Search {

//	Click on Column
//	Capture all web elements into a list
//	Capture text of all web elements (Original list)
//	Apply sort into the list(Sorted list)
//	Compare both list and check if equal

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// ****** Select first column of table Xpath //tr/th[1]
		// ****** Select first column of table Xpath //tr/th[2]

		// ****** Select all columns and rows of table //tr/td
		// ****** Then to select only 1st column entirly //tr/td[1]

		List<String> priceList;

		do {

			// Capture all web elements into a list
			List<WebElement> elementsList2 = driver.findElements(By.xpath("//tr/td[1]"));

			// Get the price of rice
			// ********** Scan the names column and when it hits rice - get text and get the
			// price of rice.

			priceList = elementsList2.stream().filter(s -> s.getText().contains("Cheese")).
			map(s -> getPriceOfVegi(s)).collect(Collectors.toList());

			priceList.forEach(a -> System.out.println(a));
			// If beans found, priceList should be more than 1. If 0 mean not found in the
			// page. So we move to next page
			if (priceList.size() < 1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
			
		} while (priceList.size() < 1);

	}

	// -- //tr/td[1]/following-sibling::td[1] -> /following-sibling::td[1] This will
	// travers to next column which is price

	private static String getPriceOfVegi(WebElement s) {

		// Here we do not put entire xpath which is //tr/td[1]/following-sibling::td[1]
		// To the method we send webelement which has beans element. We have to travers
		// to next webelement price
		// So we only put travese to sibling part
		String pricevl = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevl;
	}

}
