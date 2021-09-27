package com.urbanladder.pageobject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.HomepageDiningUI;
import com.urbanladder.uistore.HomepageStudyUI;
import com.urbanladder.uistore.SearchBoxUI;

public class SearchBox { 
	public static boolean popup(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		ReusableMethods.timelaps(driver);
		if(ReusableMethods.click(SearchBoxUI.popup, driver))
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
	public static boolean searchboxkey(WebDriver driver,Logger log,String searchitem) throws Exception
	{
		if(ReusableMethods.sendKeys(SearchBoxUI.searchbox, searchitem, driver))
		{
			log.info("Successfully enter the keys");
			Thread.sleep(2000);
			ReusableMethods.sendKey(SearchBoxUI.searchbox,Keys.ENTER,driver);
			
			return true;
		}
		else
		{
			log.info("Unable to enter the keys");
			return false;
		}
		
	}
	public static boolean addtocart(WebDriver driver,Logger log) throws Exception
	{
		if(ReusableMethods.click(SearchBoxUI.product, driver))
		{
			Set<String> ids=driver.getWindowHandles();
			Iterator<String> it=ids.iterator();
		    String parent=it.next();
		    String child=it.next();
		    driver.switchTo().window(child);
		    Thread.sleep(2000);
		    
			if(ReusableMethods.click(SearchBoxUI.addtocart, driver))
			{
				return true;
			    
				
			}
		}
		
		return false;
	}

	

}
