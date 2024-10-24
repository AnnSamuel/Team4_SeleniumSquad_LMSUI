package com.lms.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {
	
	
	private static Properties prop;	
	private final static String propertyFilePath = "src/test/resources/config/config.properties";
	
	
	public static void load_prop() {
		
		prop = new Properties();
		
		try {
			FileInputStream fp = new FileInputStream(propertyFilePath);
			prop.load(fp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	//	return (key);
		
	}
	
	public static String getProp(String propName) {
		
		return prop.getProperty(propName);
	}
			
		
}
