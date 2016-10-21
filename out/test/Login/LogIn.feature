  Feature: LogIn
  #User Story:
    #As a user
    #I want to access the homepage and the link on the page
    #So that i can view the details of items i like
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


    Scenario: log in with correct usrname, but empty password
      Given a login page
      And a correct usrname lsz
      And an empty password
      When I try to log in with those credentials
      Then I should receive empty password


    Scenario: log in with correct password, but empty usrname
      Given a login page
      And an correct password 12345
      And an empty usrname
      When I try to log in with those credentials
      Then I should receive empty usrname

    Scenario: I log in successfully
      Given a login page
      And an correct usrname lsz
      And an correct password 12345
      When I try to log in with those right credentials
      Then i should enter my personal site