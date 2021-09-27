package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class StoreofUrbanLadderUI {

	public static By popup=By.xpath("//a[contains(@class,'close-reveal-modal hide-mobile')]");
	public static By store=By.xpath("//header/section[1]/div[1]/ul[2]/li[1]/a[1]");
   public static By placeheadings=By.xpath("//div//a//h3");
  public static By viewbutton=By.xpath("//button[contains(text(),'View Details')]");
  public static By address=By.xpath("//div[@class='info-section']//address");
   
   
}
