

@smoke
Feature: F02_Login | users could use login functionality to use their accounts
  Scenario: user could login with valid email and password
    Given user go to login page
    Given user login with "test1@example.com" and "P@ssw0rd"
    When user press on login button
    Then user login to the system successfully

#1- getCurrentUrl and verify it equals https://demo.nopcommerce.com/
#2- "My account" tab isDisplayed

@smoke
  Scenario: user could login with invalid email and password
    Given user go to login page
    Given user login with "wrong@example.com" and "P@ssw0rd"
    Given user press on login button
    Given user could not login to the system

#Use soft assertion to verify the following
#1- error message contains "Login was unsuccessful."
#2- the color of this message is red "#e4434b"
#don't forget assertAll()

