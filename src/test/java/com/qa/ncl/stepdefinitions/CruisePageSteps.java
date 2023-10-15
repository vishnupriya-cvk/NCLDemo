package com.qa.ncl.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.qa.ncl.driverfactory.DriverFactory;
import com.qa.ncl.pages.CruisePage;
import com.qa.ncl.pages.HomePage;
import com.qa.ncl.pages.VacationPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CruisePageSteps {
	
	//HomePage homePage = new HomePage(DriverFactory.getDriver());
	//VacationPage vacationPage;
	CruisePage cruisePage= new CruisePage(DriverFactory.getDriver());;
	//String advPrice = "";
	/*
	 * ALTERNATE Approach to manually mimick the actions
	 * 
	@Given("user already made selections on home and vacations pages")
	public void user_already_made_initial_selections(DataTable dataTable) {
		List<Map<String, String>> selections = dataTable.asMaps();
		homePage.selectDestination(selections.get(0).get("destination"));
		homePage.selectMonth(selections.get(0).get("month"));
		vacationPage = homePage.clickFindACruiseButton();
		cruisePage=vacationPage.navigateToCruisePage();
	}
	*/
	
	@Given("user is on cruise page")
	public void user_is_on_cruise_page() {
		String cruisepageTitle=cruisePage.getCruisepageTitle();
		System.out.println("Cruise page title is :"+cruisepageTitle);
	}

	@Given("user views the advertised price")
	public void user_views_the_advertised_price() {
		String advPrice=cruisePage.getAdvertisedPrice();
		System.out.println("Advertised price is "+advPrice);
	}

	@When("user clicks on DATES & PRICES tab")
	public void user_clicks_on_dates_prices_tab() {
		cruisePage.clickDateandPriceLink();
		System.out.println("user clicked on DATES & PRICES tab");
	}

	@Then("ensure advertised value matches with one of the grid value")
	public void ensure_advertised_value_matches_with_one_of_the_grid_value() {
		boolean isPriceMatched = cruisePage.comparePrice();
		Assert.assertTrue(isPriceMatched);
		System.out.println(isPriceMatched);
	}

	
	
}
