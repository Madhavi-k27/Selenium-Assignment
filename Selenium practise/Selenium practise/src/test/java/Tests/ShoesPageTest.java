package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageFactory.ShoesPageObjects;

public class ShoesPageTest {
	WebDriver driver;
	ShoesPageObjects shoespage=PageFactory.initElements(driver, ShoesPageObjects.class);
	@Test(priority=1)
	public void shoehome() throws InterruptedException{
	shoespage.printShoeHeader();
	shoespage.shoeCardTitle();
	shoespage.shoeCardPrice();
	shoespage.enterPincode();
}

}