package Tests;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/*import org.openqa.selenium.support.PageFactory;  
import org.testng.Assert;*/
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageFactory.HelmetPageObjects;
import pageFactory.HomePageobjects;
import pageFactory.ShoesPageObjects;
/*import pageFactory.HelmetPageObjects;
import pageFactory.HomePageobjects;
import pageFactory.ShoesPageObjects;
 */import utilities.GenericActions;
 import utilities.InstantiateDriver;
 //import utilities.Propertyclass;
 import utilities.Propertyclass;
 import utilities.Screenshotclass;

 public class Testclass extends InstantiateDriver  {

	 public static void main(String[] args) throws InterruptedException, IOException {
		 driver= invokeDriver();
		 // driver.get("https://www.snapdeal.com/");
		 ExtentReports extent=new ExtentReports();
		 /*@BeforeTest
	 public void invokeBrowser(){
		  */	 String path=System.getProperty("user.dir")+"\\reports\\index.html";
		  ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		  reporter.config().setReportName("Snapdeal web Automation");
		  reporter.config().setDocumentTitle("Test  Results");
		  //ExtentReports extent=new ExtentReports();
		  extent.attachReporter(reporter);
		  extent.setSystemInfo("Tester", "Madhavi");
		  ExtentTest test=extent.createTest("Initial Demo");
		  //test.log(PASS, path);
		  //test.addScreenCaptureFromPath(reporter);
		 
		 // Screenshotclass sc=new Screenshotclass();
		  String screenpath=System.getProperty("user.dir")+"\\reports\\Snap";

		  // }
		  //Homepage Validation 		
		  String eurl=Propertyclass.readurlProperty("eurl");
		  System.out.println("Actual_url: "+driver.getCurrentUrl()+"\n"+"Expected_url:"+ eurl); 
		  Assert.assertEquals(driver.getCurrentUrl(), eurl); 
		  System.out.println("--------------Validation1 pass-HomepageUrl matched----------"); 
		 String snapHome =Screenshotclass.getSnapshot(driver, screenpath);
		 test.addScreenCaptureFromPath(snapHome);
		  HomePageobjects homepage=new HomePageobjects(driver);
		  PageFactory.initElements(driver, homepage);	
		  /*HelmetPageObjects helmetpage=new HelmetPageObjects(driver);
		PageFactory.initElements(driver, helmetpage);*/	
		  //HomePageobjects homepage=PageFactory.initElements(driver,HomePageobjects.class);	
		  HelmetPageObjects helmetpage=PageFactory.initElements(driver,HelmetPageObjects.class);

		  ShoesPageObjects shoespage=PageFactory.initElements(driver, ShoesPageObjects.class);
		  homepage.hoverMensFashion();
		  homepage.clickOnShoes();
		  // shoespage.filterBySports();
		  shoespage.printShoeHeader();
		  shoespage.shoeCardTitle();
		  shoespage.shoeCardPrice();
		  shoespage.enterPincode();
		 String shoesImg= Screenshotclass.getSnapshot(driver, screenpath);
		 test.addScreenCaptureFromPath(shoesImg);
		  /*@Test(priority=2)
	public void genericTest() {*/
		  GenericActions genericActions=new GenericActions();
		  //Navigate back
		  genericActions.navigateBack(driver);
		  //}

		  homepage.hoveronAutomotives();
		  homepage.clickOnHelmet();
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
		 String helmetImg= Screenshotclass.getSnapshot(driver, screenpath);
		  test.addScreenCaptureFromPath(helmetImg);
		  /*@AfterTest
	public void breakDown(){
		   */
		  driver.close();

		  extent.flush();
		  //	}


	 }


 }