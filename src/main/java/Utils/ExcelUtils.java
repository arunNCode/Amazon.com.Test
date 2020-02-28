package Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Base.AppException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/** 
 * to read and fetch test data from test data sheet
 */
public class ExcelUtils {
	
	/**
	 * *In this method we read test data excel file and create a hashmap with key value pair  
	   * @param filePath excel file path reference
	   * @param sheetName excel sheet's name value
	   * @return Excel sheet's key value data
	   * based on 'filePath' and 'property' inputs
	   * @throws IOException exceptions produced by failed/interrupted I/O operations.
     *@throws AppException exceptions produced by failure of test events  
	   */
	 public HashMap<String, String> readExcel(String filePath,String sheetName) throws AppException, IOException {
		    ArrayList<String> ar = new ArrayList<String>();
		    HashMap<String,String> excelFileMap = new HashMap<String,String>();
	    	File file =    new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook workBook = null;
			String fileExtensionName = filePath.substring(filePath.indexOf("."));
	    if(fileExtensionName.equals(".xlsx")){
	    	workBook = new XSSFWorkbook(inputStream);
	    }
	    else if(fileExtensionName.equals(".xls")){
	    	workBook = new HSSFWorkbook(inputStream);
	    }
	    Sheet sheet1 = workBook.getSheet(sheetName);
	    int lastRow = sheet1.getLastRowNum();
		    for(int i=0; i<=lastRow; i++){
		    Row row = sheet1.getRow(i);
		    Cell valueCell = (Cell) row.getCell(1);
		    Cell keyCell = row.getCell(0);
		    String value = valueCell.getStringCellValue().trim();
		    String key = keyCell.getStringCellValue().trim();
		    excelFileMap.put(key, value);
		
		    }
			 
			return excelFileMap;

	    }  
 
	 
}
