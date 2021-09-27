package com.urbanladder.pageobject;


import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.HomepageDiningUI;
import com.urbanladder.uistore.HomepageLivingUI;


public class HomepageLiving {
	public static boolean popup(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		ReusableMethods.timelaps(driver);
		ReusableMethods.waituntil(HomepageLivingUI.popup, driver);
		
		if(ReusableMethods.click(HomepageLivingUI.popup, driver))
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
	public static boolean living(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		if(ReusableMethods.action(HomepageLivingUI.livingunit, driver))
		{
			log.info("Successfully hovered on the Living icon");
			return true;
		}
		else
		{
			log.info("Unable to hover on the Living icon");
			return false;
		}
	}
	public static boolean typeoflivingitems(WebDriver driver,Logger log) throws InterruptedException
	{
		Thread.sleep(2000);
		List<WebElement>difftypes=ReusableMethods.findelements(HomepageLivingUI.typesofliving, driver);
	if(difftypes!=null)
	{
		for(int i=0;i<difftypes.size();i++)
		{
			System.out.println(difftypes.get(i).getText());
			log.info("Successfully printed the list of the furniter  sets ");
		}
		return true;
	}
	else
	{
		log.info("Unable to get the list of the furniture sets");
		return false;
	}
	}
	public static boolean livingsofatype(WebDriver driver,Logger log) throws Exception
	{
		Thread.sleep(2000);
		if(ReusableMethods.click(HomepageLivingUI.typeofsofaset, driver))
		{
			log.info("Successfully clicked on the fabric sofa sets");
			ReusableMethods.findelement(HomepageLivingUI.countofproduct, driver);
			System.out.println("");
			return true;
		}
		else
		{
			log.error("Unable to click on the Fabric sofa sets");
			return false;
		}
	}
	public static boolean countofproducts(WebDriver driver,Logger log)
	{
		String str=ReusableMethods.getText(HomepageLivingUI.countofproduct, driver);
		
		if(str!=null)
		{
			System.out.println(str);
			log.info("Successfully printed the no of products");
			return true;
		}
		else
		{
			log.error("No.of products are not printed");
			return false;
		}
	}

}
