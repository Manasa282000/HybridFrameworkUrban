package com.urbanladder.pageobject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.HomepageDiningUI;
import com.urbanladder.uistore.PromotionsUI;
import com.urbanladder.uistore.StoreofUrbanLadderUI;

public class Promotions {
	public static boolean popup(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		ReusableMethods.timelaps(driver);
		ReusableMethods.waituntil(PromotionsUI.popup, driver);
		if(ReusableMethods.click(PromotionsUI.popup, driver))
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
		if(ReusableMethods.action(PromotionsUI.salesunit, driver))
		{
			 log.info("Success");
			if(ReusableMethods.click(PromotionsUI.typeofsales, driver))
			{
				 log.info("Success");
				return true;
			}
		}
		
		return false;
		
	}
	public static boolean promotions(WebDriver driver,Logger log) throws InterruptedException
	{
		String myWindowHandle = driver.getWindowHandle();
		List<WebElement>promo=ReusableMethods.findelements(PromotionsUI.promotions, driver);
		if(promo!=null)
		{
			 log.info("Success");
			for(int i=0;i<promo.size();i++)
			{
				promo.get(i).click();
				Set<String> ids=driver.getWindowHandles();
				Iterator<String> it=ids.iterator();
			    String parent=it.next();
			    String child=it.next();
			    driver.switchTo().window(child);
			    Thread.sleep(2000);
			    System.out.println(driver.getTitle());
			   String str= ReusableMethods.getText(PromotionsUI.countofproducts, driver);
			   driver.close();
			   System.out.println(str);
			   Thread.sleep(2000);
			    driver.switchTo().window(parent);
			    Thread.sleep(2000);
			}
			return true;
		}
		return false;
	}

}
