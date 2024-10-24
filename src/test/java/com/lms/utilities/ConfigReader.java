package com.lms.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {
	
	
	private static Properties prop;	
	private static final String PROPERTY_FILE_PATH = "src/test/resources/config/config.properties";
	
	
	public static void load_prop() {
		
		prop = new Properties();
		
		try {
			FileInputStream fp = new FileInputStream(PROPERTY_FILE_PATH);
			prop.load(fp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getProp(String propName) {
		
		return prop.getProperty(propName);
	}
			
		
}
