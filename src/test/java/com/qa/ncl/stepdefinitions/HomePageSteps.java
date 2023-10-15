package com.qa.ncl.stepdefinitions;

import org.testng.Assert;

import com.qa.ncl.driverfactory.DriverFactory;
import com.qa.ncl.pages.HomePage;
import com.qa.ncl.pages.VacationPage;
import com.qa.ncl.utilities.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	HomePage homePage = new HomePage(DriverFactory.getDriver());
	VacationPage vacationPage;
	
	
	
	
	@Given("user is on home page")
	public void user_is_on_home_page() {
		System.out.println("User is on the Home page");
		String actualTitle = homePage.getHomepageTitle();
		System.out.println("actualTitle " + actualTitle);
		Assert.assertEquals(Constants.HOME_PAGE_TITLE, actualTitle);
	}

	@When("user selects destination {string}")
	public void user_selects_destination(String destination) {
		homePage.selectDestination(destination);
	}

	@When("user selects month {string}")
	public void user_selects_month(String month) {
		homePage.selectMonth(month);
	}

	@When("user clicks on Find a Cruise button")
	public void user_clicks_on_find_a_cruise_button() {
		vacationPage = homePage.clickFindACruiseButton();
	}

	@Then("user should land on vacation page with the list of cruises")
	public void user_should_land_on_vacation_page_with_the_list_of_cruises() {
		vacationPage.getVacationpageTitle();
		//System.out.println("User supposed to be in the vacation page");
	}

}
