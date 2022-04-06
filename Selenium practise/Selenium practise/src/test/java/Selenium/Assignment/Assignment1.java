package Selenium.Assignment;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {


	public static void main(String[] args) throws IOException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\madhavik\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.snapdeal.com/"); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ExcelReadUsingSheetAndColumnName e=new ExcelReadUsingSheetAndColumnName(".\\Datafiles\\ExcelRead.xlsx");
		String TestcaseID=e.getCelldata("data","TestCase_ID",2);
		String Title=e.getCelldata("data","Title",2);
		String Url=e.getCelldata("data","Url",2);	
		System.out.println(TestcaseID+"|"+Title+"|"+Url);

		// Validate the actual page title with expected page title using assert equals method 
		String ActualTitle = driver.getTitle(); 
		System.out.println("Actual_Title: "+ActualTitle+"Exp_Title: "+Title); 
		Assert.assertEquals(Title, ActualTitle); 
		System.out.println("Validation pass-Title matched"); 

		// Validate the actual url with expected url using assert equals method 
		String actual_url=driver.getCurrentUrl(); 
		System.out.println("Actual_Url: "+actual_url+"Exp_Url: "+Url); 
		Assert.assertEquals(actual_url, Url); 
		System.out.println("Validation pass-Url matched"); 

		//Validate the actual page title with expected page title using If-else statement 
		if(ActualTitle.equals(Title)){ 
			System.out.println("Title matched- Snapdeal website launched successfully!!"); 

		}else 
			System.out.println("Title not matched-test fail"); 
		//	driver.close(); 
	}

}