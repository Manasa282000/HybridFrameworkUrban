package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class  	AddressPageUI {

	public static By popup=By.xpath("//a[contains(@class,'close-reveal-modal hide-mobile')]");
			public static By salesunit=By.xpath("//li[contains(@class,'topnav_item bedroomunit')]");
			public static By typeofsales=By.xpath("//li[contains(@class,'topnav_item bedroomunit')]//span[text()='Double Beds']");
			public static By product=By.xpath("//div[@class='product-info-block']//a//div");
			public static By addtocart=By.xpath("//button[contains(text(),'Add to Cart')]");
			public static By checkout=By.xpath("//div//button[@id='checkout-link']");
			public static By orderemail=By.xpath("//input[@id='order_email']");
			public static By pincode=By.xpath("//input[@id='order_ship_address_attributes_zipcode']");
			public static By Address=By.xpath("//textarea[@id='order_ship_address_attributes_address1']");
			public static By Fname=By.id("order_ship_address_attributes_firstname");
			public static By Lname=By.id("order_ship_address_attributes_lastname");
			public static By pnumber=By.id("order_ship_address_attributes_phone");
			
}
