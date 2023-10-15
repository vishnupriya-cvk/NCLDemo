package com.qa.ncl.stepdefinitions;

import java.util.List;
import java.util.Map;

import com.qa.ncl.driverfactory.DriverFactory;
import com.qa.ncl.pages.CruisePage;
import com.qa.ncl.pages.HomePage;
import com.qa.ncl.pages.VacationPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VacationPageSteps {

	//HomePage homePage = new HomePage(DriverFactory.getDriver());
	VacationPage vacationPage = new VacationPage(DriverFactory.getDriver());;
	CruisePage cruisePage;
	String strAdvertisedValue = "";
	
	/*
	 * @Given("user has already made initial selections")
	 * ALTERNATE Approach to manually mimick the actions
	public void user_already_made_initial_selections(DataTable dataTable) {
		List<Map<String, String>> selections = dataTable.asMaps();
		homePage.selectDestination(selections.get(0).get("destination"));
		homePage.selectMonth(selections.get(0).get("month"));
		vacationPage = homePage.clickFindACruiseButton();
	}
	*/
	
	
	@Given("user is on vacations page")
	public void user_is_on_vacations_page() {
		System.out.println("TITLE: "  + vacationPage.getVacationpageTitle());
		//String actualTitle = vacationPage.getVacationpageTitle();
	}
	
	@Given("user is able to view atleast one vacation package")
	public void user_able_to_view_vacation_package() {
		System.out.println(vacationPage.getVacationPackages());
	}
	
	@When("user clicks on VIEW CRUISE button")
	public void user_clicks_on_view_cruise_button() {
		cruisePage = vacationPage.navigateToCruisePage();
	}

	@Then("user lands on cruise page")
	public void user_lands_on_cruise_page() {
		System.out.println(cruisePage.getCruisepageTitle());
	}
	
}