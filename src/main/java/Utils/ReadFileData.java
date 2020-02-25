package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
/**
 * To read and fetch data from dependent files 
 */
public class ReadFileData {
	/**
	   * @param filePath property file path reference
	   * @param propertyKey property key to look for 
	   * @return Method returns the  property's value 
	   * based on 'filePath' and 'property' inputs
	   */
	public String ReadPropertiesData(String filePath,String propertyKey ){
		
		File file = new File(filePath);
		FileInputStream fileInput = null;
		HashMap<String, String> hash_map = new HashMap<String, String>(); 
		try {
				fileInput = new FileInputStream(file);
			
			Properties prop = new Properties();
				prop.load(fileInput);
			Enumeration KeyValues = prop.keys();

			while (KeyValues.hasMoreElements()) {
				String key = (String) KeyValues.nextElement();
				String value = prop.getProperty(key);
				hash_map.put(key, value);

			}
		}
			catch(Exception error1)
			  {
				  System.out.print("Cause is " +error1.getCause());
				  System.out.print("Message is " +error1.getMessage());
				  error1.printStackTrace();
			  }
		return hash_map.get(propertyKey);
		

    }
	

}
