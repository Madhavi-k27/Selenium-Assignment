package pageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utilities.GenericActions;
import utilities.PageActions;
import utilities.Propertyclass;

public class HelmetPageObjects {

	WebDriver driver=null;
	PageActions action;
	GenericActions genricActions;
	public HelmetPageObjects(WebDriver driver){
		this.driver=driver;
		//PageFactory.initElements(driver, this);
		action=new PageActions(driver);
		genricActions=new GenericActions();
	}


	//@FindBy(xpath="//span[@class='category-name category-count']/preceding-sibling::h1")
	//@FindBy(xpath="//h1[contains(text(),'Helmets' )]")
	@FindBy(xpath="//h1[@category='Helmets & Accessories']")
	//@FindBy(xpath="//h1[contains(text(),'Helmets & Accessories')]")
	
	WebElement helmetHeaderText;

	@FindBy(xpath="//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")
	WebElement sortByMenu;

	@FindBy(xpath="//ul[@class='sort-value']/li")
	List<WebElement> freshArrivals ;

	@FindBy(xpath="(//div[@class='product-tuple-description ']//p)[1]")
	WebElement cardTitle;

	@FindBy(xpath="(//div[@class='product-tuple-description ']//p//following-sibling::div)[1]//span[@class='lfloat product-price']")
	WebElement cardPrice;


	public void printHelmetHeader() {
		Assert.assertTrue(helmetHeaderText.isDisplayed());
		System.out.println("helmetHeaderText is displayed. Return: "+helmetHeaderText.isDisplayed());
		//action.waitForVisibleElement(driver, helmetHeaderText, 10);
		String header=action.getTextOfElement(driver, helmetHeaderText, 10);
		//String header=helmetHeaderText.getText();
		String Headertxt=Propertyclass.readtitleProperty("eHeadertext");
		System.out.println("Actual header: "+header+"\nExpected header: "+ Headertxt); 
		Assert.assertEquals(header, Headertxt);
		System.out.println("----------------------Headertext matched------------------");

	}

	public void sortBy() {
		action.waitForVisibleElement(driver, sortByMenu, 10);
		Assert.assertTrue(sortByMenu.isEnabled(), "Sortby element is enabled.Return:"+sortByMenu.isEnabled());
		genricActions.clickButton(driver, sortByMenu, "sortBy dropDown menu");
	}

	public void freshArrivals() {
		action.waitForAllElements(driver, freshArrivals, 30);
		for (WebElement webelement : freshArrivals) {
			String sortValue=webelement.getText();
			System.out.println("Sortby_values:"+sortValue);
			if(sortValue.equals(Propertyclass.readurlProperty("FreshArrivaltext"))) {
				Assert.assertTrue(webelement.isDisplayed());
				System.out.println("freshArrivals option is present. Return:"+webelement.isDisplayed());
				genricActions.clickButton(driver, webelement, "freshArrivals dropDown");
			}
		}
	}

	public void cardTitle() {
		String helmetTitle=action.getTextOfElement(driver, cardTitle, 10);
		System.out.println("helmetTitle: "+helmetTitle);

	}

	public void cardPrice() {
		String helmetPrice=action.getTextOfElement(driver, cardPrice, 10);
		System.out.println("helmetPrice: "+helmetPrice);
	}
}



