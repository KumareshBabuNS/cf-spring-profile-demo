# Cloud Foundry Spring Profile Demo
The purpose of this demo is to show how the use of profiles in Spring can be used together with services in Cloud Foundry to inject configuration information into a Spring based application.

The use for this is so that external resources can be configured as services, either as services created in the Cloud Foundry marketplace or by user provided services, and easily be accessed within the applicaiton itself.

Do the the following steps to run the demo on Cloud Foundry:

1. Create the services that the demo application will depend on

 ```
 $ ./create-services.sh
 ```
 This will create two service instances. One is a database connection using the MySQL service. The second is a user provided service with some hard coded values.
2. Build the application

 ```
 $ ./mvnw package
 ```
3. Push the application to Cloud Foundry

 ```
 $ cf push
 ```
4. Use curl against the endpoint reported back by Cloud Foundry to validate that the application is working

 ```
 $ curl http://cf-spring-profile-demo...
 Config: Cloud config
 Some key: somevalue
 Another key: anothervalue
 DB URI Zone: mysql://...
 DB key: jdbc:mysql://...
 ```
 This output reports the configuration used within Spring, the values from the user provided service and connectivity information to the injected database service.
 
See the following two files to see details on how this is enabled within the application:
* [application-cloud.properties](src/main/resources/application-cloud.properties)
  This configuration file is specific for running as a cloud configuration and has references into the VCAP_SERVICES environment variable which contains all injected service information.
* [ConfigController.java](src/main/java/io/pivotal/ConfigController.java)
  This class shows how the properties in the application.properties files can be loaded into the application code.
