package com.urbanladder.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileReader {
public static Properties prop=new Properties();
	
	public static  Properties loadfile() throws FileNotFoundException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\User\\Desktop\\myselenium\\UrbanLadder\\config.properties");
		try {
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
