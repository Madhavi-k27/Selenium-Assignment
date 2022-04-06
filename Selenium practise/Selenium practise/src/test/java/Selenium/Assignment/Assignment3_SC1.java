package Selenium.Assignment;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment3_SC1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.snapdeal.com/"); 
		driver.manage().window().maximize();

		FileInputStream fis=new FileInputStream("Config.properties");
		Properties p=new Properties();
		p.load(fis);
		String Helmetpage_title=p.getProperty("Helmetpagetitle");
		String expurl=p.getProperty("eurl");

		//Homepage Validation 		
		String actual_url=driver.getCurrentUrl(); 
		System.out.println("Actual_Url: "+actual_url+"\n"+"Exp_Url: "+expurl); 
		Assert.assertEquals(actual_url, expurl); 
		System.out.println("Validation1 pass-Url matched"); 

		//Automotives
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		//div[@id='leftNavMenuRevamp']/div/div[2]/ul/li[7]/a/span"		
		WebElement auto=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Automotives')]")));
		Actions actions = new Actions(driver);
		actions.moveToElement(auto).perform();
		if(auto.isEnabled()) {
			System.out.println("Automotive element is enabled.Return: "+auto.isEnabled());
		}
		
		//Helmets & Accessories
		//div[@id='category6Data'/]/div[2]/div/div/p[7]//span[@class='headingText']
		WebElement helmet=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Helmets & Accessories')]")));
		if(helmet.isEnabled()) {
			System.out.println("Helmet element is displayed.Return: "+helmet.isEnabled());
		}
		helmet.click();

		//Header
		//div[@class='category-name-wrapper clearfix ']//h1
		//h1[contains(text(),'Helmets & Accessories')]
		WebElement header=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Helmets & Accessories')]")));
		System.out.println("Header:"+header.getText());
		if(header.isDisplayed()) {
			System.out.println("header is displayed on webpage.Return:"+header.isDisplayed());
		}
		//SortBy
		//div[@class='category-name-wrapper clearfix ']//i)[2]
		WebElement dropmenu=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")));
		//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']
		dropmenu.click();
		if(dropmenu.isEnabled()) {
			System.out.println("Sortby element is enabled.Return:"+dropmenu.isEnabled());
		}
		
		//Filter byFreshArrivals
		String efresharrivals=p.getProperty("FreshArrivaltext");
		List<WebElement> list=	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='sort-value']//li")));		
		for (WebElement webelement : list) {
			String sortvalue=webelement.getText();
			System.out.println("Sortby_values:"+sortvalue);
			if(sortvalue.equals(efresharrivals)) {
				webelement.click();
				}
			if(webelement.isSelected()) {
				System.out.println("Fresh Arrivals option is selected.Return: "+webelement.isSelected());
			}
		}
		//Print Card Title
		WebElement product_title=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='product-tuple-description ']//p)[1]")));
		System.out.println("Card title:"+ product_title.getText());
		if(product_title.isDisplayed()) {
			System.out.println("card title is displayed on webpage.Return: "+product_title.isDisplayed());	
		}

		//Print Card Price
		//div[@class='product-tuple-description ']//p//following-sibling::div)[1]//span[@class="lfloat product-price"]
		WebElement card_price=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='product-tuple-description ']//p//following-sibling::div)[1]//span[@class='lfloat product-price']")));
		System.out.println("Card price:"+card_price.getText());
		if(card_price.isDisplayed()) {
			System.out.println("card_price is displayed on webpage.Return: "+card_price.isDisplayed());	
		}
		//Helmet page validation
		String eTitle = Helmetpage_title;
		String aTitle = driver.getTitle();
		if (aTitle.equalsIgnoreCase(eTitle)){
			System.out.println( "Test Passed") ;
		}
		else 
			System.out.println( "Test Failed" );

		driver.close();

	}
}