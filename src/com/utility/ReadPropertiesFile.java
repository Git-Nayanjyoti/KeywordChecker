package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public  Properties prop;
	public ReadPropertiesFile() {
		prop = new Properties();
		try {
			FileInputStream data = new FileInputStream("./src/com/config/keyword.properties");
			prop.load(data);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!!!");
		} catch (IOException e) {
			System.out.println("Unable to read the file!!!");
		}
	}
}
