package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class HomepageStudyUI {
	public static By popup=By.xpath("//a[contains(@class,'close-reveal-modal hide-mobile')]");
	public static By studybutton=By.xpath("//li[contains(@class,'topnav_item studyunit')]");
    public static By studytablebutton=By.xpath("//li[contains(@class,'topnav_item studyunit')]//ul[@class='taxonslist']//span[text()='Study Tables']");
    public static By price =By.xpath("//div[contains(text(),'Price')]");
    public static By pricerange =By.xpath("//label[@class='range']");
   public static By addtocompare=By.xpath("//li[contains(@class,'product hovercard')]//div[@class='otherinfo']//a[text()='Add to Compare']");
    public static By comparebutton=By.xpath("//button[text()='Compare']");
}
