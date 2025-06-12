# Create a config.properties local file into /src/test/resources/config.properties (this file is ignored) and copy the config.properties-example to have the latest environment variables.


## TestNG command per suite
mvn clean test "-DsuiteXmlFile=testng/login-suite.xml"
mvn clean test "-DsuiteXmlFile=testng/contacts-suite.xml"
