package com.urbanladder.pageobject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.AddtoCartUI;
import com.urbanladder.uistore.HomepageDiningUI;
import com.urbanladder.uistore.RecommendUI;

public class Recommend {
	public static boolean popup(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		ReusableMethods.timelaps(driver);
		ReusableMethods.waituntil(RecommendUI.popup, driver);
		if(ReusableMethods.click(RecommendUI.popup, driver))
		{
			log.info("Successfully closed the popup");
		return true;
		}
		else
		{
			log.error("Popup is not closed Kindly close it");
			return false;
		}
		
		
	}
	public static boolean salesunit(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		if(ReusableMethods.action(RecommendUI.salesunit, driver))
		{
			 log.info("Success");
			Thread.sleep(2000);
			if(ReusableMethods.click(RecommendUI.typesofsale, driver))
			{
				 log.info("Success");
				return true;
			}
		}
		return false;
	}
	public static boolean recommended(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		if(ReusableMethods.click(RecommendUI.recommended, driver))
		{
			Thread.sleep(2000);
			List<WebElement>variousoptions=ReusableMethods.findelements(RecommendUI.variousoptions, driver);
			for(int i=0;i<variousoptions.size();i++)
			{
				 log.info("Success");

				Thread.sleep(2000);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				
			
				jse.executeScript("arguments[0].click()",variousoptions.get(i));
				Thread.sleep(2000);
				System.out.println(ReusableMethods.getText(RecommendUI.productname, driver));
				Thread.sleep(2000);
				ReusableMethods.timelaps(driver);
				ReusableMethods.click(RecommendUI.recommended, driver);
				
			}
			return true;
		}
		return false;
	}

}
