package com.urbanladder.reusablecomponents;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.urbanladder.utility.PropertyFileReader;


public class ReusableComponents {
	static WebDriver driver;
	public static WebDriver loaddriver() throws NumberFormatException, FileNotFoundException
	   {
		   String x=PropertyFileReader.loadfile().getProperty("driver");//Reading the type of driver from the propertyfile
		   String path=PropertyFileReader.loadfile().getProperty("pathofdriver");//Reading the path of the sepcified driver
			if(x.equals("chrome"))//If the type of the driver is the chrome 
			{
			System.setProperty("webdriver.chrome.driver", path);
			driver=new ChromeDriver();
			driver.manage().window().maximize();//Maximizing the window size
			}
			else if(x.equals("mozilla"))//If the type of the driver is the mozilla
			{
				try {
					System.setProperty("webdriver.gecko.driver", path);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 driver=new  FirefoxDriver();
				driver.manage().window().maximize();
			}
			else//If the type of the driver is the msedge
			{
				System.setProperty("webdriver.edge.driver", path);
				 driver=new  EdgeDriver();
				driver.manage().window().maximize();
			}
			
			return driver;//Returning the webdriver
		
			
			
		}

}
