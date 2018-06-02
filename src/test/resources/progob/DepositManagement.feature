Feature: Deposits management functionality
  As a customer
  I want manage my deposits in the bank

  Scenario: opening deposit
    Given a customer has an account with balance 100
    When he opens a deposit with balance 90
    Then he owns a deposit with balance 90
    And the account has balance 10

