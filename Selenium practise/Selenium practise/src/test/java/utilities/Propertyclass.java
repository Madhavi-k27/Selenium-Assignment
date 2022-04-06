package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Propertyclass {
	
	public static String readurlProperty(String key)  {
		
		try {
			FileInputStream fis=new FileInputStream("Config.properties");
			Properties p=new Properties();
			p.load(fis);
			return p.getProperty(key).toString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String readtitleProperty(String key) {
		
		try {
			FileInputStream fis=new FileInputStream("Config.properties");
			Properties p=new Properties();
			p.load(fis);
			return p.getProperty(key).toString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
public static String readtextProperty(String key) {
		
		try {
			FileInputStream fis=new FileInputStream("Config.properties");
			Properties p=new Properties();
			p.load(fis);
			return p.getProperty(key).toString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}

