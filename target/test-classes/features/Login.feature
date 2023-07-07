Feature: Login functionality

Scenario Outline: Login with valid credentials
Given user navigates to login page
When user has entered valid email address <username> into email field
And user has entered valid password <password> into password field
And user clicks on Login button
Then user gets login successfully
Examples:
|username										|password|
|abhishek9420@gmail.com			|12345|
|abhishek9421@gmail.com			|12345|
|abhishek9422@gmail.com			|12345|

Scenario: Login with invalid credentials
Given user navigates to login page
When user has entered invalid email address into email field
And user has entered invalid password "12345678" into password field
And user clicks on Login button
Then user should get proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password credentials
Given user navigates to login page
When user has entered valid email address "abhishek9420@gmail.com" into email field
And user has entered invalid password "12345678" into password field
And user clicks on Login button
Then user should get proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password credentials
Given user navigates to login page
When user has entered invalid email address into email field
And user has entered valid password "12345" into password field
And user clicks on Login button
Then user should get proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given user navigates to login page
When user dont enter email address into email field
And user dont enter password into password field
And user clicks on Login button
Then user should get proper warning message about credentials mismatch