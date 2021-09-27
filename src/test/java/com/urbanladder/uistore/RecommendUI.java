package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class RecommendUI {
	public static By popup=By.xpath("//a[contains(@class,'close-reveal-modal hide-mobile')]");
	public static By salesunit=By.xpath("//li[contains(@class,'topnav_item saleunit')]");
	public static By typesofsale=By.xpath("//li[contains(@class,'saleunit')]//ul[@class='taxonslist']//span[text()='Wooden Sofa Sets']");
    public static By recommended=By.xpath("//div[@data-group='sorting']//div[@class='gname']");
    public static By variousoptions=By.xpath("//ul[@class='sortoptions']//li[@class='option']");
    public static By productname=By.xpath("//div[@itemprop='name']");

}
