Feature: Testing the Tree page of the Ds algo application

Background: The user is logged in to DS Algo portal
     Given User Launch Chrome browser
    When User opens URL "https://dsportalapp.herokuapp.com/"
    And Click on Get Started
    Then Page Title should be "NumpyNinja"
    When User click on Sign in link
    Then Page Title should be "Login"
   	When The user enter invalid "nehasaini09" and "cellphone_09"
   	Then The user click on login button
 
 
       @pageLaunch
  Scenario Outline: User is able to navigate to Tree using dropdown option
  
     When User click on Data Structure DropDown
    And User click on "Tree"
    Then Tree page is displayed
    When User click on topics covered with "<topic>" links 
     When The user clicks Try Here button on Time Complexity page
    Then Page Title should be "Assessment"
    When The user enter python code in tryEditor from sheet "<Sheetname>" and "<rowNumber>"
    And The user clicks on run button
    Then The user should be presented with Run result
    
    
    Examples:
   |topic|
   |Overview of Trees|
   |Terminologies|
   |Types of Trees|
   |Tree Traversals|
   |Traversals-Illustration|
   |Binary Trees|
  | Types of Binary Trees|
   |Implementation in Python|
   |Binary Tree Traversals|
   |Implementation of Binary Trees|
   |Applications of Binary trees|
   |Binary Search Trees|
   |Implementation Of BST|
    
     