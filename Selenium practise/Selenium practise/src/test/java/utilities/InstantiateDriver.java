package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InstantiateDriver {
	public static WebDriver driver;
	public static WebDriver invokeDriver(){
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		 driver.get("https://www.snapdeal.com/");
		return driver;

	}
}