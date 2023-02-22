@Login
Feature: Login to Sauce home page

  @qa
  Scenario: Success Login to Sauce home page
    Given Carlos is a SauceCustomer
    When He tries to login
    Then He should see to products list

  @qa
  Scenario Outline: Success Login to Sauce home page
    Given Carlos is a SauceCustomer
    When He tries to login with user name <userName> and password <password>
    Then He should see to products list
    Examples:
      | userName       | password     |
      | standard_user  | secret_sauce |


  @qa
  Scenario: Success Logout to Sauce home page
    Given Carlos is a SauceCustomer
    When He tries to log out
    Then He should see the log in page