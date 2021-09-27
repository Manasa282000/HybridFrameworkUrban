package com.urbanladder.pageobject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.HomepageDiningUI;
import com.urbanladder.uistore.HomepageStudyUI;

public class HomepageStudy {
	public static boolean popup(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		ReusableMethods.timelaps(driver);
		ReusableMethods.waituntil(HomepageStudyUI.popup, driver);
		if(ReusableMethods.click(HomepageStudyUI.popup, driver))
		{
			log.info("Successfully closed the popup");
		return true;
		}
		else
		{
			log.info("Popup is not closed Kindly close it");
			return false;
		}
		
		
	}
	public static boolean studyaction(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		if(ReusableMethods.action(HomepageStudyUI.studybutton, driver))
		{
			 log.info("Success");
			Thread.sleep(2000);
			if(ReusableMethods.click(HomepageStudyUI.studytablebutton, driver))
			{
				 log.info("Success");
				Thread.sleep(2000);
				if(ReusableMethods.click(HomepageStudyUI.price, driver))
				{
					 log.info("Success");
					Thread.sleep(2000);
					List<WebElement>priceradio=ReusableMethods.findelements(HomepageStudyUI.pricerange, driver);
					for(int i=0;i<priceradio.size();i++)
					{
						String str=priceradio.get(i).getText();
						if(str.contains("9,000"))
						{
							 log.info("Success clicked on the 9000");
							priceradio.get(i).click();
							break;
							
							
							
						}
					}
				}
				return true;
			}
			
		}
		
		return false;
	}
	public static boolean addtocompare(WebDriver driver,Logger log) throws Exception
	{
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		List<WebElement>compare=ReusableMethods.findelements(HomepageStudyUI.addtocompare, driver);
		if(compare!=null)	
		{
			 log.info("Success");
			for(int i=0;i<2;i++)
			{
				
				js.executeScript("arguments[0].click();",compare.get(i));
				Thread.sleep(2000);;
			}
			Thread.sleep(2000);
			ReusableMethods.click(HomepageStudyUI.comparebutton, driver);
			return true;
		}
		else
		{
			 log.error("UnSuccess");
			return false;
		}
	}
}
