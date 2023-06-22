Feature: Registration functinality

Scenario: user creates an account with mandatory fields
Given user navigates to Register account page
When user enters the details into below fields
|firstname          |Abhishek|
|lastname						|Wani|
#|email     					|abhishek123@gmail.com|
|telephone					|9090909090|
|password						|1234098|
And user selects Privacy Policy
And user clicks continue button
Then user account should get created successfully

Scenario: user creates an account with all fields
Given user navigates to Register account page
When user enters the details into below fields
|firstname          |Abhishek|
|lastname						|Wani|
#|email     					|abhishek123456@gmail.com|
|telephone					|9090909090|
|password						|1234098|
And user select Yes for Newsletter
And user selects Privacy Policy
And user clicks continue button
Then user account should get created successfully

Scenario: user creates an duplicate account
Given user navigates to Register account page
When user enters the details into below fields with duplicate email
|firstname          |Abhishek|
|lastname						|Wani|
|email     					|abhi@gmail.com|
|telephone					|9090909090|
|password						|1234098|
And user select Yes for Newsletter
And user selects Privacy Policy
And user clicks continue button
Then user should get a proper warning about duplicate email

Scenario: user creates an account without filling any details
Given user navigates to Register account page
When user dont enter any details into fields
And user clicks continue button 
Then user should get proper warning massages for every mandatory fields