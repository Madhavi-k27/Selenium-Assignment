package Selenium.Assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadUsingSheetAndColumnName {
	int col_Num=-1;
	XSSFWorkbook wb=null;
	XSSFSheet sh=null;
	XSSFRow row=null;
	XSSFCell cell=null;

	public ExcelReadUsingSheetAndColumnName(String location) throws IOException {

		FileInputStream fis=new FileInputStream(location);
		wb=new XSSFWorkbook(fis);
		fis.close();
	}
	public String getCelldata(String sheetname,String colName, int rw) {

		try {
			sh=wb.getSheet(sheetname);
			row=sh.getRow(0);
			for(int i = 0; i < row.getLastCellNum(); i++) {

				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;				
			}

			row = sh.getRow(rw-1);
			cell = row.getCell(col_Num);

			String celldata=null;
			switch (cell.getCellType()){
							
			case BOOLEAN:
				celldata=String.valueOf(cell.getBooleanCellValue());break;
			case NUMERIC:
				celldata= String.valueOf(cell.getNumericCellValue());break;				
			case STRING:
				celldata= cell.getStringCellValue();break;
			default:
				System.out.println("cell value not found");
			}
			return celldata;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "row "+rw+" or column "+col_Num +" does not exist  in Excel";
	}

public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelReadUsingSheetAndColumnName e=new ExcelReadUsingSheetAndColumnName(".\\Datafiles\\ExcelRead.xlsx");
		
		
		String TestcaseID=e.getCelldata("data","TestCase_ID",2);
		String Title=e.getCelldata("data","Title",2);
		String Url=e.getCelldata("data","Url",2);	
		System.out.println(TestcaseID+"|"+Title+"|"+Url);

	}

}