package com.urbanladder.pageobject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.HomepageDiningUI;
import com.urbanladder.uistore.PromotionsUI;
import com.urbanladder.uistore.StoreofUrbanLadderUI;


public class StoreofUrbanLadder {
	public static boolean popup(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		ReusableMethods.timelaps(driver);
		ReusableMethods.waituntil(StoreofUrbanLadderUI.popup, driver);
		if(ReusableMethods.click(StoreofUrbanLadderUI.popup, driver))
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
	public static boolean clickingonstores(WebDriver driver,Logger log) throws Exception
	{
		if(ReusableMethods.click(StoreofUrbanLadderUI.store, driver))
		{
			log.info("Successfully clicked on the stores button");
			Thread.sleep(2000);
			List<WebElement>city=ReusableMethods.findelements(StoreofUrbanLadderUI.placeheadings, driver);
			List<WebElement>cityviewbutton=ReusableMethods.findelements(StoreofUrbanLadderUI.viewbutton, driver);
			for(int i=0;i<city.size();i++)
			{
				
				String str=city.get(i).getText();
				System.out.println(str);
				if(str.equalsIgnoreCase("Domlur, Bangalore"))
				{
					cityviewbutton.get(i).click();
				System.out.println(	ReusableMethods.getText(StoreofUrbanLadderUI.address, driver));
				log.info("Successfully printed the address of the city");
				break;
				}
				
				
				Thread.sleep(2000);
			}
			return true;
		}
		else
		{
			log.info("Unable to click on the storesbutton and unable to print the address of the city");
			return false;
		}
	}

}
