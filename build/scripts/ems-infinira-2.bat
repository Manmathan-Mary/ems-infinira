@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  ems-infinira-2 startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and EMS_INFINIRA_2_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\ems-infinira-2-0.0.1-SNAPSHOT-plain.jar;%APP_HOME%\lib\httpasyncclient-4.1.5.jar;%APP_HOME%\lib\httpmime-4.5.13.jar;%APP_HOME%\lib\httpclient-4.5.13.jar;%APP_HOME%\lib\log4j-core-2.20.0.jar;%APP_HOME%\lib\spring-boot-starter-web-2.7.1.jar;%APP_HOME%\lib\spring-boot-starter-actuator-2.7.1.jar;%APP_HOME%\lib\spring-boot-starter-json-2.7.1.jar;%APP_HOME%\lib\spring-boot-starter-2.7.1.jar;%APP_HOME%\lib\spring-boot-starter-logging-2.7.1.jar;%APP_HOME%\lib\log4j-to-slf4j-2.17.2.jar;%APP_HOME%\lib\log4j-api-2.20.0.jar;%APP_HOME%\lib\tomcat-embed-jasper-9.0.64.jar;%APP_HOME%\lib\javax.faces-2.3.7.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-2.7.1.jar;%APP_HOME%\lib\postgresql-42.4.0.jar;%APP_HOME%\lib\httpcore-nio-4.4.15.jar;%APP_HOME%\lib\httpcore-4.4.15.jar;%APP_HOME%\lib\commons-codec-1.15.jar;%APP_HOME%\lib\groovy-ant-3.0.11.jar;%APP_HOME%\lib\groovy-astbuilder-3.0.11.jar;%APP_HOME%\lib\groovy-cli-picocli-3.0.11.jar;%APP_HOME%\lib\groovy-groovysh-3.0.11.jar;%APP_HOME%\lib\groovy-console-3.0.11.jar;%APP_HOME%\lib\groovy-datetime-3.0.11.jar;%APP_HOME%\lib\groovy-groovydoc-3.0.11.jar;%APP_HOME%\lib\groovy-docgenerator-3.0.11.jar;%APP_HOME%\lib\groovy-jmx-3.0.11.jar;%APP_HOME%\lib\groovy-json-3.0.11.jar;%APP_HOME%\lib\groovy-jsr223-3.0.11.jar;%APP_HOME%\lib\groovy-macro-3.0.11.jar;%APP_HOME%\lib\groovy-nio-3.0.11.jar;%APP_HOME%\lib\groovy-servlet-3.0.11.jar;%APP_HOME%\lib\groovy-sql-3.0.11.jar;%APP_HOME%\lib\groovy-swing-3.0.11.jar;%APP_HOME%\lib\groovy-templates-3.0.11.jar;%APP_HOME%\lib\groovy-test-3.0.11.jar;%APP_HOME%\lib\groovy-test-junit5-3.0.11.jar;%APP_HOME%\lib\groovy-testng-3.0.11.jar;%APP_HOME%\lib\groovy-xml-3.0.11.jar;%APP_HOME%\lib\groovy-3.0.11.jar;%APP_HOME%\lib\spring-webmvc-5.3.21.jar;%APP_HOME%\lib\spring-web-5.3.21.jar;%APP_HOME%\lib\spring-boot-actuator-autoconfigure-2.7.1.jar;%APP_HOME%\lib\micrometer-core-1.9.1.jar;%APP_HOME%\lib\tomcat-embed-websocket-9.0.64.jar;%APP_HOME%\lib\tomcat-embed-core-9.0.64.jar;%APP_HOME%\lib\tomcat-embed-el-9.0.64.jar;%APP_HOME%\lib\ecj-3.18.0.jar;%APP_HOME%\lib\jakarta.annotation-api-1.3.5.jar;%APP_HOME%\lib\checker-qual-3.5.0.jar;%APP_HOME%\lib\ant-junit-1.10.12.jar;%APP_HOME%\lib\ant-1.10.12.jar;%APP_HOME%\lib\ant-launcher-1.10.12.jar;%APP_HOME%\lib\ant-antlr-1.10.12.jar;%APP_HOME%\lib\picocli-4.6.1.jar;%APP_HOME%\lib\qdox-1.12.1.jar;%APP_HOME%\lib\javaparser-core-3.24.2.jar;%APP_HOME%\lib\jline-2.14.6.jar;%APP_HOME%\lib\junit-4.13.2.jar;%APP_HOME%\lib\junit-platform-launcher-1.8.2.jar;%APP_HOME%\lib\junit-platform-engine-1.8.2.jar;%APP_HOME%\lib\junit-platform-commons-1.8.2.jar;%APP_HOME%\lib\junit-jupiter-engine-5.8.2.jar;%APP_HOME%\lib\junit-jupiter-api-5.8.2.jar;%APP_HOME%\lib\testng-7.5.jar;%APP_HOME%\lib\spring-boot-autoconfigure-2.7.1.jar;%APP_HOME%\lib\spring-boot-actuator-2.7.1.jar;%APP_HOME%\lib\spring-boot-2.7.1.jar;%APP_HOME%\lib\spring-context-5.3.21.jar;%APP_HOME%\lib\spring-expression-5.3.21.jar;%APP_HOME%\lib\spring-aop-5.3.21.jar;%APP_HOME%\lib\spring-beans-5.3.21.jar;%APP_HOME%\lib\spring-core-5.3.21.jar;%APP_HOME%\lib\snakeyaml-1.30.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.13.3.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.13.3.jar;%APP_HOME%\lib\jackson-annotations-2.13.3.jar;%APP_HOME%\lib\jackson-core-2.13.3.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.13.3.jar;%APP_HOME%\lib\jackson-databind-2.13.3.jar;%APP_HOME%\lib\HdrHistogram-2.1.12.jar;%APP_HOME%\lib\LatencyUtils-2.0.3.jar;%APP_HOME%\lib\tomcat-annotations-api-9.0.64.jar;%APP_HOME%\lib\hamcrest-core-2.2.jar;%APP_HOME%\lib\opentest4j-1.2.0.jar;%APP_HOME%\lib\logback-classic-1.2.11.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.36.jar;%APP_HOME%\lib\slf4j-api-1.7.36.jar;%APP_HOME%\lib\jcommander-1.78.jar;%APP_HOME%\lib\jquery-3.5.1.jar;%APP_HOME%\lib\spring-jcl-5.3.21.jar;%APP_HOME%\lib\hamcrest-2.2.jar;%APP_HOME%\lib\logback-core-1.2.11.jar


@rem Execute ems-infinira-2
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %EMS_INFINIRA_2_OPTS%  -classpath "%CLASSPATH%" com.infinira.ems.EMSApplication %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable EMS_INFINIRA_2_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%EMS_INFINIRA_2_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
