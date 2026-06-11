Feature: Hybrid High Priority flow 

@released4run
@WAP-3
Scenario Outline: Login Test
 Given User launches login page
  And user enter username name "<usernameKey>"
  And user enter password "<passwordKey>"
  And user click on submit button

Examples:
  | usernameKey         | passwordKey         |
  | usernameInPropFile  | PasswordtnPropFile  |
  
  
@daily1
@WAP-2


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
  | firstname | lastname | email  | telephone   | passwordtest  | confpassword         |

@APT-4
Scenario: Register with mismatched password
Given User launches register page
  When user enters firstname "<firstname>"
  And user enters lastname "<lastname>"
  And user enters email "<email2>"
  And user enters telephone "<telephone>"
  And user enters password "<password>"
  And user enters confirm password "<confirmpassword>"
  And user clicks privacy policy checkbox
  And User clicks on continue button
  Then Password mismatch warning should display "<passmismatchmsg>"

 Examples:
  | firstname | lastname | email2  | telephone   | password  | confirmpassword |warningmsg                             |passmismatchmsg|
  | firstname | lastname | email2  | telephone   | password1  | password2       | E-Mail Address is already registered! |Password confirmation does not match password!|
  
  
  
  
@APT-9
Scenario: Register with mismatched password
Given User launches orangehrm url
When user scroll to featured section
And  user click on macbook product
When user scroll to addtocart section
Then add to cart section should be visible
And user click on add to cart button
And user click on add to cart icon