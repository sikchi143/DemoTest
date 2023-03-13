Feature: JBK offline application

Scenario:login test

Given user should be on login page
When user enters valid credentials
Then user should be on home page

Scenario: verify email error

Given user should be on login page
When user enter invalid username
Then verify email error

Scenario: verify password error

Given user should be on login page
When user enter invalid password
Then verify password error