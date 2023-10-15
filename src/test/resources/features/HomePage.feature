Feature: Landing page features
Scenario: Client filters cruises by destination and price on the Landing page 
Given user is on home page
When user selects destination "Alaska Cruises" 
And user selects month "May"
And user clicks on Find a Cruise button 
Then user should land on vacation page with the list of cruises


