Feature: Interacting with products on https://www.aspiration.com/
  Verify that as a user, they can view our products,choose products, see pricing

  @ShouldNavigateToProductsPage
  Scenario: Validating user can get to spend and save page
    Given user visits home page
    When user navigates to products page through spend&save
    Then user can see products page
  @ShouldDisplay2Products
  Scenario: Validating user can see 2 products
    Given user is on products page
    Then user can see 2 products
      | Aspiration | Aspiration Plus |
  @ShouldDisplaySignUpOption
  Scenario: Validating Get Aspiration button offers to sign up
    Given user is on products page
    When user selects original Aspiration plan
    Then email signup input appears

  @ShouldDisplayPlusPlanOptions
  Scenario: Verify Get Aspiration Plus brings window with monthly and yearly plans
    Given user is on products page
    When user selects Plus plan
    Then user can see monthly and yearly plans window

  @ShouldValidateMonthlyYearlyPricing
  Scenario: Verify that yearly radio option is $71.88 paid once yearly
    Given user is on products page
    When user selects Plus plan
    Then user can see yearly plan is "$71.88 paid once yearly"
    And user can see monthly plan is  "$7.99 paid monthly"
