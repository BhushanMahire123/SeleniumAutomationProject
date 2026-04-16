

Feature: Hybrid High Priority flow 
@Regression
Scenario Outline: Verify user can access vanity URL from event overview page

when User opens URL "<urlKey>"
And User enters Email as "<usernameKey>" and Password as "<passwordKey>"
And Click on Login
When User searches webcast event with event ID "<eventid>"
And User clicks on Search button
Then Verify the title of the searched event is displayed
And User clicks on the title of the searched event
Then User can see overview page title "Webcast Elite | Overview"
And User clicks on Reg Tab

 Examples:
      | urlKey | usernameKey             | passwordKey             | eventid     |
      | url    | usernameKeyInPropFile   | passwordKeyInPropFile   | eventidKey  |

 
 
 
  @Smoke
  Scenario Outline: User resets password successfully
  When User opens URL "<urlKey>"
  And User enters Email as "<usernameKey>" and Password as "<passwordKey>"
  And Click on Login
  And user wait 10 sec
  And User clicks on Account Menu
  And User clicks on Profile Setting
  And User enters Current Password "<currentPasswordKey>"
  And User enters New Password "<newPasswordKey>"
  And User enters Confirm Password "<confirmPasswordKey>"
  And user click on reset password button
  And user wait additional 10 sec
  And User clicks on Save Button

  Examples:  
    | urlKey   | usernameKey                               | passwordKey                               | currentPasswordKey                            | newPasswordKey                                  | confirmPasswordKey                            |
    | urlNA    | propertyfilename_othereventtyep_username  | propertyfilename_othereventtyep_password  | propertyfilename_othereventtyep_password      | propertyfilename_othereventtyep_password_new    | propertyfilename_othereventtyep_password_conf |
    | urlEU    | propertyfilename_othereventtyep_username  | propertyfilename_othereventtyep_password  | propertyfilename_othereventtyep_password      | propertyfilename_othereventtyep_password_new    | propertyfilename_othereventtyep_password_conf  |
 
    
    
    
    
    
    
 @Sanity
Scenario Outline: User resets password for multiple clients

When User opens URL "<urlKey>"
And User enters Email as "<usernameKey>" and Password as "<passwordKey>"
And Click on Login
And user wait additional 10 sec
And user click on client the dropdown
And user selects "<clientName>" from the dropdown
And User clicks on Account Menu
And User clicks on Profile Setting
And User enters Current Password "<currentPasswordKey>"
And User enters New Password "<newPasswordKey>"
And User enters Confirm Password "<confirmPasswordKey>"
And user click on reset password button
And User clicks on Save Button

Examples:
| urlKey | usernameKey            | passwordKey            | clientName         | currentPasswordKey | newPasswordKey | confirmPasswordKey |
| url    | usernameKeyInPropFile  | passwordKeyInPropFile  | client1             | pass1              | newPass1       | newPass1           |
| url    | usernameKeyInPropFile  | passwordKeyInPropFile  | Client2            | newPass1           | newPass2       | newPass2           |
| url    | usernameKeyInPropFile  | passwordKeyInPropFile  | Client3            | newPass2           | newPass3       | newPass3           |
| url    | usernameKeyInPropFile  | passwordKeyInPropFile  | Client4            | newPass3           | newPass4       | newPass4           |
| url    | usernameKeyInPropFile  | passwordKeyInPropFile  | Client5            | newPass4           | newPass5       | newPass5           |
| url    | usernameKeyInPropFile  | passwordKeyInPropFile  | Client6            | newPass5           | newPass6       | newPass6           |
| url    | usernameKeyInPropFile  | passwordKeyInPropFile  | Client7            | newPass6           | newPass7       | newPass7           |
| url    | usernameKeyInPropFile  | passwordKeyInPropFile  | Client8            | newPass7           | newPass8       | newPass8           |
| url    | usernameKeyInPropFile  | passwordKeyInPropFile  | Client9            | newPass8           | newPass9       | newPass9           |
| url    | usernameKeyInPropFile  | passwordKeyInPropFile  | Client10           | newPass9           | newPass10      | newPass10          |
   
   
   
   
   
   
   
   
   
 @Sani
 Scenario Outline: User resets password successfully 
 when User opens URL "<urlKey>"
And User enters Email as "<usernameKey>" and Password as "<passwordKey>"
And Click on Login
When User searches webcast event with event ID "<eventid>"
And User clicks on Search button
Then Verify the title of the searched event is displayed
And User clicks on the title of the searched event
Then User can see overview page title "Webcast Elite | Overview"
#Then I scroll to Hybrid and verify toggle is off
    
    Examples:
      | urlKey | usernameKey             | passwordKey             | eventid     |
      | url    | usernameKeyInPropFile   | passwordKeyInPropFile   | eventidKey  |
      
      
    
