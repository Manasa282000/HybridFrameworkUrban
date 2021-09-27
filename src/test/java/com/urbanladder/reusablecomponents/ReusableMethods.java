package com.urbanladder.reusablecomponents;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.urbanladder.utility.PropertyFileReader;


public class ReusableMethods {
	public static void loadurl(WebDriver driver) throws FileNotFoundException//Loding the url input from the property file reader
	{
		String url=PropertyFileReader.loadfile().getProperty("URL");
		driver.get(url);
		
	}
	public static void timelaps(WebDriver driver) throws NumberFormatException, FileNotFoundException {//It provides the implict wait
		int time = Integer.parseInt(PropertyFileReader.loadfile().getProperty("implicitwait1"));
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	public static boolean findelement(By selector, WebDriver driver)//It is method for the findelement
	{
		
		try
		{
			driver.findElement(selector);
			return true;
		}
		catch (Exception e) {
			System.out.println(String.format("Element %s doesnot found-proceeding", selector));
			return false;
		}
	}
	public static String getText(By selector, WebDriver driver)//It is method for the findelement
	{
		
		try
		{
		String str=	driver.findElement(selector).getText();
			return str;
		}
		catch (Exception e) {
			System.out.println(String.format("Element %s doesnot found-proceeding", selector));
		
		}
		return null;
	}
	public static List<WebElement> findelements(By selector, WebDriver driver)//It is method for the findelement
	{
		
		try
		{
			List<WebElement>li=driver.findElements(selector);
			return li;
		}
		catch (Exception e) {
			System.out.println(String.format("Element %s doesnot found-proceeding", selector));
			
		}
		return null;
	}
	public static boolean sendKeys(By selector, String searchitems, WebDriver driver) throws Exception {//It is the method to sendkeys
		try {
			driver.findElement(selector).sendKeys(searchitems);
			return true;
		} catch (Exception e) {
			throw new Exception(String.format("Error in sending [%s] to the followed element:[%s]", searchitems,
					selector.toString()));
		}

	}
	public static boolean click(By selector, WebDriver driver) throws Exception {//It is the method for the click
		WebElement element = driver.findElement(selector);
		try {
JavascriptExecutor jse = (JavascriptExecutor)driver;
			
			
			jse.executeScript("arguments[0].click()",element);
			return true;
		} catch (Exception e) {
			
			
			throw new Exception(String.format("The following element is not clickable:[%s]", selector));

		}
	}
	public static boolean select(By selector,WebDriver driver,String day) throws Exception
	{
		WebElement element=driver.findElement(selector);
	try
	{
		Select dropdown =new Select(element);
		
		dropdown.selectByVisibleText(day);
		return true;
	}
	catch(Exception exp)
	{
		throw new Exception(String.format("The following element is under the select:[%s]", selector));
	}
	}
	public static boolean selects(By selector,WebDriver driver,String a) throws Exception
	{
		WebElement element=driver.findElement(selector);
	try
	{
		Select dropdown =new Select(element);
		
		dropdown.selectByValue(a);
		return true;
	}
	catch(Exception exp)
	{
		throw new Exception(String.format("The following element is under the select:[%s]", selector));
	}
	}
	public static boolean action(By selector, WebDriver driver) throws Exception {
		Actions a = new Actions(driver);
		WebElement actel = driver.findElement(selector);
		try {
			a.moveToElement(actel).build().perform();
			return true;
		} catch (Exception e) {
			throw new Exception(String.format("The following element is not hoverable:[%s]", selector));

		}
	

	}
	public static boolean sendKey(By selector, Keys enter, WebDriver driver) throws Exception {
		try
		{
			driver.findElement(selector).sendKeys(enter);
			return true;
		}
		catch (Exception e) {
			throw new Exception(String.format("The following element is not hoverable:[%s]", selector));

		}
	

		
	}
	public static boolean action1(WebElement webElement, WebDriver driver) throws Exception {
		// TODO Auto-generated method stub
		Actions a = new Actions(driver);
		
		try {
			a.moveToElement(webElement).build().perform();
			return true;
		} catch (Exception e) {
	
			throw new Exception(String.format("The following element is not hoverable:[%s]", webElement));

		}
		
		
	}
	public static boolean click1(WebElement webElement, WebDriver driver) throws Exception {
		// TODO Auto-generated method stub
		try
		{
		webElement.click();
		return true;
		}
		catch(Exception e)
		{
			throw new Exception(String.format("The following element is not hoverable:[%s]", webElement));
			
		}
	}
	public static boolean waituntil(By selector, WebDriver driver) throws Exception {
		// TODO Auto-generated method stub
		try
		{
			WebElement el=driver.findElement(selector);
			WebDriverWait wait = new WebDriverWait(driver,10);
					wait.until(ExpectedConditions.visibilityOf(el));
		return true;
		}
		catch(Exception e)
		{
			throw new Exception(String.format("The following element is not hoverable:[%s]",selector));
			
		}
	}


}
