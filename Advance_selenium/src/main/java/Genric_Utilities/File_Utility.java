package Genric_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	
	/**
	 * This method is used to read data from properties file(External resource
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author vishnu
	 */
	
	public String getKeyAndValue(String key) throws Throwable {
		FileInputStream file = new FileInputStream("C:\\Users\\vishn\\OneDrive\\Desktop\\Productdata.properties");
		Properties pro = new Properties();
		pro.load(file);
        String value = pro.getProperty(key);
        return value;
		
	}

}
