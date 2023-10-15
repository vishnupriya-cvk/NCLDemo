package com.qa.ncl.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ncl.utilities.Constants;
import com.qa.ncl.utilities.ElementUtilities;
import com.qa.ncl.utilities.JavaScriptUtilities;

public class HomePage {
	private WebDriver driver;
	private ElementUtilities eleutils;
	private JavaScriptUtilities jsutils;
	
	private By divDestinations = By
			.xpath("//div[@data-code='destination']//span[@class='e1_toggle_single' and contains(text(),'Any Destination')]");
	
	private By divMonths = By
			.xpath("//div[@class='c197_block -dates']");

	private By listDestinationPlaces = By.xpath("//span [@class = 'e5_label']");
	private By linkApplyDestination = By.xpath("//div[@class='c22_menu']//a[@title='Apply' and text()='Apply']");
	private By linkApplyMonth = By.xpath("//div[@class='c22_menu -right']//a[@title='Apply' and text()='Apply']");
	private By linkClearMonth = By.xpath("//div[@class='c22_menu -right']//a[@title='Clear' and text()='Clear']");
	private By selectedMonth = By.xpath("//li[@data-value='May' and @data-year='2024']//input");
	
	private By btnFindACruise = By.xpath("//a[@data-action='find-a-cruise']");   //"//a[contains(text(),'Find a Cruise')]");
	
	private By btnCloseAlert = By.xpath("//button [@id='closeButton']");
	
	private void closeAlertButton() {
		
		try{
			WebElement linkClose = eleutils.getElement(btnCloseAlert);
			linkClose.click();
		}
		catch (Exception e) {System.out.println(e.getStackTrace());}
	}
	
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleutils = new ElementUtilities(driver);
		jsutils = new JavaScriptUtilities(driver);
	}

	public String getHomepageTitle() {
		closeAlertButton();
		return eleutils.getTitle();
	}

	public void openCalendarDiv() {
		closeAlertButton();
		eleutils.clickElementWhenReady(divMonths, Constants.DEFAULT_TIME_OUT);
	}
	
	public void openDestinationsDiv() {
		closeAlertButton();
		eleutils.clickElementWhenReady(divDestinations, Constants.DEFAULT_TIME_OUT);
	}


	public void selectDestination(String place) {
		closeAlertButton();
		System.out.println("Desitination to Key In -"+ place);
		List<WebElement> placeList = eleutils.getElements(listDestinationPlaces);
		
		for (WebElement e : placeList) {
			//String text = e.getText();
			String text = e.getAttribute("innerHTML");
			System.out.println("Cruise Name-"+ e.getAttribute("innerHTML"));
			if (text.equals(place)) {
				System.out.println("Selected Destination-"+ text);
				jsutils.clickElementByJS(e);
				//e.click();
				break;
			}
		}
		clickApplyButton(linkApplyDestination);
	}

	private void clickApplyButton(By locatorName) {
		closeAlertButton();
		System.out.println("Clicking.." + locatorName.toString());
		jsutils.clickElementByJS(eleutils.getElement(locatorName));
		//eleutils.doClick(locatorName);
	}

	public void selectMonth(String month) {
		/*List<WebElement> monthslist = eleutils.getElements(calender);
		for (WebElement e : monthslist) {
			String text = e.getText();
			if (text.equals(month)) {
				e.click();
				break;
			}
		}*/
		//eleutils.clickElementWhenReady(selectedMonth, Constants.DEFAULT_TIME_OUT);
		closeAlertButton();
		openCalendarDiv();
		clickApplyButton(linkClearMonth);
		jsutils.clickElementByJS(eleutils.getElement(selectedMonth));
		clickApplyButton(linkApplyMonth);
	}

	public VacationPage clickFindACruiseButton() {
		closeAlertButton();
		eleutils.doClick(btnFindACruise);
		return new VacationPage(driver);
	}

}
