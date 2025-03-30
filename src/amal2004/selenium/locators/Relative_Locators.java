package amal2004.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;


public class Relative_Locators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameEditBox =  driver.findElement(By.cssSelector("[name='name']"));
		
		//----- Above
		// Find the tag "label" above name Edit box and get the text. Will print label text
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		
		//------- Below
		// Here we give reference to label date of birth and ask to go below and find tag input and click
		// Here right below label, input tag is flex html and this will ignore and pick the button as input and click
		
		WebElement dateofBirthLbl =  driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateofBirthLbl)).click();
		
		
		//------- Left
		// Find the check box left to the label text of check me out.. and click
		WebElement CheckmeoutLbl =  driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(CheckmeoutLbl)).click();
		
		
		//------- Right
		WebElement rdb = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());


		
		

	}

}
