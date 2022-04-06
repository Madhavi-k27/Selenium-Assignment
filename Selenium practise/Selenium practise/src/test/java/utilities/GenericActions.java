package utilities;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GenericActions {

	//Click button
	public WebDriver clickButton(WebDriver driver,WebElement ele,String buttonName){
		ele.click();
		return driver;
	}
	//Navigate back
	public WebDriver navigateBack(WebDriver driver){
		driver.navigate().back();
		return driver;
	}


	//textbox--@FindBy
	public WebDriver textBoxUsingPageFactory(WebDriver driver, WebElement ele,String textValue){
		ele.sendKeys(textValue+Keys.ENTER);
		return driver;
	}
	//textbox--By class
	public WebDriver textBoxUsingBy(WebDriver driver, By locator,String textValue){
		driver.findElement(locator).sendKeys(textValue+Keys.ENTER);
		return driver;
	}
	

	//Mouse action-hoverOn
	public WebDriver hoverOnElement(WebDriver driver,WebElement ele,String ElementName) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).perform();
		return driver;
	}

	//dropdown
	public WebDriver dropDownAction(WebDriver driver,WebElement ele,String textValue) {
		Select select=new Select(ele);
		//select.selectByIndex(index);
		select.selectByValue(textValue);
		select.selectByVisibleText(textValue);
		List<WebElement> listOfOptions=select.getOptions();
		int size=listOfOptions.size();
		System.out.println("Number of elements: "+size);
		/*select option using sendKeys
	ele.sendKeys(textValue);
		 */
		return driver;
	}

	//Alerts

	public WebDriver alertActions(WebDriver driver,WebElement ele) {
		ele.click();
		Alert alert =driver.switchTo().alert();
		alert.accept();
		return driver;
	}
	//Alerts-Prompt box
	public WebDriver promptBox(WebDriver driver,WebElement ele,String textValue) {
		ele.click();
		Alert alert =driver.switchTo().alert();	
		alert.sendKeys(textValue);//incase of prompt box
		return driver;
	}
	//CheckBox
	public WebDriver checkBox(WebDriver driver,WebElement ele ){
		ele.click();//1.select eleele
		/*if(ele.isSelected()) {
		System.out.println(ele.isSelected());//2.if true it will deselects and if its false it will select
		ele.click();
		*/
		return driver;
	}

		//Radio Button--select only one option

		public WebDriver radioButton(WebDriver driver,WebElement ele,String buttonName){
			ele.click();
			boolean status=ele.isSelected();
			System.out.println("status: "+status);
			return driver;
		}


	}
