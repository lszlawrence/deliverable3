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




