Feature: Vacations features

Background: user has made initial selections 
Given user is on home page
When user selects destination "Alaska Cruises" 
And user selects month "May"
And user clicks on Find a Cruise button 
#Alternate Way to use DataTable to mimick home page actions
#Given user has already made initial selections
#|destination|month|
#|Alaska Cruises|May 2024|

Scenario: view the listed vacations and choose one of the packages
Given user is on vacations page
And user is able to view atleast one vacation package
When user clicks on VIEW CRUISE button
Then user lands on cruise page