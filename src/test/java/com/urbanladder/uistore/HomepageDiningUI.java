package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class HomepageDiningUI {

	public static By popup=By.xpath("//a[contains(@class,'close-reveal-modal hide-mobile')]");
	public static By diningunit=By.xpath("//li[contains(@class,'topnav_item diningunit')]");
	public static By typeofdining=By.xpath("//li[contains(@class,'topnav_item diningunit')]//ul[@class='taxonslist']//span[text()='Dining Tables']");
	public static By pricehandling=By.xpath("//body/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]");
	public static By pricerange=By.xpath("//label[@class='range']");
	public static By resultcount=By.xpath("//div[@class='results-count']");
	
	
	
}
