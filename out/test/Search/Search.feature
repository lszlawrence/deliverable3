    Feature: Search

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