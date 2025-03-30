package amal2004.selenium.locators;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Web_Table_Cus_Sele_Methods_PriceOfEachVegi {
	
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
		
		// Click on Column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//Capture all web elements into a list
	    List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
	    
	    // Capture text of all web elements (Original list)
	    //In Java Streams, the map() method is used to transform each element of a stream into a new element
	    // Here use map to convert webelement to string text
	    List<String> orgList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
	    //	Apply sort into the list(Sorted list)
	    List<String> sortedList = orgList.stream().sorted().collect(Collectors.toList());

	    
	    Assert.assertTrue(orgList.equals(sortedList));
	    
	    
	    // Get the price of rice
	    // ********** Scan the names column and when it hits rice - get text and get the price of rice.
	    
	    List<String> price = elementsList.stream().filter(s->s.getText().contains("Beans")).
	    map(s-> getPriceOfVegi(s)).collect(Collectors.toList());
	    price.forEach(a->System.out.println(a));
	    
	    
	    
	}
	
		//   --  //tr/td[1]/following-sibling::td[1] -> /following-sibling::td[1] This will travers to next column which is price

		private static String getPriceOfVegi(WebElement s) {
	
			
			// Here we do not put entire xpath which is //tr/td[1]/following-sibling::td[1] 
			// To the method we send webelement which has beans element. We have to travers to next webelement price
			// So we only put travese to sibling part
			String pricevl = s.findElement(By.xpath("following-sibling::td[1]")).getText();
			return pricevl;
		}

}
