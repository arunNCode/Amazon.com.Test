package Base;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import Utils.ExcelUtils;

/** 
 * to read the test data file and returns the test input
 */
public abstract class TestDataReader {
	static HashMap<String,String> InputValue = new HashMap<String,String>();
    /**
     * method to read the test data and returns key value object
     * @param fileReference path reference to test data with extension value 
     * @param sheetName Sheet of the file to refer to
     * @throws IOException exceptions produced by failed/interrupted I/O operations.
     * 	@throws AppException exceptions produced by failure of test events 
     * @return excel's test data into a key value pair Hashmap
     * 
     */
	public static HashMap<String, String> testDataReader(String fileReference,String sheetName) throws AppException, IOException{ 
		  File file = new File(fileReference);
		  String pathUrl=file.getAbsolutePath();  
			ExcelUtils objSheetFile = new ExcelUtils();
			InputValue= objSheetFile.readExcel(pathUrl,sheetName);
			return InputValue;
			
		}
   
}

