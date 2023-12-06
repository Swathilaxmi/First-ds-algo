Feature: Testing Signin page of the DS algo application

  Scenario: Verifying Register link
    Given User Launch Chrome browser
    When User opens URL "https://dsportalapp.herokuapp.com/"
    And Click on Get Started
    Then Page Title should be "NumpyNinja"
    When User click on Sign in link
    Then Page Title should be "Login"
    When The user clicks on register link on signin page
    And Page Title should be "Registration"
    

   @Invalid
  Scenario Outline: Click Sign In
    Given User Launch Chrome browser
    When User opens URL "https://dsportalapp.herokuapp.com/"
    And Click on Get Started
    Then Page Title should be "NumpyNinja"
    When User click on Sign in link
    Then Page Title should be "Login"
    When The user enter invalid "<username>" and "<password>"
    And The user click on login button
    Then The user should get error message "Please fill out this field." below first empty field "<username>" "<password>"
   

    Examples: 
      | username | password |
      |          |          |
      |          | passowrd |
      | user     |          |


  @Sanity @Regression
  Scenario: Verifying signout link
    Given User Launch Chrome browser
    When User opens URL "https://dsportalapp.herokuapp.com/"
    And Click on Get Started
    Then Page Title should be "NumpyNinja"
    When User click on Sign in link
    Then Page Title should be "Login"
    When The user enter valid "warriors" and "test@1234"
    And The user click on login button
    Then The user should get a message "You are logged in"
    When The user clicks on Signout button
    Then The user should get a message "Logged out successfully"
    
