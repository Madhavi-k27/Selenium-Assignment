package pageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Tests {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		FileInputStream fis=new FileInputStream("Config.properties");
		Properties p=new Properties();
		p.load(fis);
		String Helmetpage_title=p.getProperty("Helmetpagetitle");
		String expurl=p.getProperty("eurl");

		//Homepage Validation 		
		System.out.println("Actual_Url: "+driver.getCurrentUrl()+"\n"+" Expected url:"+ expurl); 
		Assert.assertEquals(driver.getCurrentUrl(), expurl); 
		System.out.println("Validation1 pass-Url matched"); 

			
		PageFactory.initElements(driver, HomePageobjects.class);	

		Actions actions = new Actions(driver);
		/*actions.moveToElement(Pageobjects.auto).perform();
		Pageobjects.helmet.click();
		String header=Pageobjects.header.getText();
		System.out.println("Header:"+header);
		Pageobjects.sortby.click();
		Pageobjects.fresharrivals.click();
		String cardTitle=Pageobjects.product_title.getText();
		System.out.println("cardTitle:"+cardTitle);
		String cardPrice=Pageobjects.card_price.getText();
		System.out.println("cardPrice:"+cardPrice);

*/		// Helmetpage validation
		String eTitle = Helmetpage_title;
		String aTitle = driver.getTitle();
		if (aTitle.equalsIgnoreCase(eTitle))
		{
			System.out.println( "Test Passed") ;
		}
		else {
			System.out.println( "Test Failed" );
		}
		driver.close();
	}

}