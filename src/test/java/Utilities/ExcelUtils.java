package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static String readexcel(String sheetname, String rowString) throws Exception {
		String path="C:\\Users\\16692\\eclipse-workspace\\DsalgoProject\\src\\test\\resources\\testdata\\Testdata (3).xlsx";
		//String fileSeperator = System.getProperty("file.separator");
		//String path = System.getProperty("user.dir") +fileSeperator+"TestData/DsalgoTestdata.xlsx";
			//	System.getProperty("user.dir") +fileSeperator+
	//	String path = System.getProperty("user.dir") + "/src/test/resources/TestData/DsalgoTestdata.xlsx";
		File Excelfile = new File(path);
		FileInputStream Fis = new FileInputStream(Excelfile);
		
		int rownumber=Integer.parseInt(rowString);

		XSSFWorkbook workbook = new XSSFWorkbook(Fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownumber);
		Cell cell = row.getCell(0);
		String cellData = cell.getStringCellValue();
		System.out.println(cellData);
		return cellData;

//		Iterator<Row> row=sheet.rowIterator();
//				do{
//			Row currRow=row.next();
//			Iterator<Cell> cell=currRow.cellIterator();
//			while(cell.hasNext())
//			{
//				Cell currcell=cell.next();
//				System.out.pristrntln(currcell.getStringCellValue()+"~");
//			}
//			System.out.println();
//		}while(row.hasNext());
//

	}
	
	public static String[] readLoginfromexcel(String sheetname,String rowString) throws Exception
	{
		String path = System.getProperty("user.dir") + "/src/test/resources/TestData/DsalgoTestdata.xlsx";
		File Excelfile = new File(path);
		FileInputStream Fis = new FileInputStream(Excelfile);
		
		int rownumber=Integer.parseInt(rowString);

		XSSFWorkbook workbook = new XSSFWorkbook(Fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		System.out.println(sheetname);
		
		Row row = sheet.getRow(rownumber);
		Cell cell1 = row.getCell(0);
		Cell cell2=row.getCell(1);
		//String cellData1 = cell1.getStringCellValue();
		//String cellData2 = cell2.getStringCellValue();
		String[] celldata=new String[2];
		if(cell1==null) {
			celldata[0]="";
		}
		else {
			celldata[0]=cell1.getStringCellValue();	
		}
		if(cell2==null)
		{
			celldata[1]="";
		}
		else {
			celldata[1]=cell2.getStringCellValue(); 
		}
		System.out.println(celldata[0]+rownumber);
		
		System.out.println(celldata[1]+rownumber);
		return celldata;
	}
}
