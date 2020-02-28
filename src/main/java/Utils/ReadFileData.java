package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import Base.AppException;
/**
 * to read and fetch data from dependent files 
 */
public class ReadFileData {
	/**
	   * @param filePath property file path reference
	   * @param propertyKey property key to look for 
	   * @return Method returns the  property's value 
	   * based on 'filePath' and 'property' inputs
	   * @throws IOException exceptions produced by failed/interrupted I/O operations.
     *@throws AppException exceptions produced by failure of test events 
	   */
	public String ReadPropertiesData(String filePath,String propertyKey ) throws IOException, AppException{
		
		File file = new File(filePath);
		FileInputStream fileInput = null;
		HashMap<String, String> hash_map = new HashMap<String, String>(); 
		fileInput = new FileInputStream(file);
			Properties prop = new Properties();
				prop.load(fileInput);
			Enumeration KeyValues = prop.keys();

			while (KeyValues.hasMoreElements()) {
				String key = (String) KeyValues.nextElement();
				String value = prop.getProperty(key);
				hash_map.put(key, value);

			}
			
		return hash_map.get(propertyKey);
		

    }
	
	
	

}
