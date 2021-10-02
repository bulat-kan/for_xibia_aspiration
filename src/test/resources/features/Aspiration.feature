Feature: Choosing Aspiration Spend and Save Plan on https://www.aspiration.com/

  Verify that as a user, they can view our products and prices by navigating from the home page to our products page
  via the “Spend & Save” link at the top of the home page


  Scenario: Validating user can get to spend and save page
    Given user visits home page
    When user navigates to products page through spend&save
    Then user can see products page

  Scenario: Validating user can see 2 products
    Given user is on products page
    Then user can see 2 products
      | Aspiration | Aspiration Plus |

  Scenario: Validating Get Aspiration button offers to sign up
    Given user is on products page
    When user selects original Aspiration plan
    Then email signup input appears

  Scenario: Verify that when you click Get Aspiration Plus
           - A modal with monthly and yearly plans appears
    Given user is on products page
    When user selects Plus plan
    Then user can see monthly and yearly plans window

  Scenario: Verify that yearly radio option is $71.88 paid once yearly
    Given user is on products page
    When user selects Plus plan
    Then user can see yearly plan is "$71.88 paid once yearly"
    And user can see monthly plan is  "$7.99 paid monthly"
