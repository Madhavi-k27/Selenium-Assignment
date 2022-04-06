package Selenium.Assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldemo  {

	public static String getCelldata(int rw,int cl) throws IOException  {
		FileInputStream fis=new FileInputStream(".\\Datafiles\\ExcelRead.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheetAt(1);
	    XSSFRow row=sh.getRow(rw);
		XSSFCell vcell=row.getCell(cl);
				
		String celldata=null;
				switch (vcell.getCellType()){
		case BOOLEAN:
			celldata=	String.valueOf(vcell.getBooleanCellValue());
					
		case NUMERIC:
			celldata= String.valueOf(vcell.getNumericCellValue());					
		case STRING:
			celldata= vcell.getStringCellValue();
		default:
			celldata= vcell.getStringCellValue();
		}
				return celldata;
	}	
	
}


