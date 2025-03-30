package amal2004.selenium.locators;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;

public class Set_Chrm_Prox_Plug {

	// Refer to http://chromedriver.chromium/capabilities
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amalw\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		ChromeOptions chOptions = new ChromeOptions();
		// chOptions.addExtensions("Download and set the path to ext here");

		Proxy proxy = new Proxy();
		// proxy.setHttpProxy("ip add : port");
		// chOptions.setCapability("Proxy", proxy);

		
		// Disable pop-ups for location detection, notification etc
		// refer to the website above
		
		// Set download directory
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "C:\\Users\\amalw\\");
		chOptions.setExperimentalOption("prefs", prefs);
		
	}

}
