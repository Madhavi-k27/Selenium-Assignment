package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshotclass {

	public static String getSnapshot(WebDriver driver,String screenpath) throws IOException {
		//File src=new File("./reports/picture.png");
		//FileInputStream fis=new FileInputStream(src);
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
        Date date = new Date();
        //String filename = "Super_Selenium";
		TakesScreenshot sh=(TakesScreenshot)driver;
		File srcFile =sh.getScreenshotAs(OutputType.FILE);
		//File destFile=new File(screenpath);
		FileUtils.copyFile(srcFile, new File(screenpath+"-"+dateFormat.format(date)+".png"));
		return screenpath;
		//.getSnapshot(driver, screenpath))
	}
}