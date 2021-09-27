package com.urbanladder.utility;


import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	public static ExtentReports createInstance()
	{
		String filename= getreportname();
		
		   String directory="C:\\Users\\User\\Desktop\\myselenium\\UrbanLadder\\Report";
		   new File(directory).mkdirs();
		   String path = directory+filename;
		   ExtentHtmlReporter htmlReporter =new ExtentHtmlReporter(path);
		htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Amazon Sample Testing for homepage");
		htmlReporter.config().setReportName("Amazon home page test");
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.setSystemInfo("ffgh", "iufghj");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);
		return extent;
	}
	 public static String getreportname()
	   {
		   Date d= new Date();
		   String filename ="UrbanLadder" + "_"+d.toString().replace(":","_").replace(" ","_")+".png";
		   return filename;
	   }

}



