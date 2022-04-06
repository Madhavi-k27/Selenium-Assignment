package pageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.GenericActions;
import utilities.PageActions;
import utilities.Propertyclass;

public class ShoesPageObjects {

	WebDriver driver=null;
	PageActions action;
	GenericActions generic=new GenericActions();
	public ShoesPageObjects(WebDriver driver){
		this.driver=driver;
		action=new PageActions(driver);
	}

	@FindBy(xpath="//h1[@class='category-name']")
	WebElement shoesHeader;

	@FindBy(xpath="(//div[@class='product-tuple-description ']//p)[1]")
	WebElement shoeCardTitle;

	@FindBy(xpath="(//span[@class='lfloat product-price'])[1]")
	WebElement shoeCardPrice;
	
	@FindBy(xpath="//div[@class='pincode-enter js-pincode-enter']/input")
	WebElement pincode; 
	
	@FindBy(xpath="//span[@id='myPincode']")
	WebElement pincodeVal;
	
			
	@FindBy(xpath="//button[text()='Check']")
	WebElement checkBtn;
	
	
	public void	enterPincode() throws InterruptedException{
		String pin=Propertyclass.readurlProperty("pincode");
		action.waitForVisibleElement(driver, pincode, 10);
		generic.textBoxUsingPageFactory(driver, pincode, pin);
		generic.clickButton(driver, checkBtn, "Checkbutton");
		Assert.assertTrue(pincodeVal.getText().matches(pin));
		System.out.println("Verify pincode matched-"+pincodeVal.getText()+"\n"+"Return : "+pincodeVal.getText().matches(pin));
		
		
	}

	public void printShoeHeader() {
		String shoeHeader=action.getTextOfElement(driver, shoesHeader, 20);
		System.out.println("Actual text of header: "+shoeHeader); 
		String Headertxt=Propertyclass.readtitleProperty("eShoeHeader");
		System.out.println("Expected text of header: "+Headertxt);
		Assert.assertEquals(shoeHeader, Headertxt);
		System.out.println("-------------------shoesHeaderText matched-------------------");
	}

	public void shoeCardTitle() {
		String shoeTitle=action.getTextOfElement(driver, shoeCardTitle, 10);
		System.out.println("shoeCardTitle: "+shoeTitle);

	}

	public void shoeCardPrice() {
		String shoePrice=action.getTextOfElement(driver, shoeCardPrice, 10);
		System.out.println("shoeCardPrice: "+shoePrice);
	}





}
