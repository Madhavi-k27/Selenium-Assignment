package utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUsingHashmap {
	static XSSFWorkbook wb=null;
	XSSFSheet sh=null;
	XSSFRow row=null;
	public static LinkedHashMap<String, String> getExcelData(String excelpath,String sheet) throws IOException{

		FileInputStream fis=new FileInputStream(excelpath);
		//List<LinkedHashMap<String, String>> dataList = new ArrayList<>();
		wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet(sheet);
		int rows=sh.getLastRowNum();
		LinkedHashMap<String, String> d= new LinkedHashMap<String, String>();
		for(int r=0;r<=rows;r++) {
			XSSFRow colHeader=sh.getRow(0);
			String celldata=sh.getRow(r).getCell(0).getStringCellValue();
			String Testvalue=sh.getRow(r).getCell(1).getStringCellValue();
			d.put(celldata,Testvalue);
			//	System.out.println(d.get("TC001"));
		}
		return d;
	}
	public static void main(String[] args) throws IOException  {
		LinkedHashMap<String, String> mapdata= ExcelUsingHashmap.getExcelData(".\\Datafiles\\ExcelData.xlsx","data");
		/*System.out.println("Title:"+mapdata.get("TC001"));
		System.out.println("Url:"+mapdata.get("TC002"));
		System.out.println("================================");*/
		for(Map.Entry entry:mapdata.entrySet()) {
			System.out.println(entry.getKey()+"  "+entry.getValue());
		}
		//System.out.println(entry.getValue()+"::"+entry.getKey());
		//System.out.println(entry.get("TC001"));
		//System.out.println(entry.getKey());
		//System.out.println(entry.getKey()+"  "+entry.getValue());
	}

}


