package com.urbanladder.pageobject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.AddressPageUI;
import com.urbanladder.uistore.FooterPageUI;
import com.urbanladder.uistore.HomepageLivingUI;

public class FooterPage {
	public static boolean popup(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		ReusableMethods.timelaps(driver);
		ReusableMethods.waituntil(FooterPageUI.popup, driver);
		if(ReusableMethods.click(FooterPageUI.popup, driver))
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
	public static boolean headings(WebDriver driver,Logger log) throws InterruptedException
	{
		 log.info("Success");
		Thread.sleep(2000);
		List<WebElement>heads=ReusableMethods.findelements(FooterPageUI.heading, driver);
		Thread.sleep(2000);
		if(heads!=null)
		{
		for(int i=0;i<heads.size();i++)
		{
			 log.info("Success");
			String str=heads.get(i).getText();
			if(str.contains("Sofas"))
			{
				heads.get(i).click();
				break;
			}
		}
		return true;
		}
		else
		{
			 log.error("Unable to click on it");
			return false;
		}
	}
	public static boolean multiplecards(WebDriver driver,Logger log) throws InterruptedException
	{
		Thread.sleep(2000);
		List<WebElement>cards=ReusableMethods.findelements(FooterPageUI.cards, driver);
		if(cards!=null)
		{
			 log.info("Success");
			for(int i=0;i<cards.size();i++)
			{
				 log.info("Success");
				
				System.out.println(cards.get(i).getAttribute("alt"));
				
			}
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public static boolean soacialmedia(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		if(ReusableMethods.click(FooterPageUI.linkedln, driver))
		{
			 log.info("Success");
			return true;
		}
		else
		{
			 log.error("Unsuccessful");
			return false;
		}
	}

}
