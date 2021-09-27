package com.urbanladder.pageobject;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.AddressPageUI;
import com.urbanladder.uistore.AddtoCartUI;


public class AddtoCart {
	static int count=0;
	static int count1=0;
	
	public static boolean popup(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		ReusableMethods.timelaps(driver);
		ReusableMethods.waituntil(AddtoCartUI.popup, driver);
	if(ReusableMethods.click(AddtoCartUI.popup, driver))
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
	public static boolean emptycart(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		String emptycount=ReusableMethods.getText(AddtoCartUI.emptycart, driver);
		 count=Integer.parseInt(emptycount);
		 if(count==0)
		 {
			 log.info("Success");
			 Thread.sleep(2000);
			 if(ReusableMethods.action(AddtoCartUI.decorunit, driver))
			 {
				 log.info("Success");
				 Thread.sleep(2000);
				 if(ReusableMethods.click(AddtoCartUI.decortype, driver))
				 {
					 
					 
				 return true;
				 }
			 }
			 
		 }
		 return false;
		 
		
		
	}
	public static boolean addtocart(WebDriver driver,Logger log) throws InterruptedException, Exception
	{
		Thread.sleep(2000);
		if(ReusableMethods.click(AddtoCartUI.product, driver))
		{
			 log.info("Success");
			Set<String> ids=driver.getWindowHandles();
			  Iterator<String> it=ids.iterator();
			    String parent=it.next();
			    Thread.sleep(2000);
			    String child=it.next();
			    driver.switchTo().window(child);
			    Thread.sleep(2000);
			   if( ReusableMethods.click(AddtoCartUI.addtocart, driver))
			   {
				   
				   log.info("Success");
				   driver.navigate().back();
				   Thread.sleep(2000);
				   String cartcount=ReusableMethods.getText(AddtoCartUI.cartcount, driver);
				   count1=Integer.parseInt(cartcount);
				   if(count1-count==1)
				   {
					   System.out.println("The product is added successfully");
				   }
				   
			   }
			return true;
		}
		return false;
	}

}
