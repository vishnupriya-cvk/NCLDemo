package com.qa.ncl.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
features = { "src\\test\\resources\\features" },
glue = {
		"com.qa.ncl.stepdefinitions.Hooks",
		"com.qa.ncl.stepdefinitions"
		}, 
plugin = { "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
publish = true

)

public class TestRunner {

}

