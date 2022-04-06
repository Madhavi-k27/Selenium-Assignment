package Selenium.Assignment;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Assignment2 {

	public static void main(String[] args) throws IOException {


		//FileInputStream to open file in input mode
		FileInputStream fis=new FileInputStream(".\\Datafiles\\ExcelRead.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheetAt(0);
		System.out.println("Number of rows:" +sh.getPhysicalNumberOfRows());
		System.out.println("Index of last row:" +sh.getLastRowNum());
		
		int rowcount=sh.getLastRowNum();//index of last row
		int cellcount=sh.getRow(1).getLastCellNum();
		System.out.println("Rowcount: "+rowcount);
		/*int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
		System.out.println(rowCount);*/
		System.out.println("Cellcount:"+cellcount);

		//Using forloop
		System.out.println("-----Using forloop-----");
		for(int r=0;r<=rowcount;r++) {
			XSSFRow row=sh.getRow(r);
			for(int c=0;c<cellcount;c++) {
				XSSFCell cell=row.getCell(c);
				//System.out.println(cell);
				switch (cell.getCellType()) {
				case STRING:System.out.print(cell.getStringCellValue());break;
				case NUMERIC:System.out.print(cell.getNumericCellValue());break;
				case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
				}
				System.out.print("|");
			}
			System.out.println(" ");
		}
		//Using Iterator
		System.out.println("-----Using Iterator-----");

		Iterator itr=sh.iterator();
		while(itr.hasNext()) {
			XSSFRow rw=(XSSFRow) itr.next();
			Iterator celitr=rw.cellIterator();
			while(celitr.hasNext()) {
				XSSFCell cl=(XSSFCell) celitr.next();
				switch(cl.getCellType()) {
				case STRING:System.out.print(cl.getStringCellValue());break;
				case NUMERIC:System.out.print(cl.getNumericCellValue());break;
				case BOOLEAN:System.out.print(cl.getBooleanCellValue());break;
				}
				System.out.print("|");
			}
			System.out.println(" ");
		}
	}

}
