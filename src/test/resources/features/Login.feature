Feature: Login User

@tag1
  Scenario: User invalid login
    Given User go to Web HRM
    When User enter username and password
    And User click button login
    Then User invalid credentials
    
@tag2
  Scenario: User valid login
  	Given User go to Web HRM
    When User enter username and password valid
    And User click button login valid
    Then User valid credentials