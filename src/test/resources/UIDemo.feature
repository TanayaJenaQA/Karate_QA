Feature: My Demo file 2

  Background:
    * configure driver = { type: 'chrome', executable:'C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe' }

  Scenario: Run one scenario 2
    Given driver 'https://demo.guru99.com/test/newtours/'
    And def max = driver.maximize()
    * screenshot()
    And url 'https://reqres.in/api/users?page=2'
    And request ''
    And method GET
    And print response




