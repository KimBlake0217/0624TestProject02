$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/Skyfall_Login.feature");
formatter.feature({
  "name": "Skyfall Page Login",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "Successful Login to Skyfall-PCS with Valid Credentials",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Launch Chrome browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Skyfall_Steps_01.user_launch_chrome_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User opens URL \"http://10.129.8.106:8082/login\"",
  "keyword": "When "
});
formatter.match({
  "location": "Skyfall_Steps_01.user_opens_url(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters Username as \"admin\" and Password as \"snps01\"",
  "keyword": "And "
});
formatter.match({
  "location": "Skyfall_Steps_01.user_enters_email_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Login",
  "keyword": "And "
});
formatter.match({
  "location": "Skyfall_Steps_01.click_on_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Page Title should be \"MI Skyfall\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Skyfall_Steps_01.page_title_should_be(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Successful Login to Skyfall-PCS with Valid Credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sanity"
    }
  ]
});
formatter.step({
  "name": "User click on User Image",
  "keyword": "When "
});
formatter.match({
  "location": "Skyfall_Steps_01.user_click_on_user_image()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on Logout",
  "keyword": "Then "
});
formatter.match({
  "location": "Skyfall_Steps_01.user_click_on_log_out_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "Skyfall_Steps_01.close_browser()"
});
formatter.result({
  "status": "passed"
});
});