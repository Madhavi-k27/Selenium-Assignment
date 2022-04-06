package Tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageFactory.HomePageobjects;
import utilities.Propertyclass;

public class HomePageTest {
	WebDriver driver;
	HomePageobjects homepage=new HomePageobjects(driver);
	//HomePageobjects homepage=
//	PageFactory.initElements(driver, homepage);
	
	@Test(priority=0)
	//Homepage Validation 		
	public void ShoeshomePageTC(){
		String eurl=Propertyclass.readurlProperty("eurl");
		System.out.println("Actual_url: "+driver.getCurrentUrl()+"\n"+"Expected_url:"+ eurl); 
		Assert.assertEquals(driver.getCurrentUrl(), eurl); 
		System.out.println("--------------Validation1 pass-HomepageUrl matched----------"); 
		homepage.hoverMensFashion();
		homepage.clickOnShoes();
	}
	@Test(priority=3)
	public void HelmetHomepageTC(){
	homepage.hoveronAutomotives();
	homepage.clickOnHelmet();

}
}