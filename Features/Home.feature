Feature: Home
  
  @Sanity @priority01
  Scenario: Click Register
    Given User Launch Chrome browser
    When User opens URL "https://dsportalapp.herokuapp.com/"
    And Click on Get Started
    Then Page Title should be "NumpyNinja"
    When User click on Register link
    Then Page Title should be "Registration"
    

  @Sanity @priority02
  Scenario: Click Sign In
    Given User Launch Chrome browser
    When User opens URL "https://dsportalapp.herokuapp.com/"
    And Click on Get Started
    Then Page Title should be "NumpyNinja"
    When User click on Sign in link
    Then Page Title should be "Login"
    

 
