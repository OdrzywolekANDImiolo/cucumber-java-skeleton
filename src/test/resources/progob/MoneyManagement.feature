Feature: Money management on bank account
  As a customer
  I want transfer my money between bank accounts

  Scenario: transfer money
    Given balance on account A is 100
    And balance on account B is 1000
    When 99.91 is transfered from account A to B
    Then balance on account A is 0.09
    And balance on account B is 1099.91

  Scenario: deposit money
    Given balance on the account is 100
    When customer deposits 10 to this account
    Then balance on the account is 110

  Scenario: withdrawn money
    Given balance on the account is 100
    When customer withdrawns 90 to this account
    Then balance on the account is 10