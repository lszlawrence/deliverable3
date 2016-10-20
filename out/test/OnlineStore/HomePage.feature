Feature: Home page

  #User Story:
  #As a user
  #I want to access the homepage and the link on the page
  #So that i can view the details of items i like
  Scenario: Home page title
    Given a Firefox browser
    When I navigate to the home page
    Then the title should be ONLINE STORE | Toolsqa Dummy Test site

  Scenario: click tag
    Given  a Firefox browser
    When I navigate to the home page
    And I click the Product Category
    Then the title should be Product Category | ONLINE STORE

  Scenario: click footer picture
    Given a Firefox browser
    When I navigate to the home page
    And I click the iphone5 picture in the homepage
    Then the site should be the item i click



  #User Story:
  #As a user
  #I want to log in
  #So that i can access my store account

  Scenario Outline: I log in with correct username, but incorrect password
    Given a login page
    And a correct usrname <username>
    And an incorrect password <password>
    When I try to log in with those credentials
    Then I should receive <an error message>

    Examples:
    |username|password|     an error message    |
    |  lsz   |123456  |Invalid login credentials|
    |  lsz   |wq3456  |Invalid login credentials|
    |  lsz   |asdfgg  |Invalid login credentials|
    |  lsz   |        |Invalid login credentials|


   Scenario Outline: I log in with incorrect username, but correct password
     Given a login page
     And an incorrect usrname <username>
     And an  correct password <password>
     When I try to log in with those credentials
     Then I should receive <an error message>

     Examples:
     |username|password|     an error message    |
     |lszl    |12345   |Invalid login credentials|
     |l1234   |12345   |Invalid login credentials|
     |1234    |12345   |Invalid login credentials|
     |        |12345   |Invalid login credentials|


    Scenario: I log in successfully
      Given a login page
      And an correct usrname lsz
      And an correct password 12345
      When I try to log in with those right credentials
      Then i should enter my personal site

    #User Story:
    #As a user
    #I want to search the items i want
    #so that i can easily access to the item i want

   Scenario: search function with blur item
    Given a Firefox browser
    When I navigate to the home page
    And  search App
    Then the result should contain Apple


   Scenario: search function with exactly item
    Given a Firefox browser
    When I navigate to the home page
    And search iphone 5
    Then the result should contain iPhone 5


    Scenario: search function with item not existed
    Given a Firefox browser
    When I navigate to the home page
    And search galaxy
    Then the result should contain Sorry


