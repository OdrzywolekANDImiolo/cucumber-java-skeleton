Feature: Accounts management functionality
  As a customer
  I want manage my accounts in the bank

  Scenario: list accounts
    Given a customer has two accounts open
    When he lists his accounts
    Then both of them are on the list
    And no other accounts is listed

    Scenario: open account
      Given a customer wants to open an account
      When his account is created
      Then there is a new account on his account list
      And the balance on his account is 0

