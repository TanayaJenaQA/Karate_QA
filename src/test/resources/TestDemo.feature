Feature: My Demo file

  Background:
    * def ui = Java.type('com.application.bpm.ui.base.UIActions')
    * def propertyReader = Java.type('com.application.bpm.ui.base.PropertyReader')
    * def loadAllData = propertyReader.loadAllUIAndDBParameters(bpmApplicationURL,bpmApplicationUserName,bpmApplicationPassword,dbUrl,dbUserName,dbPassword)
    * def login = Java.type('com.application.bpm.ui.pages.login.LogIn')
    * def apiBase = Java.type('com.bpm.application.api.ApiBase')

  Scenario Outline: Run one scenario 2
#    Given ui.openChromeBrowser()
#    And login.logInToBPMApplication()
    And login.logprint('<message>');
#    When url apiBaseURI
#    And request ''
#    When method GET
#    Then print response
    Examples:
      | message |
      | hello   |
      |         |