# tmsandbox_project

**Objective of the project**

For the API = https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false
Validate the acceptance criteria below,
Name = "Carbon credits"
CanRelist = true
The Promotions element with Name = "Gallery" has a Description that contains the text "Good position in category"

**Project set up**

1. Download and install JAVA (I have installed JDK 23.0.2)
* Visit website, https://www.oracle.com/in/java/ Click on the “Download Java” icon.
* Now you can see the latest version is JDK 23 and there are options for Linux, macOS, and Windows. 
* Click the x64 Installer option to download the .exe file as per the operating system.
* Go to Downloads and double-click on that downloaded jdk-23_windows-x64_bin.exe file. So now Java Installation Wizard get open and then click Next button.
* Go to system properties in your computer, set up path variable for java. C:\Program Files\Java\jdk-23\bin and JAVA_HOME variable to where your jdk is. C:\Program Files\Java\jdk-23
* Open up command prompt and check the JAVA version. java --version

2. Download and install maven (I have installed Apache Maven 3.9.9 )
* Visit website https://maven.apache.org/download.cgi and download bin.zip for maven
* Copy the maven folder and paste it in program files of your computer
* Go to system properties in your computer, set up path variable for maven. C:\maven\apache-maven-3.9.9-bin and MAVEN_HOME variable to where your jdk is. C:\maven\apache-maven-3.9.9-bin\bin
* Open up command prompt and check the maven version. mvn -version

3. Download and install preferred IDE

4. Download and install git
* Visit website https://git-scm.com/downloads and download git as per operating system 

5. Create a Git hub repository

6. Create a Git hub project with a read me file

7. Open the project folder with your ide(as a maven project)

8. In your IDE set the JDK version and maven home path

9. Run command "mvn clean install" in your ide terminal. This will clean and install each module 

10. Add sonar qube plugin for code scanning

11.Download and install postman for API validation if necessary

12. JSON to JAVA converter -> https://json2csharp.com/code-converters/json-to-pojo

13. maven dependencies added in the POM.xml
* testng dependency for test framework   
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.11.0</version>
    <scope>test</scope>
    </dependency>

* rest-assured dependency for REST API test automation   
  <dependency>
  <groupId>io.rest-assured</groupId>
  <artifactId>rest-assured</artifactId>
  <version>5.5.1</version>
  <scope>test</scope>
  </dependency>
* maven sure fire plugin added for parallel execution
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.5.2</version>
      </plugin>
    </plugins>


**Project structure**

1. src/main/java/com.pojo package has these four test classes
Category, Fees, ListingFeeTier and Promotion
Category class contains other three classes inside it.
Returned JSON response is converted to Category object
2. src/test/java/com.api
contains, CategoryTest and NegativeCategoryTest classes
CategoryTest has test cases to test the response that are associated with GET Category endpoint
NegativeCategoryTest has all the negative test cases that are associated with GET Category endpoint
3. src/test/java/com.utils
contains, ServiceUtils class calls the endpoints and returns the API response to the test class
4. pom.xml
contains the maven dependencies
5. testng.xml
adds configuarations to run tests as suites
6. maven-test.yml:
Step	Description:
*on: push & pull_request- Runs tests on every push and PR to main.

*runs-on: ubuntu-latest: Uses Ubuntu as the environment.

*actions/checkout@v4: Pulls the latest code from the repo.

*actions/setup-java@v3:	Installs Java 17 and enables Maven caching for faster builds.

*mvn clean test:	Runs all TestNG tests in the project.

*actions/upload-artifact@v4:	Uploads test reports (target/surefire-reports/) for debugging.


