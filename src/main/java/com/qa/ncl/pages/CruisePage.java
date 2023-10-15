package com.qa.ncl.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ncl.utilities.ElementUtilities;

public class CruisePage {

	private WebDriver driver;
	private ElementUtilities eleutils;
	
	private By advertisedPrice=By.xpath("//span [@class='headline-3 -variant-1']");
	private By linkDateAndPrices=By.xpath("//a[@class='c133_link nav-link link-2' and text()='Dates & Prices']");
	private By priceList=By.xpath("//span[@data-js='price-offer']");

	private String strAdvertisedPrice = "";
	
	
	public CruisePage(WebDriver driver) {
		this.driver = driver;
		eleutils = new ElementUtilities(driver);
	}

	
	public String getCruisepageTitle() {
		return eleutils.getTitle();
	}
	
	public String getAdvertisedPrice() {
		String advPrice= eleutils.getElement(advertisedPrice).getText();
		strAdvertisedPrice = advPrice.substring(0);
		System.out.println("Adv. Price: " + strAdvertisedPrice );
		return strAdvertisedPrice;
	}
	
	public void clickDateandPriceLink() {
		eleutils.doClick(linkDateAndPrices);
	}
	
	public boolean comparePrice() {
		boolean isMatched=false;
		List<WebElement> prices=eleutils.getElements(priceList);
		if(prices.size()>0) {
			for(WebElement e:prices) {
				String price=e.getText();
				//System.out.println(price);
				if(price.equals(getAdvertisedPrice())) {
					isMatched=true;
					System.out.println("Advertised price("+ getAdvertisedPrice() + ") matches with the grid price(" + price + ")");
					break;
				}
			}
		}
		return isMatched;
	}
	
	
	
}
