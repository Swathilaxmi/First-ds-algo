Feature: Home

   @Regression
  Scenario Outline: Click on DataStructure DropDown without login
    Given User Launch Chrome browser
    When User opens URL "https://dsportalapp.herokuapp.com/"
    And Click on Get Started
    Then Page Title should be "NumpyNinja"
    When User click on Data Structure DropDown
    And User click on "<option>"
    Then The user get warning message "You are not logged in"
    

    Examples: 
      | option      |
      | Arrays      |
      | Linked List |
      | Stack       |
      | Queue       |
      | Tree        |
      | Graph       |

@Regression
Scenario Outline: Click on Get Started of Each DataStructure Section without login
    Given User Launch Chrome browser
    When User opens URL "https://dsportalapp.herokuapp.com/"
    And Click on Get Started
    Then Page Title should be "NumpyNinja"
    When User click on Get Started of "<option>"
    Then The user get warning message "You are not logged in"
    

    Examples: 
      | option      |
      |data-structures-introduction|	
      | array      |
      | linked-list |
      | stack       |
      | queue       |
      | tree        |
      | graph       |
    