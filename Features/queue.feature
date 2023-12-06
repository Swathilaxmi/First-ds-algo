Feature: Testing the Queue page of the Ds algo application

Background: The user is logged in to DS Algo portal
     Given User Launch Chrome browser
    When User opens URL "https://dsportalapp.herokuapp.com/"
    And Click on Get Started
    Then Page Title should be "NumpyNinja"
    When User click on Sign in link
    Then Page Title should be "Login"
   	When The user enter invalid "warriors" and "test@1234"
   	Then The user click on login button
 
 
       @pageLaunch
  Scenario Outline: User is able to navigate to Queue using dropdown option
  
     When User click on Data Structure DropDown
    And User click on "Queue"
    Then Queue page is displayed
    When User click on topics covered with "<topic>" links 
     When The user clicks Try Here button on Time Complexity page
    Then Page Title should be "Assessment"
    When The user enter python code in tryEditor from sheet "<Sheetname>" and "<rowNumber>"
    And The user clicks on run button
    Then The user should be presented with Run result
     
    
    
    Examples:
   |topic|
   |Implementation of Queue in Python|
   |Implementation using collections.deque|
   |Implementation using array|
   |Queue Operations|