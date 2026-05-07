

Feature: Hybrid High Priority flow 

@APT-18
Scenario Outline: Login Test

  And user enter username name "<usernameKey>"
  And user enter password "<passwordKey>"
  And user click on submit button

Examples:
  | usernameKey         | passwordKey         |
  | usernameInPropFile  | PasswordtnPropFile  |


