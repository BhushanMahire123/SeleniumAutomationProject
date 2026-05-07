

Feature: Hybrid High Priority flow 

@APT-18
Scenario Outline: Login Test
 Given User launches login page
  And user enter username name "<usernameKey>"
  And user enter password "<passwordKey>"
  And user click on submit button

Examples:
  | usernameKey         | passwordKey         |
  | usernameInPropFile  | PasswordtnPropFile  |
  
  
@APT-19

Scenario Outline: Successful user registration

  Given User launches register page

  When user enters firstname "<firstname>"
  And user enters lastname "<lastname>"
  And user enters email "<email>"
  And user enters telephone "<telephone>"
  And user enters password "<password>"
  And user enters confirm password "<confirmpassword>"
  And user clicks privacy policy checkbox
  And User clicks on continue button

  Then Account should get created successfully

Examples:
  | firstname | lastname | email  | telephone   | password  | confirmpassword |
  | firstname | lastname | email  | telephone   | password  | password         |