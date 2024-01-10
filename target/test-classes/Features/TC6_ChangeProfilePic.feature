@Changeprofile
Feature: Change Profile  Module API Automation

Scenario Outline: Verify user change profile picture through API
Given User add header,bearer authorization and multipart for accessing changeProfilePic endpoint
When User add  the file to change profile picture 
And  User sent "POST" request for changeProfilePic endpoint
Then User should verify statuscode is 200
And User Should verify changeProfilePic respond message matches "Profile updated Successfully"
