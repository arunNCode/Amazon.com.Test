package Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/** 
 * To read and fetch test data from test data sheet
 */
public class ExcelUtils {
	
	/**
	 * *In this method we read test data excel file and set the test data values into an array  
	   * @param filePath excel file path reference
	   * @param fileName file name value
	   * @param sheetName excel sheet's name value
	   * @return Excel sheet's test data values
	   * based on 'filePath' and 'property' inputs
	   */
	 public ArrayList<String> readExcel(String filePath,String fileName,String sheetName) {
		    ArrayList<String> ar = new ArrayList<String>();
		 try
		 {
	    File file =    new File(filePath+"\\"+fileName);
	    FileInputStream inputStream = new FileInputStream(file);
	    Workbook workBook = null;
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    if(fileExtensionName.equals(".xlsx")){
	    	workBook = new XSSFWorkbook(inputStream);
	    }
	    else if(fileExtensionName.equals(".xls")){
	    	workBook = new HSSFWorkbook(inputStream);
	    }
	    Sheet sheet1 = workBook.getSheet(sheetName);
	    int rowCount = sheet1.getLastRowNum()-sheet1.getFirstRowNum();
	    for (int i = 1; i < rowCount+1; i++) {

	        Row row = sheet1.getRow(i);
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	        ar.add(row.getCell(j).getStringCellValue());
	        }
	   
	    }

		 }
		  catch(Exception error)
		  {
			  System.out.print("Cause is " +error.getCause());
			  System.out.print("Message is " +error.getMessage());
			  error.printStackTrace();
		  }
			return ar;

	    }  
 
	 
}
