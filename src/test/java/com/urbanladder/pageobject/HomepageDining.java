package com.urbanladder.pageobject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.AddressPageUI;
import com.urbanladder.uistore.HomepageDiningUI;
import com.urbanladder.uistore.HomepageLivingUI;

public class HomepageDining {
	public static boolean popup(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		ReusableMethods.timelaps(driver);
		ReusableMethods.waituntil(HomepageDiningUI.popup, driver);
		if(ReusableMethods.click(HomepageDiningUI.popup, driver))
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
	public static boolean diningunit(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		ReusableMethods.timelaps(driver);
		if(ReusableMethods.action(HomepageDiningUI.diningunit, driver))
		{
			if(ReusableMethods.click(HomepageDiningUI.typeofdining, driver))
			{
				return true;
			}
		}
		return false;
	}
	public static boolean pricehandling(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		ReusableMethods.timelaps(driver);
		if(ReusableMethods.action(HomepageDiningUI.pricehandling, driver))
		{
			log.info("successfully clicked on price handling");
			List<WebElement>pricelist=ReusableMethods.findelements(HomepageDiningUI.pricerange, driver);
			for(int i=0;i<pricelist.size();i++)
			{
				Thread.sleep(2000);				
				pricelist.get(i).click();
				Thread.sleep(2000);
			System.out.println(	ReusableMethods.getText(HomepageDiningUI.resultcount, driver));
				Thread.sleep(2000);
				ReusableMethods.timelaps(driver);;
				ReusableMethods.action(HomepageDiningUI.pricehandling, driver);
			}
			 log.info("Success");
			return true;
		}
		else
		{
			 log.error("Success");
			return false;
		}
	}

}
