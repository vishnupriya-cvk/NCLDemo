Feature: CruisePage features

Background: user has made initial selections and selected the cruise package on the vacations page
Given user is on home page
When user selects destination "Alaska Cruises" 
And user selects month "May"
And user clicks on Find a Cruise button 
Given user is on vacations page
And user is able to view atleast one vacation package
When user clicks on VIEW CRUISE button
Then user lands on cruise page

#Alternate Way to use DataTable to mimick home page & vacation page actions
#Given user already made selections on home and vacations pages
#|destination|month|
#|Alaska Cruises|May 2024|

Scenario: view the advertised starting prices for the selected package and compare against grid values
Given user is on cruise page
And user views the advertised price
When user clicks on DATES & PRICES tab
Then ensure advertised value matches with one of the grid value
