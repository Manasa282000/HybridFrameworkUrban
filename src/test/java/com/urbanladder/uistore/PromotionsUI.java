package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class PromotionsUI {
	public static By popup=By.xpath("//a[contains(@class,'close-reveal-modal hide-mobile')]");
	public static By salesunit=By.xpath("//li[contains(@class,'topnav_item saleunit')]");
	public static By typeofsales=By.xpath("//li[contains(@class,'topnav_item saleunit')]//a[text()='Promotions']");
	public static By promotions=By.xpath("//a//div[@class='text-center']");
	public static By countofproducts=By.xpath("//div[@class='results-count']");
	
}
