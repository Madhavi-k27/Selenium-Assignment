package Selenium.Assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HExcel {

	static XSSFWorkbook wb=null;
	static XSSFRow r;
	public static  List<LinkedHashMap<String, String>> getExcelData(String excelpath, String sheetName) throws IOException {
		// Create a Workbook
		FileInputStream fis=new FileInputStream(excelpath);
		wb=new XSSFWorkbook(fis);
		// Get sheet with the given name 
		XSSFSheet s = wb.getSheet(sheetName);
		// Initialized an empty List which retain order
		List<LinkedHashMap<String, String>> dataList = new ArrayList<>();
		// Get data set count which will be equal to cell counts of any row
		int countOfDataSet = s.getRow(0).getLastCellNum();
		// Skipping first column as it is field names
		for (int i = 1; i < countOfDataSet; i++) {
			// Creating a map to store each data set individually
			LinkedHashMap<String, String> data  = new LinkedHashMap<>();
			// Get the row i.e field names count
			int rowCount = s.getPhysicalNumberOfRows();
			// Now we need to iterate all rows but cell should increases once all row is done
			for(int j = 1; j<rowCount ; j++) {
				XSSFRow r = s.getRow(j);
				// Field name is constant as 0th index
				String TestcaseID = r.getCell(0).getStringCellValue();
				String fieldValue = r.getCell(i).getStringCellValue();
				// Add data in map
				data.put(TestcaseID, fieldValue);
			}
			// Add map to list after each iteration

		dataList.add(data);

		}
	return dataList;
		
	}

	public static void main(String[] args) throws IOException  {

		List<LinkedHashMap<String, String>> mapDataList = getExcelData(".\\Datafiles\\ExcelData.xlsx","data");
		System.out.println("Size: "+mapDataList.size());
		for(int k = 0; k<mapDataList.size() ; k++)
		{
		for( String s: mapDataList.get(k).keySet())
		{
			//System.out.println(s);	
			//System.out.println(mapDataList.get(k));
			/*System.out.println(mapDataList.get(k).keySet());
			System.out.println(mapDataList.get(k).get(s));*/
			System.out.println("Value of "+s +" is  : "+mapDataList.get(k).get(s));
			}
			System.out.println("========================================================");
			//break;
		}
	}

}