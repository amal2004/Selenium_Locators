package amal2004.selenium.locators;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart_Base {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
	    // Commented because we used explicit wait only for where we want it
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String[] itemsNeedToAdd = { "Tomato", "Cucumber", "Beetroot" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		Thread.sleep(3000);
		addItems(driver, itemsNeedToAdd);
		
		//Use alt tag text to find the element
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
		//Use the button text to find the element
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		//There's delay page loading from proceed to checkout to promo code page. we add ex.wait
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='promoCode']")));
		
		//Without time out, this will give an error because Selinium compiler runs faster than real website 
		// and when compiler is on promocode text box, website is still loading. Need to slow down compiler with time out to resolve this
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		// Explicit wait added here because we need time out only here. Implicit wait will add time out to each line
		
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	}

	public static void addItems(WebDriver driver, String[] itemsNeedToAdd) {

		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		
		for (int i = 0; i < products.size(); i++) {
			
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			List<String> itemsNeedList = Arrays.asList(itemsNeedToAdd);

			if (itemsNeedList.contains(formattedName)) {

				j++;
				// driver.findElements(By.xpath("//button[class='ADD TO
				// CART']")).get(i).click();

				/*
				 * Above code We used text of the button "Add to cart" to find elements to
				 * click. Since it changes to "Added to cart", index count is incorrect and
				 * wrong itmes count to add to cart. So we use class of the button and then add
				 * button element as parent to select entier thing. In this way, we resolve
				 * above issue
				 */
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeedToAdd.length) {
					break;
				}
			}

		}

	}

}
