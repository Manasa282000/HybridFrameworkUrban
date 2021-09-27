package com.urbanladder.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.runner.Runner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.urbanladder.pageobject.Recommend;
import com.urbanladder.pageobject.AddressPage;
import com.urbanladder.pageobject.AddtoCart;
import com.urbanladder.pageobject.FooterPage;
import com.urbanladder.pageobject.HomepageDining;
import com.urbanladder.pageobject.HomepageLiving;
import com.urbanladder.pageobject.HomepageStudy;
import com.urbanladder.pageobject.Promotions;
import com.urbanladder.pageobject.SearchBox;
import com.urbanladder.pageobject.StoreofUrbanLadder;
import com.urbanladder.reusablecomponents.ReusableComponents;
import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.PromotionsUI;
import com.urbanladder.utility.ExcelReader;
import com.urbanladder.utility.Log;

public class TestRunner extends ExcelReader {
private  Logger log=  Log.logger(Runner.class.getName());
	
public WebDriver driver;
	
 @Test(priority=0)
	public void homepageliving() throws Exception
	{
		
		driver=ReusableComponents.loaddriver();
		log.info("driverstarted");
		ReusableMethods.loadurl(driver);
		Thread.sleep(2000);
	 boolean output=HomepageLiving.popup(driver, log);
	 Assert.assertEquals(output, true);
	boolean output2= HomepageLiving.living(driver, log);
	
	 
	 boolean output3=HomepageLiving.typeoflivingitems(driver, log);
	 Assert.assertEquals(output3, true);
	 boolean output4=HomepageLiving.livingsofatype(driver, log);
	 Assert.assertEquals(output4, true);
	 boolean output5=HomepageLiving.countofproducts(driver, log);
	 Assert.assertEquals(output5, true);
	 driver.quit();
	
	}
	@Test(priority=1)
	public void SearchBox() throws Exception
	{
		Thread.sleep(5000);
		driver=ReusableComponents.loaddriver();
		log.info("driverstarted");
		ReusableMethods.loadurl(driver);
		Thread.sleep(2000);
		boolean output=SearchBox.popup(driver, log);
		 Assert.assertEquals(output, true);
		boolean output2=SearchBox.searchboxkey(driver, log, "tables");
		 Assert.assertEquals(output2, true);
		boolean output3=SearchBox.addtocart(driver, log);
		Assert.assertEquals(output3, true);
		 driver.quit();
		 
		 
		 
		
	}
	@Test(priority=2)
	public void Stores() throws Exception
	{
		Thread.sleep(5000);
		driver=ReusableComponents.loaddriver();
		log.info("driverstarted");
		ReusableMethods.loadurl(driver);
		boolean output=StoreofUrbanLadder.popup(driver, log);
		Assert.assertEquals(output, true);
		boolean output1=StoreofUrbanLadder.clickingonstores(driver, log);
		Assert.assertEquals(output1, true);
		driver.quit();
		
	}
	@Test(priority=3)
	public void homepagestudy() throws Exception
	{
		Thread.sleep(5000);
		driver=ReusableComponents.loaddriver();
		log.info("driverstarted");
		ReusableMethods.loadurl(driver);
		boolean output=HomepageStudy.popup(driver, log);
		Assert.assertEquals(output, true);
		boolean output1=HomepageStudy.studyaction(driver, log);
		Assert.assertEquals(output1, true);
		boolean output2=HomepageStudy.addtocompare(driver, log);
		Assert.assertEquals(output2, true);
		driver.quit();
	}
	@Test(priority=4)
	public void footerpage() throws Exception
	{
		Thread.sleep(2000);
		driver=ReusableComponents.loaddriver();
		log.info("driverstarted");
		ReusableMethods.loadurl(driver);
		boolean output=FooterPage.popup(driver, log);
	Assert.assertEquals(output, true);
		boolean output1=FooterPage.headings(driver, log);
		Assert.assertEquals(output1, true);
		boolean output2=FooterPage.multiplecards(driver, log);
		Assert.assertEquals(output2, true);
		boolean output3=FooterPage.soacialmedia(driver, log);
		Assert.assertEquals(output3, true);
		driver.quit();
		
	}
	@Test(priority=5)
	public void dining() throws Exception
	{
		Thread.sleep(2000);
		driver=ReusableComponents.loaddriver();
		log.info("driverstarted");
		ReusableMethods.loadurl(driver);
		boolean output=HomepageDining.popup(driver, log);
		Assert.assertEquals(output, true);
		Thread.sleep(2000);
		boolean output1=HomepageDining.diningunit(driver, log);
		Assert.assertEquals(output1, true);
		Thread.sleep(20000);
		boolean output2=HomepageDining.pricehandling(driver, log);
		Assert.assertEquals(output2, true);
		driver.quit();
	}
	@Test(priority=6)
	public void addtocart() throws Exception
	{
		Thread.sleep(2000);
		driver=ReusableComponents.loaddriver();
		log.info("driverstarted");
		ReusableMethods.loadurl(driver);
		boolean output=AddtoCart.popup(driver, log);
		Assert.assertEquals(output, true);
		Thread.sleep(20000);
		boolean output1=AddtoCart.emptycart(driver, log);
		Assert.assertEquals(output1, true);
		Thread.sleep(2000);
		boolean output2=AddtoCart.addtocart(driver, log);
		Assert.assertEquals(output2, true);
		driver.quit();
		
	}
	@Test(priority=7)
	public void Recommend() throws Exception
	{
			Thread.sleep(5000);
		driver=ReusableComponents.loaddriver();
		log.info("driverstarted");
		ReusableMethods.loadurl(driver);
		boolean output=Recommend.popup(driver, log);
		Assert.assertEquals(output, true);
		boolean output1=Recommend.salesunit(driver, log);
		Assert.assertEquals(output1, true);
		boolean output2=Recommend.recommended(driver, log);
		Assert.assertEquals(output2, true);
		driver.quit();
	}
	@Test(priority=8)
	public void promotions() throws Exception
	{
		Thread.sleep(5000);
		driver=ReusableComponents.loaddriver();
		log.info("driverstarted");
		ReusableMethods.loadurl(driver);
		boolean output=Promotions.popup(driver, log);
		Assert.assertEquals(output, true);
		boolean output1=Promotions.salesunit(driver, log);
		Assert.assertEquals(output1, true);
		boolean output2=Promotions.promotions(driver, log);
		Assert.assertEquals(output2, true);
		driver.quit();
	}
	@Test(priority=9,dataProvider="data")
	public void checkout(String emailid,String pincode,String address,String fname,String lname,String pnumber) throws Exception
	{
		Thread.sleep(2000);
		driver=ReusableComponents.loaddriver();
		log.info("driverstarted");
		ReusableMethods.loadurl(driver);
		boolean output=AddressPage.popup(driver, log);
		Assert.assertEquals(output, true);
		boolean output1=AddressPage.salesunit(driver, log);
		Assert.assertEquals(output1, true);
	   boolean output2=AddressPage.productcheckout(driver, log);
	   Assert.assertEquals(output2, true);
	   boolean output3=AddressPage.address(driver, log, emailid,pincode,address,fname,lname,pnumber);
	   Assert.assertEquals(output3, true);
	   driver.quit();
	   
		
		
	}
	@Test
	@DataProvider(name="data")
	public Object[][] data() throws IOException
	{
		 XSSFSheet psheet=xcel();
		int rows=numberofrow(psheet);
		int column=numberofcol(psheet);
		Object[][] str=getdata(psheet,rows,column);
		
		int k=0;
		Object[][] inputs=new Object[rows][column];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<column;j++)
			{
				inputs[i][j]=str[i][j];
			}
		}
		return inputs;
	}

	

}
