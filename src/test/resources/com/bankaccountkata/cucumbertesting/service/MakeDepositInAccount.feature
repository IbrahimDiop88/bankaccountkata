Feature: As a bank client
  I want to make a deposit in my account

  Scenario: Make a deposit in my account
    Given The customer name "DIOP" and phone "07777777" with account type "current" want to deposit "100"
    When the client calls /deposit
    Then the account of client is credited 
