Feature: Testing Data Structure data driven page of the DS algo application

  Background: The user is logged in to DS Algo portal
    Given User Launch Chrome browser
    When User opens URL "https://dsportalapp.herokuapp.com/"
    And Click on Get Started
    Then Page Title should be "NumpyNinja"
    When User click on Sign in link
    Then Page Title should be "Login"
    When The user enter valid "warriors" and "test@1234"
    Then The user click on login button
    

    
    Scenario Outline: The user is able run valid code in tryEditor for Time Complexity page
    Given The user should get a message "You are logged in"
    When User click on Get Started of "<option>"
    Then Page Title should be "Data Structures-Introduction"
    When The user clicks Time Complexity link
    Then Page Title should be "Time Complexity"
    When The user clicks Try Here button on Time Complexity page
    Then Page Title should be "Assessment"
    When The user enter python code in tryEditor from sheet "<Sheetname>" and "<rowNumber>"
    And The user clicks on run button
    Then The user should be presented with Run result
    
    


   Examples: 
      | option                       |Sheetname|rowNumber|
      | data-structures-introduction |pythonCode|0|
      
    