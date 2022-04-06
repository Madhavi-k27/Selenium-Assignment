package pageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.GenericActions;
import utilities.PageActions;

public class HomePageobjects {

	WebDriver driver=null;
	PageActions action;
	GenericActions genricActions;
	public HomePageobjects(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		action=new PageActions(driver);
		genricActions=new GenericActions();
	}

	//Men's Fashion Elements
	
	@FindBy(xpath="(//span[contains(text(),'Men')])[1]")
	public static WebElement mencategory;
	@FindBy(xpath="(//span[text()='Sports Shoes'])[1]")
	WebElement shoes;

	//Automotives Elements
	@FindBy(xpath="//span[contains(text(),'Automotives')]")
	public static WebElement automotives;
	@FindBy(xpath="//span[contains(text(),'Helmets & Accessories')]")
	WebElement helmet;

	//Hover on Men's Fashion
	public void hoverMensFashion() {
		action.waitForVisibleElement(driver, mencategory, 30);
		genricActions.hoverOnElement(driver, mencategory, "Men's Fashion category ");
		Assert.assertTrue(mencategory.isEnabled(), "MensFashion element is enabled.");
		System.out.println(mencategory.isEnabled());
		/*String menheader= mencategory.getText();
		System.out.println("menheader: "+menheader);*/
	}

	//click on shoes
	public void clickOnShoes() {
		Assert.assertTrue(shoes.isEnabled(), "shoes element is enabled.Return: "+shoes.isEnabled());
		action.waitForClickElement(driver, shoes, 10);
		genricActions.clickButton(driver, shoes, "Sports shoes");

	}
	//navigateback
	//Automotives
	
	public void hoveronAutomotives() {
		action.waitForVisibleElement(driver, automotives, 10);
		genricActions.hoverOnElement(driver, automotives, "Automotives element");
		Assert.assertTrue(automotives.isEnabled(), "Automotive element is enabled.Return: "+automotives.isEnabled());
	}

	public void clickOnHelmet() {
		Assert.assertTrue(helmet.isEnabled());
		System.out.println("Helmet element is enabled."+helmet.isEnabled());
		action.waitForClickElement(driver, helmet, 10);
		//helmet.click();
		genricActions.clickButton(driver, helmet, "helmets & Accessories");


	}

}


