Feature: Testing the Array page of the Ds algo application

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
  Scenario Outline: User is able to navigate to Array using dropdown option
  
     When User click on Data Structure DropDown
    And User click on "Array"
    Then Arrays page is displayed
    When User click on topics covered with "<topic>" links 
    When The user clicks Try Here button on Time Complexity page
    Then Page Title should be "Assessment"
    When The user enter python code in tryEditor from sheet "<Sheetname>" and "<rowNumber>"
    And The user clicks on run button
    Then The user should be presented with Run result
     
     
    
    Examples:
   |topic|
   |Arrays in Python|
   |Arrays Using List|
   |Basic Operations in Lists|
   |Applications of Array|
   
   
      @pageLaunch
   Scenario Outline: User is able to navigate to Array next page
  
     When User click on Data Structure DropDown
    And User click on "Array"
    When User clicks on pratice button
   Then new array page opens
    When  click on topics covered with "<topic>" 
    Then new page displayed
    And User clicks on run button
     
     
    Examples:
  |topic|
  |Search the array|
  |Max Consecutive Ones|
  |Find Numbers with Even Number of Digits|
  |Squares of  a Sorted Array|
  
   