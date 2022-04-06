package Selenium.Assignment;

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

public class Excel1 {
	static XSSFWorkbook wb=null;
	XSSFSheet sh=null;
	XSSFRow row=null;
	static XSSFCell cell=null;
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(".\\Datafiles\\ExcelRead1.xlsx");
		List<LinkedHashMap<String, String>> dataList = new ArrayList<>();
		wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("data");
		int rows=sh.getLastRowNum();
		LinkedHashMap<String, String> d= new LinkedHashMap<String, String>();
		for(int r=0;r<=rows;r++) {
			XSSFRow colHeader=sh.getRow(0);
			String rowHeader=sh.getRow(r).getCell(0).getStringCellValue();
			String cellvalue=sh.getRow(r).getCell(1).getStringCellValue();
			d.put(rowHeader,cellvalue);
			//System.out.println(d.get("TC001"));
			dataList.add(d);
			}
		
			for(Map.Entry entry:d.entrySet())
				//System.out.println(entry.getValue()+"::"+entry.getKey());
				//System.out.println(entry.getKey());
				//System.out.println(entry.getKey());
				System.out.println(entry.getKey()+"  "+entry.getValue());
		}
	}

