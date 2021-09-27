package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class SearchBoxUI {
	public static By popup=By.xpath("//a[contains(@class,'close-reveal-modal hide-mobile')]");
	public static By searchbox=By.xpath("//input[@id='search']");
	public static By product=By.xpath("//div[@class='product-info-block']//a//div");
	 public static By addtocart =By.xpath("//button[contains(text(),'Add to Cart')]");

}
