@Login
Feature: Login to Sauce home page

  @qa1
  Scenario: Success Login to Sauce home page
    Given Carlos is a SauceCustomer
    When He tries to login
    Then He should see to products list

  @qa1
  Scenario: Success Login to Sauce home page
    Given Carlos is a SauceCustomer
    When He tries to login
    Then He should see to products list

  @qa2
  Scenario Outline: Success Login to Sauce home page
    Given Carlos is a SauceCustomer
    When He tries to login with user name <userName> and password <password>
    Then He should see to products list
    Examples:
      | userName       | password     |
      | standard_user  | secret_sauce |

  @qa2
  Scenario Outline: Success Login to Sauce home page
    Given Carlos is a SauceCustomer
    When He tries to login with user name <userName> and password <password>
    Then He should see to products list
    Examples:
      | userName       | password     |
      | standard_user  | secret_sauce |


  @qa3
  Scenario: Success Logout to Sauce home page
    Given Carlos is a SauceCustomer
    When He tries to log out
    Then He should see the log in page


  @qa4
  Scenario: Success Login to Sauce home page
    Given Carlos is a SauceCustomer
    When He tries to login
    Then He should see to products list