@Test
Scenario Outline: User resets password successfully 
when User opens URL "<urlKey>"
And User enters Email as "<usernameKey>" and Password as "<passwordKey>"
And Click on Login     

Examples:
| urlKey | usernameKey                    | passwordKey                  | 
| url    | usernameKeyInPropFile          | passwordKeyInPropFile        |
| url    | invalidusernameKeyInPropFile   | validpasswordKeyInPropFile   | 
| url    | validusernameKeyInPropFile     | invalidpasswordKeyInPropFile  |
| url    | invalidusernameKeyInPropFile   | invalidpasswordKeyInPropFile  |

@Test123
Scenario Outline: User Verify logo
When User opens URL "<urlKey>"
And User Verify logo "ON24"

Examples:
| urlKey |
| url    |



@Hybrid 
Scenario Outline: hybrid flow 
when User opens URL "<urlKey>"
And User enters Email as "<usernameKey>" and Password as "<passwordKey>"
And Click on Login
And user wait additional 10 sec
And user click on create button
And user enter event title "<title>"
And user select date from date picker "<date>"           
And user scroll to Hybrid section
And user clicks on Hybrid toggle
Then Venue and Address fields should be visible
And user enters venue "<venueName>"
And user enters address "<venueAddress>"
And user clicks on Save button
And user wait additional 10 sec
Then User can see overview page title "Overview"
And user scroll to Hybrid section
Then Venue and Address fields should be visible
And user wait additional 10 sec
And user scroll to email section
And user wait additional 10 sec
And user click on preview
And user wait additional 10 sec
And user click on insert token
And user wait additional 10 sec
And user adds email tokens
And user wait additional 10 sec
And user clicks on Save btn
And user wait additional 10 sec
And user clicks on close btn
And user wait additional 10 sec
And user clicks on yes btn
And user wait additional 10 sec
And User clicks on Reg Tab
And user wait additional 10 sec
And user scroll to Attendee_type section
And user wait additional 10 sec
And user clicks on link and embed  btn
And user wait additional 10 sec
And user clicks on Audience Link btn
And user wait additional 10 sec
And user enter first name "<Firstname>"
And user enter last name "<Lastname>"
And user enter email name "<Email>"
And user enter company name "<Company>"
And user select inperson "<Attendee_Type>"
And user clicks on register button
Examples:
| urlKey | usernameKey           | passwordKey              | title                |date           |  venueName          | venueAddress             |Firstname          |Lastname           |Email            |Company              |Attendee_Type             |
| url   | usernameKeyInPropFile | passwordKeyInPropFile | eventtitleInPropFile |dateInPropFile | venueNameInPropFile | venueAddressInPropFile  |FirstnameInPropFile|LastnameInPropFile |EmailInPropFile  | CompanyInPropFile   | InPropFile_Attendee_Type |




@RegressionTest
Scenario Outline: Verify user can access vanity URL from event overview page

when User opens URL "<urlKey>"
And User enters Email as "<usernameKey>" and Password as "<passwordKey>"
And Click on Login
When User searches webcast event with event ID "<eventid>"
And User clicks on Search button
Then Verify the title of the searched event is displayed
And User clicks on the title of the searched event
Then User can see overview page title "Webcast Elite | Overview"
And User clicks on Reg Tab

 Examples:
      | urlKey | usernameKey             | passwordKey             | eventid     |
      | url    | usernameKeyInPropFile   | passwordKeyInPropFile   | eventidKey  |


@Tutorial
@APT-2
 Scenario Outline: User Registration

  when User opens URL "<urlKey>"
  And user wait additional 10 sec
  And user enter f name "<firstnameKey>"
  And user enter l name "<lastnameKey>"
  And user enter mail "<emailKey>"
  And user enter telephone "<telephoneKey>"
  And user enter pass "<passwordKey>"
  And user enter conf password "<confirmPasswordKey>"
  #And user select newsletter yes
  And user accept privacy policy
  And user clicks on continue button

Examples:
  | urlKey | firstnameKey           | lastnameKey | emailKey | telephoneKey | passwordKey | confirmPasswordKey |
  | url    | firstInPropFile    | lastInPropFile    | mailInPropFile    | teleInPropFile    | passInPropFile    | confPasswordInPropFile    |



@practice
Scenario Outline: Login Test

  And user enter username name "<usernameKey>"
  And user enter password "<passwordKey>"
  And user click on submit button

Examples:
  | usernameKey         | passwordKey         |
  | usernameInPropFile  | PasswordtnPropFile  |





