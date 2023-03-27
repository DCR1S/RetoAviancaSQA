Feature: Reserve a flight

  As a web user
  I want to Reserve a flight
  at Avianca.com

  @smokeTest
  Scenario: Successful booking
    Given that a web user wants to reserve a flight at avianca
    When he fills all the requested fields
    Then he should see his flight reservation