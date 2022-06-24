Feature: Skyfall Page Login 

Background: Successful Login to Skyfall-PCS with Valid Credentials 
 Given User Launch Chrome browser 
 When User opens URL "http://10.129.8.106:8082/login" 
 And User enters Username as "admin" and Password as "snps01" 
 And Click on Login 
 Then Page Title should be "MI Skyfall" 
 
@sanity 
Scenario: Successful Login to Skyfall-PCS with Valid Credentials 
 When User click on User Image 
 Then User click on Logout 
 And close browser 
 
 # @regression 
 # Scenario Outline: Login Data Driven 
 #  Given User Launch Chrome browser 
 #  When User opens URL "http://10.129.8.106:8082/login" 
 #  And User enters Username as "<Username>" and Password as "<Password>" 
 
 #  Examples: 
 # | Username     | Password |
 # | testuser     | test123  |
 # | admin        | snps01   |
 