package com.qa.ncl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ncl.utilities.ElementUtilities;



public class VacationPage {
	private WebDriver driver;
	private ElementUtilities eleutils;
	
	private By vacationPackages = By.xpath("//div[@class='c66_title']//h2[@class='headline-2-md-up headline-7-xs -variant-10-xs']");
	//private By viewCruiseButton = By.xpath("//div[@class='c495_card optly_banner_true']//a[@title='View Cruise & Offers'][text()='View Cruise & Offers']");
	private By viewCruiseButton = By.xpath("(//a[@title='View Cruise & Offers'][text()='View Cruise & Offers'])[1]");
	
	private By linkCloseAlert = By.xpath("//a[@id='simplemodal-close-img' and @title='Close' and @data-dismiss='modal']");
	
	private void closeAlert() {
		
		try{
			WebElement linkClose = eleutils.getElement(linkCloseAlert);
			linkClose.click();
		}
		catch (Exception e) {System.out.println(e.getStackTrace());}
	}
	
	public VacationPage(WebDriver driver) {
		this.driver = driver;
		eleutils = new ElementUtilities(driver);
	}
	
	
	public String getVacationpageTitle() {
		closeAlert();
		return eleutils.getTitle();
	}
	
	
	public String getVacationPackages() {
		closeAlert();
		return vacationPackages.toString();
	}
	
	public CruisePage navigateToCruisePage() {	
		closeAlert();
		eleutils.doClick(viewCruiseButton);
		return new CruisePage(driver);
	}
	
}
