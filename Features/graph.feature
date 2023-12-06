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
  Scenario Outline: User is able to navigate to graph using dropdown option
  
     When User click on Data Structure DropDown
    And User click on "Graph"
    Then graph page is displayed
    When User click on options of graph "<topic>" links 
     When The user clicks Try Here button on Time Complexity page
    Then Page Title should be "Assessment"
    When The user enter python code in tryEditor from sheet "<Sheetname>" and "<rowNumber>"
    And The user clicks on run button
    Then The user should be presented with Run result
     
    
    
    Examples:
   |topic|
   |graph|
   |graph-representations|
  