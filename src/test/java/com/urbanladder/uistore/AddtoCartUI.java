package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class AddtoCartUI {
	public static By popup=By.xpath("//a[contains(@class,'close-reveal-modal hide-mobile')]");
	public static By emptycart=By.xpath("//div[@id='cart-badge']//span[contains(@class,'badge-count')]");
	public static By decorunit=By.xpath("//li[contains(@class,'topnav_item bedroomunit')]");
	public static By decortype=By.xpath("//li[contains(@class,'bedroomunit')]//ul[@class='taxonslist']//span[text()='Wardrobes']");
	public static By product=By.xpath("//img[@title='Baltoro High Gloss 2 Door Wardrobe (White Finish)']");
	public static By addtocart=By.xpath("//button[contains(text(),'Add to Cart')]");
	public static By cartcount=By.xpath("//div[@id='cart-badge']//span[contains(@class,'badge-count not-empty')]");
	
}
