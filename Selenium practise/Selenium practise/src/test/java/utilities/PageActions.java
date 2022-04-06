package utilities;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class PageActions {

	WebDriver driver=null;
	WebDriverWait wait;

	public PageActions(WebDriver driver){
		this.driver=driver;
		//wait=new WebDriverWait(driver,Duration.ofSeconds(20));

	}

	//wait for click element
	public  WebElement waitForClickElement(WebDriver driver,WebElement ele, int timeout) { 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(ele));
		return ele;
		}	

	//get Text of Element
	public String getTextOfElement(WebDriver driver,WebElement ele, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOf(ele)).getText();
	}


	//wait for visibility of element
	public void waitForVisibleElement(WebDriver driver,WebElement ele, int timeout) { 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}
	//waitForPresenceOfElement
	public  WebElement waitForPresenceOfElement(WebDriver driver,By locator, int timeout) { 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			}	
 //elementToBeClickable
	public  WebElement waitForElementToBeClickable(WebDriver driver,WebElement ele, int timeout) { 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
		
		}	
	//elementToBeSelected
	public  Boolean waitForElementToBeSelected(WebDriver driver,WebElement ele, int timeout) { 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.elementToBeSelected(ele));
	
	}
	//waitForInvisibilityOfElement
	public  Boolean waitForInvisibilityOfElement(WebDriver driver,WebElement ele, int timeout) { 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.invisibilityOf(ele));
		
		}	
	//wait For textToBePresentInElement
	public  Boolean waitFortextToBePresentInElement(WebDriver driver,WebElement ele, int timeout,String textValue) { 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.textToBePresentInElement(ele, textValue));
		
		}	
	
	//wait for List of elements	
	public void waitForAllElements(WebDriver driver,List<WebElement> elements, int timeout) { 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));

	}


	
	



	
	
	
	
	
	
	
	
	
	
	
	
	
	// Hover on Element
	public void waitForHoverElement(WebDriver driver,WebElement ele, int timeout) { 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	/*	public void clickElement(WebElement helmet ) {

		wait.until(ExpectedConditions.visibilityOf(helmet));
		helmet.click();
	}

	public void clicksortElement(List<WebElement> fresharrivals ) {

		wait.until(ExpectedConditions.visibilityOfAllElements(fresharrivals));
	}


	public String getTextOfElement(WebElement element) {

		return wait.until(ExpectedConditions.visibilityOf(element)).getText();

	}

public static WebElement WaitForElementWithFluentWait(WebDriver driver,final By locator){
			Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(Exception.class);
			WebElement element=wait.until(new Function<WebDriver,WebElement>()){
				public WebElement apply(WebDriver driver) {
						return driver.findElement(locator);
					}
					});

return element;
	}
 */

}
