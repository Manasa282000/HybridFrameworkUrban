package com.urbanladder.pageobject;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.AddressPageUI;
import com.urbanladder.uistore.AddtoCartUI;
import com.urbanladder.uistore.SearchBoxUI;

public class AddressPage {
	public static boolean popup(WebDriver driver,Logger log) throws Exception
	{
		
		Thread.sleep(2000);
		ReusableMethods.timelaps(driver);
		ReusableMethods.waituntil(AddressPageUI.popup, driver);
		if(ReusableMethods.click(AddressPageUI.popup, driver))
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
		if(ReusableMethods.action(AddressPageUI.salesunit, driver))
		{
			if(ReusableMethods.click(AddressPageUI.typeofsales, driver))
			{
				log.info("Successfully clicked on the type of sales");
		
			}
			return true;
		}
		else
		{
			log.error("Unable to click");
		return false;
		}
	}
	public static boolean productcheckout(WebDriver driver,Logger log) throws Exception
	{
		if(ReusableMethods.click(AddressPageUI.product, driver))
		{
			
			Set<String> ids=driver.getWindowHandles();
			Iterator<String> it=ids.iterator();
		    String parent=it.next();
		    String child=it.next();
		    driver.switchTo().window(child);
		    Thread.sleep(2000);
		    
			if(ReusableMethods.click(AddressPageUI.addtocart, driver))
			{
				log.info("Successfully clicked on the add cart items");
				
				Thread.sleep(2000);
				ReusableMethods.click(AddressPageUI.checkout, driver);
				return true;
			    
				
			}
		}
		return false;
	}
	public static boolean address(WebDriver driver,Logger log,String email,String pincode,String address,String fname,String lname,String pnumber) throws Exception
	{
	  Thread.sleep(2000);
	 if( ReusableMethods.sendKeys(AddressPageUI.orderemail, email, driver))
	 {
		 log.info("Success");
		 Thread.sleep(2000);
		 if(ReusableMethods.sendKeys(AddressPageUI.pincode, pincode, driver))
		 {
			 log.info("Success");
			 Thread.sleep(2000);
			 if(ReusableMethods.sendKeys(AddressPageUI.Address,address,driver))
			 {
				 Thread.sleep(2000);
				 if(ReusableMethods.sendKeys(AddressPageUI.Fname, fname,driver))
				 {
					 log.info("Success");
					 Thread.sleep(2000);
					 if(ReusableMethods.sendKeys(AddressPageUI.Lname, lname, driver))
					 {
						 log.info("Success");
						 Thread.sleep(2000);
						 if(ReusableMethods.sendKeys(AddressPageUI.pnumber, pnumber, driver))
						 {
							 log.info("Success");
							 
							 return true;
						 }
					 }
				 }
		
			 }
		 }
	 }
	 return false;
	}

}
