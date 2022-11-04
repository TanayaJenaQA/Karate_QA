function fn() {

// all common config parameters set here
  karate.configure('connectTimeout', 50000);
  karate.configure('readTimeout', 50000);
  karate.configure('ssl', true);

// set your environment before you run test case
  var environment = 'dev'
   karate.log('karate environment property was:', environment);

   var config = {
    bpmApplicationURL:'',
    bpmApplicationUserName:'',
    bpmApplicationPassword:'',
    apiBaseURI:'https://some-host.com/v1/auth/',
    apiUserName:'',
    apiUserPassword:'',
    dbUrl:'',
    dbUserName:'',
    dbPassword: ''
  };

  // set application , api and db information here based on your environment
  if (environment == 'test') {
        config.bpmApplicationURL = 'https://reqres.in/api/users?page=2';
        config.bpmApplicationUserName ='bpmApplicationUserName';
        config.bpmApplicationPassword ='bpmApplicationPassword';
        config.apiBaseURI = 'https://reqres.in/api/users?page=2';
        config.apiUserName ='apiUserName';
        config.apiUserPassword ='apiUserPassword';
        config.dbUrl ='dbUrl';
        config.dbUserName ='dbUserName';
        config.dbPassword ='dbPassword';
  } else if (environment == 'dev') {
        config.bpmApplicationURL = 'https://demo.guru99.com/test/newtours/';
        config.bpmApplicationUserName ='testUser';
        config.bpmApplicationPassword ='testUserName';
        config.apiBaseURI ='https://reqres.in/api/users?page=2';
        config.apiUserName ='apiUserName';
        config.apiUserPassword ='apiUserPassword';
        config.dbUrl ='dbUrl';
        config.dbUserName ='dbUserName';
        config.dbPassword ='dbPassword';
  }
  return config;
}