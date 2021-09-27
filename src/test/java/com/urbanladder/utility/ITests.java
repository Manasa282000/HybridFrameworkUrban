package com.urbanladder.utility;
import com.urbanladder.runner.*;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.urbanladder.reusablecomponents.ReusableComponents;

public class ITests implements ITestListener {

	private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal <ExtentTest> extenttest= new ThreadLocal <ExtentTest>();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest test=extent.createTest(result.getTestClass().getName()+"::"+result.getMethod().getMethodName());
		extenttest.set(test);
	}


	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		   String logText = "<b>Test Method" + result.getMethod().getMethodName()+"Successful </b>";
		   Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		      extenttest.get().log(Status.PASS, m);
		      
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	String methodname=result.getMethod().getMethodName();
 String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());
  extenttest.get().fail("<details><summary><b><font-color='red'>Exception Occured,click to see details:"+"</font></br></summary>"+exceptionMessage.replaceAll(",","<br>")+"</details> \n");
   
WebDriver driver=((TestRunner)result.getInstance()).driver;
try {
		
	} catch (NumberFormatException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		
			 
		
	      String path;		
		path = takescreenshot(driver, result.getMethod().getMethodName());
	
	      try
	      {
	    	  extenttest.get().fail("<b><font-color=red>"+"Screenshot of failure"+"<font></b>",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	      }
	      catch(IOException e)
	      {
	    	  extenttest.get().fail("Test Failed,cannot attachement");
	      }
	      String logText="<b>TestMethod "+methodname + "Failed</b>";
	      Markup m=MarkupHelper.createLabel(logText, ExtentColor.RED);
	      extenttest.get().log(Status.FAIL, m);
		
	}


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String logText = "<b>Test Method" + result.getMethod().getMethodName()+"Skipped </b>";
		   Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		      extenttest.get().log(Status.SKIP, m);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stu

		
			 
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		if(extent!=null)
		{
			extent.flush();
		}
		
	}
	public static String  takescreenshot(WebDriver driver,String methodname) {
		   String filename=getscreenshotname(methodname);
		   String directory=".\\screenshot";
		   new File(directory).mkdirs();
		   String path =directory +filename;
		   try
		   {
			  
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			   FileUtils.copyFile(screenshot, new File(path));
			   
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   return path;
		   
	   }
	   public static String getscreenshotname(String methodname)
	   {
		   Date d= new Date();
		   String filename = methodname + "_"+d.toString().replace(":","_").replace(" ","_")+".jpeg";
		   return filename;
	   }
	


}

