Prerequisite:
    Install following. 
	1.OpenJDK 18 Add JDK's bin directory  to PATH and set JAVA_HOME to JDK installation directory
	2.Gradle 7.4.2 Add gradle bin directory to PATH and set GRADLE_HOME to gradle installation directory
	3.Postgres 14 

1. Unzip the file to C:\Projects\
   	PROJ_HOME = c:\Projects\ems 

2. Run the server using following command in terminal: 
	PROJ_HOME\bin\emsapp.cmd or gradle bootRun
	
3. Run the tests using any of the following command in terminal: 
	gradle clean test (testing with out producing artifacts)
	gradle build (produce test results and also artifacts)
	gradle test 
		

Then it will produce test report on the following location:
	{PROJ_HOME}\build\reports\tests\test