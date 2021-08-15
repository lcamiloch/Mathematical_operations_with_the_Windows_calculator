@calculator
Feature: Calculator operation

  @mathematicalOperations
  Scenario: numerical operations
    Given The customer wants to test the functionality of the calculator
    When He adds all visible even numbers
    And He then subtracts all visible odd numbers
    Then He should get the result -5