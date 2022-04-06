package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageFactory.HelmetPageObjects;
import utilities.Propertyclass;

public class HelmetPageTest {
	WebDriver driver;
	HelmetPageObjects helmetpage=PageFactory.initElements(driver,HelmetPageObjects.class);
	@Test(priority=4)
	public void helmetTC(){
	helmetpage.printHelmetHeader();
	helmetpage.sortBy();
	helmetpage.freshArrivals();
	helmetpage.cardTitle();
	helmetpage.cardPrice();
	// Helmet_Page validation
	String Helmetpage_title=Propertyclass.readtitleProperty("Helmetpagetitle");
	String eTitle = Helmetpage_title;
	String aTitle = driver.getTitle();
	Assert.assertEquals(aTitle, eTitle);

}
}